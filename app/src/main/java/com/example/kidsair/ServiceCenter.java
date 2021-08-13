package com.example.kidsair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class ServiceCenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_center);

        FrameLayout btn_notice = findViewById(R.id.notice);
        FrameLayout btn_faq = findViewById(R.id.faq);

        FrameLayout btn_policy1 = findViewById(R.id.policy_1);
        FrameLayout btn_policy2 = findViewById(R.id.policy_2);
        FrameLayout btn_policy3 = findViewById(R.id.policy_3);
        FrameLayout btn_policy4 = findViewById(R.id.policy_4);
        FrameLayout btn_policy5 = findViewById(R.id.policy_5);

        btn_notice.setOnClickListener();
    }
}