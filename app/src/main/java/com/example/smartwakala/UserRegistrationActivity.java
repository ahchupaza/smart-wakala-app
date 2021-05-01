package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserRegistrationActivity extends AppCompatActivity {

    Button registerButton;
    TextView termsAndConditionsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTwoFactorAuthenticationActivity = new Intent(UserRegistrationActivity.this, TwoFactorAuthenticationActivity.class);
                startActivity(goToTwoFactorAuthenticationActivity);
            }
        });

        termsAndConditionsText = (TextView) findViewById(R.id.terms_and_conditions_text);
        termsAndConditionsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTermsAndConditionsActivity = new Intent(UserRegistrationActivity.this,TermsAndConditionsActivity.class);
                startActivity(goToTermsAndConditionsActivity);
            }
        });

    }
}