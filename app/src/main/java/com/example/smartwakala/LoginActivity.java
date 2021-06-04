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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView forgotPasswordText, registerText ;
    private EditText userEmail, userPassword1;
    private ProgressBar progressBar;
    private Button loginButtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        forgotPasswordText = (TextView) findViewById(R.id.user_forgot_password_text);
        forgotPasswordText.setOnClickListener(this);

        registerText = (TextView) findViewById(R.id.user_register_text);
        registerText.setOnClickListener(this);

        userEmail = (EditText) findViewById(R.id.login_email);
        userPassword1 = (EditText) findViewById(R.id.login_password);
        progressBar = (ProgressBar) findViewById(R.id.login_loading);

        loginButtton = (Button)findViewById(R.id.login_button);
        loginButtton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_forgot_password_text:
                Intent goToForgotPassword = new Intent(LoginActivity.this, AccountVerificationActivity.class);
                startActivity(goToForgotPassword);
                break;

            case R.id.user_register_text:
                Intent goToRegistration = new Intent(LoginActivity.this, RegisterNetSelectionActivity.class);
                startActivity(goToRegistration);
                break;

            case R.id.login_button:
                loginUser();
        }
    }

    private void loginUser() {
        String email = userEmail.getText().toString().trim();
        String password = userPassword1.getText().toString().trim();

        if (userEmail.getText().toString().trim().length() == 0){
            userEmail.setError("Haukujaza eneo hili!");
            userEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Haukuingiza barua-pepe halali!");
            userEmail.requestFocus();
            return;
        }
        if (userPassword1.getText().toString().trim().length() == 0){
            userPassword1.setError("Haukujaza eneo hili!");
            userPassword1.requestFocus();
            return;
        }
        if (userPassword1.length() < 8){
            userPassword1.setError("Password isipungue 8");
            userPassword1.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if (user.isEmailVerified()){
                                startActivity(new Intent(LoginActivity.this, LoginNetSelectionActivity.class));
                                progressBar.setVisibility(View.GONE);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Tafadhali, thibitisha kwanza anwani yako ya barua pepe!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Haujafanikisha, hakikisha taarifa zako na ujaribu tena!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
    }

}