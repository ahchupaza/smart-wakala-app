package com.example.smartwakala;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartwakala.models.Wakala;
import com.example.smartwakala.utils.BasicJobs;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import io.realm.Realm;

import static io.realm.Realm.getDefaultInstance;

public class UserDashboardActivity extends AppCompatActivity {

    String wakalaNumber;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Realm.init(UserDashboardActivity.this);
        realm = getDefaultInstance();

        ImageView profilePicture = (ImageView) findViewById(R.id.dashboard_user_profile_picture);
        Button miamalaButton = (Button) findViewById(R.id.dashboard_miamala_button);
        Button mapatoButton = (Button) findViewById(R.id.dashboard_mapato_button);
        Button watejaButton = (Button) findViewById(R.id.dashboard_wateja_button);
        Button takwimuButton = (Button) findViewById(R.id.dashboard_takwimu_button);
        Button vidokezoButton = (Button) findViewById(R.id.dashboard_vidokezo_button);
        Button maoniButton = (Button) findViewById(R.id.dashboard_maoni_button);
        Button settingsButton = (Button) findViewById(R.id.dashboard_settings_button);
        Button logoutButton = (Button) findViewById(R.id.dashboard_ondoka_button);


        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, UserProfileActivity.class));
            }
        });

        miamalaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, LoginNetSelectionActivity.class));
            }
        });

        mapatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, LoginNetSelectionActivity.class));
            }
        });

        watejaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, LoginNetSelectionActivity.class));
            }
        });

        takwimuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, LoginNetSelectionActivity.class));
            }
        });

        vidokezoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, VidokezoActivity.class));
            }
        });

        maoniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, MaoniActivity.class));
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this, SettingsActivity.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserDashboardActivity.this, LoginActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        getWakalaNumber();
    }

    private void getWakalaNumber() {

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Users");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                //for loop to retrieve the child node
                for (DataSnapshot childSnapshot: snapshot.getChildren()) {

                    wakalaNumber = childSnapshot.child("Contact").getValue().toString();

                    Log.d("TAG", "onDataChange UserDashboard: " + wakalaNumber);

                    fetchWakalaData(wakalaNumber);

                    Log.d("Main Activity", "onDataChange UserDashboard: " + wakalaNumber);

                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void fetchWakalaData(String num) {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Wakala");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                //for loop to retrieve the child node
                for (DataSnapshot childSnapshot: snapshot.getChildren()) {

                    String number = childSnapshot.child("SIM_No").getValue().toString();

                    if (number.equals(num)) {
                        Log.d("TAG", "fetchWakalaDAta: " + number );
                        Log.d("TAG", "fetchWakalaDAta: " + num);

                        Wakala wakala = childSnapshot.getValue(Wakala.class);

                        Log.d("TAG", "onDataChange UserDashboard: " + wakala.getFirstName());


                        try {

                            BasicJobs bj = new BasicJobs();
                            bj.saveData(wakala, UserDashboardActivity.this);

                        } finally {
                            if (realm != null) {
                                realm.close();
                            }

                        }

                        //print to logcat
                        Log.d("TAG", "onDataChange: " + childSnapshot);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}