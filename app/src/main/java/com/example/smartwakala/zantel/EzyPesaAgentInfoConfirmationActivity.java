package com.example.smartwakala.zantel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.smartwakala.R;
import com.example.smartwakala.UserRegistrationActivity;

public class EzyPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button ezyPesaAgentInfoConfirmationButton;
    RadioButton yes, no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ezy_pesa_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.ezypesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.ezypesa_agent_info_confirm_no);
        ezyPesaAgentInfoConfirmationButton= (Button) findViewById(R.id.ezypesa_agent_info_confirmation_button);


        ezyPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (yes.isChecked()) {

                    Intent goToUserRegistrationActivity = new Intent(EzyPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class);
                    startActivity(goToUserRegistrationActivity);

                }
                else {
                    Intent goToEzyPesaNumVerification = new Intent(EzyPesaAgentInfoConfirmationActivity.this, EzyPesaNumVerificationActivity.class);
                    startActivity(goToEzyPesaNumVerification);

                }


            }




        });

    }
}