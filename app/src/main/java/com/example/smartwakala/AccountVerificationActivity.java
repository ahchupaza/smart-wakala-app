package com.example.smartwakala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class AccountVerificationActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private EditText resetPasswordEmail;
    private ProgressBar progressBar;
    private Button verifyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_verification);

        auth = FirebaseAuth.getInstance();
        resetPasswordEmail = findViewById(R.id.reset_password_email);
        progressBar = findViewById(R.id.acc_verification_loading);

        verifyAccount = findViewById(R.id.reset_password_email_submit_button);
        verifyAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String email = resetPasswordEmail.getText().toString().trim();

        if (email.isEmpty()){
            resetPasswordEmail.setError("Haukujaza eneo hili!");
            resetPasswordEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            resetPasswordEmail.setError("Haukujaza barua-pepe halali!");
            resetPasswordEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    startActivity(new Intent(AccountVerificationActivity.this, ForgotPasswordActivity.class));
                }
                else {
                    Toast.makeText(AccountVerificationActivity.this, "Haujafanikiwa, tafadhali jaribu tena!", Toast.LENGTH_LONG).show();

                }
                progressBar.setVisibility(View.GONE);
            }

        });
    }
}