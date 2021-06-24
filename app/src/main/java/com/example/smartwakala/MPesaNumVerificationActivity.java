package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MPesaNumVerificationActivity extends AppCompatActivity {

    Button mPesaNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_pesa_num_verification);

        mPesaNumVerificationButton = (Button)findViewById(R.id.mpesa_num_verification_hakiki_button);
        mPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MPesaNumVerificationActivity.this, MPesaAgentInfoConfirmationActivity.class));
            }
        });
    }
}