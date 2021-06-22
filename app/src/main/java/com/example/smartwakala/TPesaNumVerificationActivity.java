package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TPesaNumVerificationActivity extends AppCompatActivity {

    Button TPesaNumVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_pesa_num_verification);

        TPesaNumVerificationButton = (Button)findViewById(R.id.tpesa_num_verification_hakiki_button);
        TPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TPesaNumVerificationActivity.this, TPesaAgentInfoConfirmationActivity.class));
            }
        });
    }
}