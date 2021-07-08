package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartwakala.airtel.AirtelMoneyNumVerificationActivity;
import com.example.smartwakala.halotel.HaloPesaNumVerificationActivity;
import com.example.smartwakala.tigo.TigoPesaNumVerificationActivity;
import com.example.smartwakala.ttcl.TPesaNumVerificationActivity;
import com.example.smartwakala.vodacom.MPesaNumVerificationActivity;
import com.example.smartwakala.zantel.EzyPesaNumVerificationActivity;

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
                startActivity(new Intent(RegisterNetSelectionActivity.this, TigoPesaNumVerificationActivity.class));
            }
        });

        airtelMoneyButton2 =(Button) findViewById(R.id.airtel_money_button2);
        airtelMoneyButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNetSelectionActivity.this, AirtelMoneyNumVerificationActivity.class));
            }
        });

        haloPesaButton2 = (Button)findViewById(R.id.halo_pesa_button2);
        haloPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNetSelectionActivity.this, HaloPesaNumVerificationActivity.class));
            }
        });

        mPesaButton2 = (Button)findViewById(R.id.m_pesa_button2);
        mPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNetSelectionActivity.this, MPesaNumVerificationActivity.class));
            }
        });

        tPesaButton2 = (Button)findViewById(R.id.t_pesa_button2);
        tPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNetSelectionActivity.this, TPesaNumVerificationActivity.class));
            }
        });

        ezyPesaButton2 = (Button)findViewById(R.id.ezy_pesa_button2);
        ezyPesaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNetSelectionActivity.this, EzyPesaNumVerificationActivity.class));
            }
        });
    }
}
