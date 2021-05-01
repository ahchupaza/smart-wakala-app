package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterNetSelectionActivity extends AppCompatActivity {

    Button tigoPesaButton2;
    Button airtelMoneyButton2;
    Button haloPesaButton2;
    Button mPesaButton2;
    Button tPesaButton2;
    Button ezyPesaButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_net_selection);

        tigoPesaButton2 = (Button)findViewById(R.id.tigo_pesa_button2);
        tigoPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTigoPesaNumVerification = new Intent(RegisterNetSelectionActivity.this, TigoPesaNumVerificationActivity.class);
                startActivity(goToTigoPesaNumVerification);
            }
        });

        airtelMoneyButton2 =(Button) findViewById(R.id.airtel_money_button2);
        airtelMoneyButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAirtelMoney = new Intent(RegisterNetSelectionActivity.this, AirtelMoneyActivity.class);
                startActivity(goToAirtelMoney);
            }
        });

        haloPesaButton2 = (Button)findViewById(R.id.halo_pesa_button2);
        haloPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHaloPesa = new Intent(RegisterNetSelectionActivity.this, HaloPesaActivity.class);
                startActivity(goToHaloPesa);
            }
        });

        mPesaButton2 = (Button)findViewById(R.id.m_pesa_button2);
        mPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMPesa = new Intent(RegisterNetSelectionActivity.this, MpesaActivity.class);
                startActivity(goToMPesa);
            }
        });

        tPesaButton2 = (Button)findViewById(R.id.t_pesa_button2);
        tPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTPesa = new Intent(RegisterNetSelectionActivity.this, TpesaActivity.class);
                startActivity(goToTPesa);
            }
        });

        ezyPesaButton2 = (Button)findViewById(R.id.ezy_pesa_button2);
        ezyPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEzyPesa = new Intent(RegisterNetSelectionActivity.this, EzyPesaActivity.class);
                startActivity(goToEzyPesa);
            }
        });
    }
}
