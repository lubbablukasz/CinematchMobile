package com.example.aplikacja_randkowa; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextNewUsername;
    private EditText editTextNewPassword;
    private Button buttonSignUp;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rejestracja);

        editTextNewUsername = findViewById(R.id.editTextNewUsername);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        editTextNewPassword = findViewById(R.id.editTextNewPassword2);
        buttonSignUp = findViewById(R.id.signup);
        buttonSignIn = findViewById(R.id.signin);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        buttonSignIn = findViewById(R.id.signin);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signUp() {
        String newUsername = editTextNewUsername.getText().toString().trim();
        String newPassword = editTextNewPassword.getText().toString().trim();

        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            Toast.makeText(SignupActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(SignupActivity.this, "Sign-up successful", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
