package com.example.learn_smartcultureappcontent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {

    EditText id_et, pw_et;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        id_et = findViewById(R.id.id_et);
        pw_et = findViewById(R.id.pw_et);
        signup_btn = findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVaild()) {
                    new HttpAsyncTask().execute();
                }
            }
        });
    }

    private boolean checkVaild() {
        if (id_et.getText().toString().length() <= 5) {
            Toast.makeText(this, "아이디는 5자 이상", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pw_et.getText().toString().length() <= 5) {
            Toast.makeText(this, "비밀번호는 5자 이상", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    class HttpAsyncTask extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            String result = null;

            HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme("http").host("13.209.236.238")
                        .addPathSegment("user_join.php")
                        .addQueryParameter("userid", id_et.getText().toString())
                        .addQueryParameter("passwd", pw_et.getText().toString())
                        .build();

            try {
                Request req = new Request.Builder().url(httpUrl).build();
                Response res = client.newCall(req).execute();
                result = res.body().string();
                // Log.d(tag, "doInBackground: " + res.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s.contains("failed")) {
                Log.d("SignupActivity", "failed");
            } else {
                Intent intent = new Intent();
                intent.putExtra("id", id_et.getText().toString());
                intent.putExtra("pw", pw_et.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
