package com.example.sjsu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.dinuscxj.progressbar.CircleProgressBar;

public class purchase_detail extends AppCompatActivity {

    private static final String DEFAULT_PATTERN = "%d%%";

    CircleProgressBar circleProgressBar;

    ImageView detail5;
    ImageButton joinbtn;
    boolean i = true;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_detail);

        Intent intent = getIntent();

        circleProgressBar=findViewById(R.id.circle_bar);

        circleProgressBar.setProgress(80);  // 해당 퍼센트를 적용

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        //조인 버튼
        detail5 = findViewById(R.id.detail5);
        joinbtn = findViewById(R.id.joinbtn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i == true) {
                    detail5.setImageResource(R.drawable.detail5);
                    i = false;
                    circleProgressBar.setProgress(80);
                } else {
                    detail5.setImageResource(R.drawable.detail6);
                    i=true;
                    circleProgressBar.setProgress(100);
                }
            }
        });
    }

}
