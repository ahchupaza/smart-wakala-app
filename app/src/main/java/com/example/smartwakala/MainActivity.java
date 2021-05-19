package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button continueButton;
    TextView userHelpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueButton = (Button) findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(goToLoginActivity);
            }
        });

        userHelpText = (TextView) findViewById(R.id.user_help_text);
        userHelpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToUserHelpActivity = new Intent(MainActivity.this, UserHelpActivity.class);
                startActivity(goToUserHelpActivity);
            }
        });


    }

}
