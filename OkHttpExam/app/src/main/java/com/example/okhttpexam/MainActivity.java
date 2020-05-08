package com.example.okhttpexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    List<Weather> weatherList = new ArrayList<>();
    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpAsyncTask().execute("https://goo.gl/eIXu9l");
    }

    class HttpAsyncTask extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];

            try {
                Request req = new Request.Builder().url(strUrl).build();
                Response res = client.newCall(req).execute();
                // Log.d(tag, "doInBackground: " + res.body().string());
            } catch (IOException e) {
                 e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            rv = findViewById(R.id.rv);
            linearLayoutManager = new LinearLayoutManager(MainActivity.this);

            // Log.d(tag, "onPostExecute: " + s);

            try {
                JSONArray jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Log.d(TAG, "onPostExecute: " + jsonObject.getString("country"));

                    String country = jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");

                    Weather w = new Weather(country, weather, temperature);
                    weatherList.add(w);
                }

                weatherAdapter = new WeatherAdapter(weatherList);

                rv.setLayoutManager(linearLayoutManager);
                rv.setAdapter(weatherAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
