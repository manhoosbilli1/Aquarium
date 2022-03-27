package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    Button btnsignout, btnsettings, btnfeedmanual;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();

        btnsignout = findViewById(R.id.button7);
        btnsettings = findViewById(R.id.button6);
        btnfeedmanual = findViewById(R.id.button8);
        btnsignout.setOnClickListener(view -> {
            mAuth.signOut();
            Toast.makeText(dashboard.this,"Signing out...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(dashboard.this, MainActivity.class));
        });

        btnsettings.setOnClickListener(view -> {
            startActivity(new Intent(dashboard.this, settings.class));
        });

        btnfeedmanual.setOnClickListener(view -> {
            Toast.makeText(dashboard.this,"Feeding manually now...", Toast.LENGTH_SHORT).show();
        });








    }
}