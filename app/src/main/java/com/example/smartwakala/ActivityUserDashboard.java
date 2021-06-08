package com.example.smartwakala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityUserDashboard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        ImageView wekapesaImage = (ImageView) findViewById(R.id.wekapesa);
        ImageView mapatoImage = (ImageView) findViewById(R.id.mapato);
        ImageView takwimuImage = (ImageView) findViewById(R.id.takwimu);
        ImageView historiaImage = (ImageView) findViewById(R.id.historia);
        ImageView profileImage = (ImageView) findViewById(R.id.profile);
        ImageView kuhusuImage = (ImageView) findViewById(R.id.taarifa);
        ImageView vidokezoImage = (ImageView) findViewById(R.id.hint);
        ImageView tokaImage = (ImageView) findViewById(R.id.toka);


        wekapesaImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        mapatoImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        takwimuImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        historiaImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        kuhusuImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        vidokezoImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);

            }
        });

        tokaImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToLogInActivity = new Intent(ActivityUserDashboard.this, LoginActivity.class);
                startActivity(goToLogInActivity);

            }
        });

    }

}