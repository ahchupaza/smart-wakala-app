package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button resetPasswordCodeSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        resetPasswordCodeSubmitButton = (Button) findViewById(R.id.user_password_reset_request_button);
        resetPasswordCodeSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPasswordResetActivity = new Intent(ForgotPasswordActivity.this, PasswordResetActivity.class);
                startActivity(goToPasswordResetActivity);
            }
        });
    }
}