package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TigoPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    Button tigoPesaAgentInfoConfirmationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_agent_info_confirmation);

        tigoPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.tigopesa_agent_info_confirmation_button);
        tigoPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToUserRegistrationActivity = new Intent(TigoPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class);
                startActivity(goToUserRegistrationActivity);
            }
        });

    }
}