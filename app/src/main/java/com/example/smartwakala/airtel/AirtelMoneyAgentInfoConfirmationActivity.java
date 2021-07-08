package com.example.smartwakala.airtel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.smartwakala.R;
import com.example.smartwakala.UserRegistrationActivity;

public class AirtelMoneyAgentInfoConfirmationActivity extends AppCompatActivity {

    private RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_agent_info_confirmation);

        yes = findViewById(R.id.airtelmoney_agent_info_confirm_yes);
        no = findViewById(R.id.airtelmoney_agent_info_confirm_no);

        Button airtelMoneyAgentInfoConfirmationButton = findViewById(R.id.airtelmoney_agent_info_confirmation_button);
        airtelMoneyAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    startActivity(new Intent(AirtelMoneyAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(AirtelMoneyAgentInfoConfirmationActivity.this, AirtelMoneyNumVerificationActivity.class));
                }
            }
        });

    }
}