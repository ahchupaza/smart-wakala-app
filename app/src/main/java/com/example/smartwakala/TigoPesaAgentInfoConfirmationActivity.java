package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class TigoPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button tigoPesaAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.tigopesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.tigopesa_agent_info_confirm_no);
        tigoPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.tigopesa_agent_info_confirmation_button);

        tigoPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    startActivity(new Intent(TigoPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(TigoPesaAgentInfoConfirmationActivity.this, TigoPesaNumVerificationActivity.class));
                }
            }
        });
    }
}