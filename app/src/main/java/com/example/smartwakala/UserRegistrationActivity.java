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

import java.lang.String.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView termsAndConditionsText;
    private EditText userContact, userEmail, userUsername, userPassword, userPassword2;
    private ProgressBar progressBar;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        mAuth = FirebaseAuth.getInstance();

        termsAndConditionsText = (TextView) findViewById(R.id.terms_and_conditions_text);
        termsAndConditionsText.setOnClickListener(this);

        userContact = (EditText) findViewById(R.id.user_register_contact);
        userEmail = (EditText) findViewById(R.id.user_register_email);
        userUsername = (EditText) findViewById(R.id.register_username);
        userPassword = (EditText) findViewById(R.id.register_password);
        userPassword2 = (EditText) findViewById(R.id.register_confirm_password);
        progressBar = (ProgressBar) findViewById(R.id.register_loading);

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.terms_and_conditions_text:
                Intent goToTermsAndConditions = new Intent(UserRegistrationActivity.this, TermsAndConditionsActivity.class);
                startActivity(goToTermsAndConditions);
                break;

            case R.id.register_button:
                registerUser();
        }
    }

    private void registerUser() {
        String contact = userContact.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String username = userUsername.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        String password2 = userPassword2.getText().toString().trim();

        if (contact.isEmpty()){
            userContact.setError("Haukujaza eneo hili!");
            userContact.requestFocus();
            return;
        }
        if (email.isEmpty()){
            userEmail.setError("Haukujaza eneo hili!");
            userEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Haukujaza barua-pepe halali!");
            userEmail.requestFocus();
            return;
        }
        if (username.isEmpty()){
            userUsername.setError("Haukujaza eneo hili!");
            userUsername.requestFocus();
            return;
        }
        if (password.isEmpty()){
            userPassword.setError("Haukujaza eneo hili!");
            userPassword.requestFocus();
            return;
        }
        if (password.length() < 8){
            userPassword.setError("Password isipungue 8");
            userPassword.requestFocus();
            return;
        }
        if (password2.isEmpty()){
            userPassword2.setError("Haukujaza eneo hili!");
            userPassword2.requestFocus();
            return;
        }
        if (password2.length() < 8){
            userPassword2.setError("Password isipungue 8");
            userPassword2.requestFocus();
            return;
        }
        if (!password.equals(password2)){
            userPassword2.setError("Password hazifanani");
            userPassword2.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email ,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user =  new  User(userContact, userEmail, userUsername, userPassword);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                        assert user != null;
                                        user.sendEmailVerification();

                                        startActivity(new Intent(UserRegistrationActivity.this, RegistrationSuccessActivity.class));
                                        progressBar.setVisibility(View.GONE);

                                    } else {
                                        Toast.makeText(UserRegistrationActivity.this, "Haujafanikisha, tafadhali jaribu tena!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(UserRegistrationActivity.this, "Haujafanikisha, tafadhali jaribu tena!", Toast.LENGTH_LONG).show();
                            }
                        }

                });
    }
}