package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class HaloPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button haloPesaAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halo_pesa_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.halopesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.halopesa_agent_info_confirm_no);
        haloPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.halopesa_agent_info_confirmation_button);
        haloPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    startActivity(new Intent(HaloPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(HaloPesaAgentInfoConfirmationActivity.this, HaloPesaNumVerificationActivity.class));
                }

            }
        });
    }
}