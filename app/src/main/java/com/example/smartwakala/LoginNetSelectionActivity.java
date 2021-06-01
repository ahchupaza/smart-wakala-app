package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        tigoPesaButton = (Button)findViewById(R.id.tigo_pesa_button);
        tigoPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTigoPesa = new Intent(LoginNetSelectionActivity.this, TigoPesaMainActivity.class);
                startActivity(goToTigoPesa);
            }
        });

        airtelMoneyButton =(Button) findViewById(R.id.airtel_money_button);
        airtelMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAirtelMoney = new Intent(LoginNetSelectionActivity.this, AirtelMoneyMainActivity.class);
                startActivity(goToAirtelMoney);
            }
        });

        haloPesaButton = (Button)findViewById(R.id.halo_pesa_button);
        haloPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHaloPesa = new Intent(LoginNetSelectionActivity.this, HaloPesaActivity.class);
                startActivity(goToHaloPesa);
            }
        });

        mPesaButton = (Button)findViewById(R.id.m_pesa_button);
        mPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMPesa = new Intent(LoginNetSelectionActivity.this, MPesaActivity.class);
                startActivity(goToMPesa);
            }
        });

        tPesaButton = (Button)findViewById(R.id.t_pesa_button);
        tPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTPesa = new Intent(LoginNetSelectionActivity.this, TPesaActivity.class);
                startActivity(goToTPesa);
            }
        });

        ezyPesaButton = (Button)findViewById(R.id.ezy_pesa_button);
        ezyPesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEzyPesa = new Intent(LoginNetSelectionActivity.this, EzyPesaActivity.class);
                startActivity(goToEzyPesa);
            }
        });
    }
}
