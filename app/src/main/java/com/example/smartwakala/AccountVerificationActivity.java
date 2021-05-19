package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountVerificationActivity extends AppCompatActivity {

    Button accVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_verification);

        accVerificationButton = (Button)findViewById(R.id.user_acc_verification_hakiki_button);
        accVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForgotPasswordActivity = new Intent(AccountVerificationActivity.this, ForgotPasswordActivity.class);
                startActivity(goToForgotPasswordActivity);
            }
        });
    }
}