package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent goToLogin = new Intent( MainActivity.this,LoginActivity.class);
        startActivity(goToLogin);
    }
}
