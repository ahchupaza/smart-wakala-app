package com.example.smartwakala.zantel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartwakala.R;

public class EzyPesaNumVerificationActivity extends AppCompatActivity {

    Button ezyPesaNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ezy_pesa_num_verification);

        ezyPesaNumVerificationButton = (Button)findViewById(R.id.ezypesa_num_verification_hakiki_button);
        ezyPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EzyPesaNumVerificationActivity.this, EzyPesaAgentInfoConfirmationActivity.class));
            }
        });
    }
}