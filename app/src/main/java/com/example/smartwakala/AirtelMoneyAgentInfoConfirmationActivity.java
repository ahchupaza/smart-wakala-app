package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class AirtelMoneyAgentInfoConfirmationActivity extends AppCompatActivity {

    Button airtelMoneyAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.airtelmoney_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.airtelmoney_agent_info_confirm_no);
        airtelMoneyAgentInfoConfirmationButton = (Button)findViewById(R.id.airtelmoney_agent_info_confirmation_button);


        airtelMoneyAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {

                    Intent goToUserRegistrationActivity = new Intent(AirtelMoneyAgentInfoConfirmationActivity.this, UserRegistrationActivity.class);
                    startActivity(goToUserRegistrationActivity);

                }
                else {
                    Intent goToAirtelMoneyNumVerification = new Intent(AirtelMoneyAgentInfoConfirmationActivity.this, AirtelMoneyNumVerificationActivity.class);
                    startActivity(goToAirtelMoneyNumVerification);

                }
            }
        });

    }
}