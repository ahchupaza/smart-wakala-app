package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button mPesaAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_pesa_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.mpesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.mpesa_agent_info_confirm_no);

        mPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.mpesa_agent_info_confirmation_button);
        mPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    startActivity(new Intent(MPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(MPesaAgentInfoConfirmationActivity.this, MPesaNumVerificationActivity.class));
                }
            }
        });
    }
}