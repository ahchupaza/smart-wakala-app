package com.example.smartwakala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference dbRef;
    private String userID;

    private TextView emailTextView;
    private TextView phoneNoTextView;
    private TextView usernameTextView;

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        emailTextView = findViewById (R.id.user_profile_email_data);
        phoneNoTextView =  findViewById (R.id.user_profile_phone_no_data);
        usernameTextView =  findViewById (R.id.user_profile_username_data);

        okButton = (Button) findViewById(R.id.user_profile_continue_button);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userID = user.getUid();
        }
        dbRef = FirebaseDatabase.getInstance().getReference("Users").child(userID);

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String userProfileEmail = dataSnapshot.child("Email").getValue().toString();
                    String userProfilePhone = dataSnapshot.child("Contact").getValue().toString();
                    String userProfileUsername = dataSnapshot.child("Username").getValue().toString();

                    emailTextView.setText(userProfileEmail);
                    phoneNoTextView.setText(userProfilePhone);
                    usernameTextView.setText(userProfileUsername);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfileActivity.this, "Hakuna ingizo..!", Toast.LENGTH_LONG).show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, UserDashboardActivity.class));
            }
        });

    }
}

