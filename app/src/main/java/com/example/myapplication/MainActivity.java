package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.ImplicitDirectBootViolation;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText emailtv,passtv;
    Button btnsignin, btnsignup;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        emailtv = findViewById(R.id.editTextTextEmailAddress);
        passtv = findViewById(R.id.editTextTextPassword);
        btnsignin = findViewById(R.id.button);
        btnsignup = findViewById(R.id.button2);

        btnsignup.setOnClickListener(view -> {
            createUser();
        });

        btnsignin.setOnClickListener(view -> {
            login();
        });


    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            startActivity(new Intent(MainActivity.this, dashboard.class));
        }
    }

    private void createUser() {
        String email = emailtv.getText().toString();
        String password = passtv.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailtv.setError("Email cannot be empty");
            emailtv.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            passtv.setError("Password cannot be empty");
            passtv.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"User registered succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, dashboard.class));
                    }
                }
            });
        }

    }

    private void login() {
        String email = emailtv.getText().toString();
        String password = passtv.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailtv.setError("Email cannot be empty");
            emailtv.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            passtv.setError("Password cannot be empty");
            passtv.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"User signed in succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, dashboard.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this,"sign in failed...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
