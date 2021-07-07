package com.example.smartwakala.airtel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartwakala.R;

public class AirtelMoneyNumVerificationActivity extends AppCompatActivity {

    private Button airtelMoneyNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_num_verification);

        airtelMoneyNumVerificationButton = (Button)findViewById(R.id.airtelmoney_num_verification_hakiki_button);
        airtelMoneyNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAirtelMoneyAgentInfoConfirmationActivity = new Intent(AirtelMoneyNumVerificationActivity.this, AirtelMoneyAgentInfoConfirmationActivity.class);
                startActivity(goToAirtelMoneyAgentInfoConfirmationActivity);
            }
        });

    }
}