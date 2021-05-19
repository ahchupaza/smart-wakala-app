package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextView registerText;
    TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoginNetSelectionActivity = new Intent(LoginActivity.this, LoginNetSelectionActivity.class);
                startActivity(goToLoginNetSelectionActivity);
            }
        });

        registerText = (TextView) findViewById(R.id.user_register_text);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegisterNetSelectionActivity = new Intent(LoginActivity.this, RegisterNetSelectionActivity.class);
                startActivity(goToRegisterNetSelectionActivity);
            }
        });

        forgotPasswordText = (TextView) findViewById(R.id.user_forgot_password_text);
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForgotPasswordActivity = new Intent(LoginActivity.this, AccountVerificationActivity.class);
                startActivity(goToForgotPasswordActivity);
            }
        });

    }
}