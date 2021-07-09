package com.example.smartwakala.tigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartwakala.MainActivity;
import com.example.smartwakala.R;
import com.example.smartwakala.UserHelpActivity;
import com.example.smartwakala.models.Wakala;

import io.realm.Realm;
import io.realm.RealmResults;

public class TigoPesaUsajiliActivity extends AppCompatActivity {

    private TextView ID_no, fname, mname, lname, birthdate, licence_no, SIM_no, code_no, TIN_no, business_region;

    private String wakalaID, wakalaFName, wakalaMName, wakalaLName, wakalaDoB ,
            wakalaLicence, wakalaSIM, wakalaCode, wakalaTIN, wakalaRegion;

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_usajili);

        okButton = (Button) findViewById(R.id.tigopesa_agent_usajili_ok_button);

        Realm.init(TigoPesaUsajiliActivity.this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Wakala> results = realm.where(Wakala.class).findAll();
        Log.d("TAG", " REsults: " + results);

        if (results != null) {
            for (Wakala wakala : results) {
                wakalaID = wakala.getID_No();
                wakalaFName = wakala.getFirstName();
                wakalaMName = wakala.getMiddleName();
                wakalaLName = wakala.getLastName();
                wakalaDoB = wakala.getDoB();
                wakalaLicence = wakala.getLicence_No();
                wakalaSIM = wakala.getSIM_No();
                wakalaCode = wakala.getCode_No();
                wakalaTIN = wakala.getTIN_No();
                wakalaRegion = wakala.getBusinessRegion();

            }
        }

        ID_no = findViewById(R.id.tigopesa_agent_id_no_data);
        fname = findViewById(R.id.tigopesa_agent_f_name_data);
        mname = findViewById(R.id.tigopesa_agent_m_name_data);
        lname = findViewById(R.id.tigopesa_agent_l_name_data);
        birthdate = findViewById(R.id.tigopesa_agent_birth_date_data);
        licence_no = findViewById(R.id.tigopesa_agent_licence_no__data);
        SIM_no = findViewById(R.id.tigopesa_agent_no__data);
        code_no = findViewById(R.id.tigopesa_agent_code_data);
        TIN_no = findViewById(R.id.tigopesa_agent_tin_no__data);
        business_region = findViewById(R.id.tigopesa_agent_region_data);


        //set values to the views
        ID_no.setText(wakalaID);
        fname.setText(wakalaFName);
        mname.setText(wakalaMName);
        lname.setText(wakalaLName);
        birthdate.setText(wakalaDoB);
        licence_no.setText(wakalaLicence);
        SIM_no.setText(wakalaSIM);
        code_no.setText(wakalaCode);
        TIN_no.setText(wakalaTIN);
        business_region.setText(wakalaRegion);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TigoPesaUsajiliActivity.this, TigoPesaMainActivity.class));
            }
        });


    }
}