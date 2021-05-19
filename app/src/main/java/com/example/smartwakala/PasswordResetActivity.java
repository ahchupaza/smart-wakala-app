package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordResetActivity extends AppCompatActivity {

    Button newPasswordSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        newPasswordSubmitButton = (Button) findViewById(R.id.user_new_password_submit_button);
        newPasswordSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoginActivity = new Intent(PasswordResetActivity.this, PasswordResetSuccessActivity.class);
                startActivity(goToLoginActivity);
            }
        });
    }
}