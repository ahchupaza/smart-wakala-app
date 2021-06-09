package com.example.smartwakala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Button miamalaButton = (Button) findViewById(R.id.dashboard_miamala_button);
        Button mapatoButton = (Button) findViewById(R.id.dashboard_mapato_button);
        Button watejaButton = (Button) findViewById(R.id.dashboard_wateja_button);
        Button takwimuButton = (Button) findViewById(R.id.dashboard_takwimu_button);
        Button vidokezoButton = (Button) findViewById(R.id.dashboard_vidokezo_button);
        Button maoniButton = (Button) findViewById(R.id.dashboard_maoni_button);
        Button settingsButton = (Button) findViewById(R.id.dashboard_settings_button);
        Button ondokaButton = (Button) findViewById(R.id.dashboard_ondoka_button);


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

        ondokaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserDashboardActivity.this, LoginActivity.class));
            }
        });

    }

}