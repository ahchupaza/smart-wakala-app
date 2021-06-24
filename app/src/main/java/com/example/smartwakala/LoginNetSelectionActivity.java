package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class LoginNetSelectionActivity extends AppCompatActivity {

    Button tigoPesaButton;
    Button airtelMoneyButton;
    Button haloPesaButton;
    Button mPesaButton;
    Button tPesaButton;
    Button ezyPesaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_net_selection);

        tigoPesaButton = findViewById(R.id.tigo_pesa_button);
        tigoPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, TigoPesaMainActivity.class));
            }
        });

        airtelMoneyButton = findViewById(R.id.airtel_money_button);
        airtelMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, AirtelMoneyMainActivity.class));
            }
        });

        haloPesaButton = findViewById(R.id.halo_pesa_button);
        haloPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, HaloPesaActivity.class));
            }
        });

        mPesaButton = findViewById(R.id.m_pesa_button);
        mPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, MPesaActivity.class));
            }
        });

        tPesaButton = findViewById(R.id.t_pesa_button);
        tPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, TPesaActivity.class));
            }
        });

        ezyPesaButton = findViewById(R.id.ezy_pesa_button);
        ezyPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginNetSelectionActivity.this, EzyPesaActivity.class));
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return true;}

    }
