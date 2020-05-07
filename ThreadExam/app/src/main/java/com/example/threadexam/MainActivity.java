package com.example.threadexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView progress_tv;
    ProgressBar progressBar;
    Button start_btn;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress_tv = findViewById(R.id.progress_tv);
        progressBar = findViewById(R.id.progressBar);
        start_btn = findViewById(R.id.start_btn);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoDownload();
            }
        });
    }

    private void DoDownload() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final int fi = i;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progress_tv.setText(fi + "%");
                            progressBar.setProgress(fi);
                        }
                    });
                }
            }
        }).start();
    }
}
