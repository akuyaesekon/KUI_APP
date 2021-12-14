package com.example.kuiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kuiapp.databinding.ActivityAuthDashboardBinding;

public class AuthDashboardActivity extends AppCompatActivity {

    ActivityAuthDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_dashboard);

        binding = ActivityAuthDashboardBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthDashboardActivity.this, RegisterACtivity.class);
                startActivity(intent);
            }
        });

        binding.buttonBoardSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthDashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}