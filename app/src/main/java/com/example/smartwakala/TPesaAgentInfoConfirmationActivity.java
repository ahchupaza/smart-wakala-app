package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class TPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button TPesaAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_pesa_agent_info_confirmation);

        yes = (RadioButton) findViewById(R.id.tpesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.tpesa_agent_info_confirm_no);

        TPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.tpesa_agent_info_confirmation_button);
        TPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    startActivity(new Intent(TPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(TPesaAgentInfoConfirmationActivity.this, TPesaNumVerificationActivity.class));
                }
            }
        });
    }
}

