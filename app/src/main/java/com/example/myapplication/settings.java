package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class settings extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnback = findViewById(R.id.button3);

        btnback.setOnClickListener(view -> {
            startActivity(new Intent(settings.this, dashboard.class));
        });
    }
}