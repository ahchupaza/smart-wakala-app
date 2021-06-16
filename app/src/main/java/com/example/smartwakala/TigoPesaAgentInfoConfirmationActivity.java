package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TigoPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    private DatabaseReference dbRef;
    Wakala wakala;

    private TextView ID_no, fname, mname, lname, birthdate, licence_no, SIM_no, code_no, TIN_no, busns_region;
    private ProgressBar progressBar;

    Button tigoPesaAgentInfoConfirmationButton;
    RadioButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_agent_info_confirmation);

        ID_no = (TextView) findViewById(R.id.tigopesa_agent_id_no_data);
        fname = (TextView) findViewById(R.id.tigopesa_agent_f_name_data);
        mname = (TextView) findViewById(R.id.tigopesa_agent_m_name_data);
        lname = (TextView) findViewById(R.id.tigopesa_agent_l_name_data);
        birthdate = (TextView) findViewById(R.id.tigopesa_agent_birth_date_data);
        licence_no = (TextView) findViewById(R.id.tigopesa_agent_licence_no__data);
        SIM_no = (TextView) findViewById(R.id.tigopesa_agent_no__data);
        code_no = (TextView) findViewById(R.id.tigopesa_agent_code_data);
        TIN_no = (TextView) findViewById(R.id.tigopesa_agent_tin_no__data);
        busns_region = (TextView) findViewById(R.id.tigopesa_agent_region_data);

        progressBar = (ProgressBar) findViewById(R.id.tigopesa_agent_info_loading);

        yes = (RadioButton) findViewById(R.id.tigopesa_agent_info_confirm_yes);
        no = (RadioButton) findViewById(R.id.tigopesa_agent_info_confirm_no);
        tigoPesaAgentInfoConfirmationButton = (Button)findViewById(R.id.tigopesa_agent_info_confirmation_button);

        tigoPesaAgentInfoConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes.isChecked()) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Wakalas");
                    startActivity(new Intent(TigoPesaAgentInfoConfirmationActivity.this, UserRegistrationActivity.class));
                }
                else {
                    startActivity(new Intent(TigoPesaAgentInfoConfirmationActivity.this, TigoPesaNumVerificationActivity.class));
                }
            }
        });
    }
}