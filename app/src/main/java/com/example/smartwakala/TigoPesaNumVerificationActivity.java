package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TigoPesaNumVerificationActivity extends AppCompatActivity {

    Button tigoPesaNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_num_verification);

        tigoPesaNumVerificationButton = (Button)findViewById(R.id.tigopesa_num_verification_hakiki_button);
        tigoPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTigoPesaAgentInfoConfirmationActivity = new Intent(TigoPesaNumVerificationActivity.this, TigoPesaAgentInfoConfirmationActivity.class);
                startActivity(goToTigoPesaAgentInfoConfirmationActivity);
            }
        });

    }
}