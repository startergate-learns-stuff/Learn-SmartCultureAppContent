package com.example.learn_smartcultureappcontent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signin_button, signup_button;
    ImageView main_iv;
    EditText id_signin, pw_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signin_button = findViewById(R.id.signin_button);
        signup_button = findViewById(R.id.signup_button);
        main_iv = findViewById(R.id.main_iv);
        id_signin = findViewById(R.id.id_signin);
        pw_signin = findViewById(R.id.pw_signin);



        signin_button.setOnClickListener(this);

        signup_button.setOnClickListener(this);
        main_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_button:
                // Toast.makeText(MainActivity.this, "signup", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivityForResult(intent, 100);
                break;
            case R.id.signin_button:
                Toast.makeText(MainActivity.this, "signin", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_iv:
                Toast.makeText(MainActivity.this, "main image", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                String id = data.getStringExtra("id");
                String pw = data.getStringExtra("pw");

                id_signin.setText(id);
                pw_signin.setText(pw);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signup_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_menu:
                Toast.makeText(this, "add menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.refresh_menu:
                Toast.makeText(this, "refresh menu", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
