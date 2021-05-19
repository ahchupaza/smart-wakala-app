package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordResetSuccessActivity extends AppCompatActivity {

    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset_success);

        okButton = (Button) findViewById(R.id.user_password_reset_success_ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoginActivity = new Intent(PasswordResetSuccessActivity.this, LoginActivity.class);
                startActivity(goToLoginActivity);
            }
        });
    }
}