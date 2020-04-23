package com.example.learn_smartcultureappcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                    Intent intent = new Intent();
                    intent.putExtra("id", id_et.getText().toString());
                    intent.putExtra("pw", pw_et.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
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
}
