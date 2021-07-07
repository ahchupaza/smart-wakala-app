package com.example.smartwakala.halotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartwakala.R;

public class HaloPesaNumVerificationActivity extends AppCompatActivity {

    Button haloPesaNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halo_pesa_num_verification);

        haloPesaNumVerificationButton = (Button)findViewById(R.id.halopesa_num_verification_hakiki_button);
        haloPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HaloPesaNumVerificationActivity.this, HaloPesaAgentInfoConfirmationActivity.class));
            }
        });
    }
}