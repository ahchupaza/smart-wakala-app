package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoFactorAuthenticationActivity extends AppCompatActivity {

    Button otpSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_factor_authentication);

        otpSubmitButton = (Button) findViewById(R.id.user_otp_submit_button);
        otpSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TwoFactorAuthenticationActivity.this, RegistrationSuccessActivity.class));
            }
        });
    }
}