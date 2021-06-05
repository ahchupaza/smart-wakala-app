package com.example.smartwakala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityUserDashboard extends AppCompatActivity {

    private ImageView wekapesa, mapato,takwimu,historia,profile,toka,taarifa,hint;

    public ActivityUserDashboard() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);


        ImageView wekapesaImage = (ImageView) findViewById(R.id.wekapesa);
        wekapesaImage.setOnClickListener((View.OnClickListener) this);

        ImageView mapatoImage = (ImageView) findViewById(R.id.mapato);
        mapatoImage.setOnClickListener((View.OnClickListener) this);

        ImageView takwimuImage = (ImageView) findViewById(R.id.takwimu);
        takwimuImage.setOnClickListener((View.OnClickListener) this);

        ImageView historiaImage = (ImageView) findViewById(R.id.historia);
        historiaImage.setOnClickListener((View.OnClickListener) this);

        ImageView profileImage = (ImageView) findViewById(R.id.profile);
        profileImage.setOnClickListener((View.OnClickListener) this);

        ImageView kuhuhuImage = (ImageView) findViewById(R.id.taarifa);
        kuhuhuImage .setOnClickListener((View.OnClickListener) this);

        ImageView vidokezoImage = (ImageView) findViewById(R.id.hint);
        vidokezoImage.setOnClickListener((View.OnClickListener) this);

        ImageView tokaImage = (ImageView) findViewById(R.id.toka);
        tokaImage.setOnClickListener((View.OnClickListener) this);


    }
    public void onClick(View view) {
        
                Intent goToNetselectionActivity = new Intent(ActivityUserDashboard.this, LoginNetSelectionActivity.class);
                startActivity(goToNetselectionActivity);
    }

}