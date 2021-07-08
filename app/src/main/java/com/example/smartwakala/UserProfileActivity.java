package com.example.smartwakala;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;
import java.util.UUID;

public class UserProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference dbRef;
    private String userID;

    private FirebaseStorage storage;
    private StorageReference storageRef;

//    private TextView nameTextView;
//    private TextView dobTextView;
    private TextView emailTextView;
    private TextView phoneNoTextView;
    private TextView usernameTextView;
    private ImageView profilePic;
    public Uri imageUri;

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

//        nameTextView =  findViewById (R.id.user_profile_name_data);
//        dobTextView =  findViewById (R.id.user_profile_dob_data);
        emailTextView = findViewById (R.id.user_profile_email_data);
        phoneNoTextView =  findViewById (R.id.user_profile_phone_no_data);
        usernameTextView =  findViewById (R.id.user_profile_username_data);
        profilePic =  findViewById (R.id.agent_profile_picture);

        okButton = (Button) findViewById(R.id.user_profile_continue_button);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userID = user.getUid();
        }
        dbRef = FirebaseDatabase.getInstance().getReference("Users").child(userID);

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                String userProfileName = Objects.requireNonNull(dataSnapshot.child("Full_name").getValue()).toString();
//                String userProfileDob = Objects.requireNonNull(dataSnapshot.child("DoB").getValue()).toString();
                String userProfileEmail = Objects.requireNonNull(dataSnapshot.child("Email").getValue()).toString();
                String userProfilePhone = Objects.requireNonNull(dataSnapshot.child("Contact").getValue()).toString();
                String userProfileUsername = Objects.requireNonNull(dataSnapshot.child("Username").getValue()).toString();

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

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choosePicture();
            }
        });

    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("Images/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null);
        imageUri = data.getData();
        profilePic.setImageURI(imageUri);

        uploadPicture();
    }

    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Picha inapakiwa...");
        pd.show();

        final String randomKey = UUID.randomUUID().toString();
        // Create a reference to "mountains.jpg"
        StorageReference mountainsRef = storageRef.child("Images/" + randomKey);
        mountainsRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), "Picha imepakiwa!", Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), "Picha haijapakiwa", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull @org.jetbrains.annotations.NotNull UploadTask.TaskSnapshot snapshot) {
//                        double progressPercentage = (100.00 * taskSnapshot.getBytesTransfered() / taskSnapshot.getTotalBytesCount());
//                        pd.setMessage("Progress: " + (int) progressPercentage + "%");
                    }
                });
    }
}

