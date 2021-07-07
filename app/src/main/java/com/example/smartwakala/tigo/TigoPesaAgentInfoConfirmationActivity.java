package com.example.smartwakala.tigo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.smartwakala.R;
import com.example.smartwakala.UserRegistrationActivity;
import com.example.smartwakala.models.Wakala;
import com.google.firebase.database.DatabaseReference;

import io.realm.Realm;
import io.realm.RealmResults;

public class TigoPesaAgentInfoConfirmationActivity extends AppCompatActivity {

    private DatabaseReference dbRef;
    private TextView ID_no, fname, mname, lname, birthdate, licence_no, SIM_no, code_no, TIN_no, business_region;
    private Button tigoPesaAgentInfoConfirmationButton;
    private RadioButton yes, no;
    private final String TAG = "TigoPesaAgentInfoConfirmationActivity";
    private String wakalaID, wakalaFName, wakalaMName, wakalaLName, wakalaDoB ,
            wakalaLicence, wakalaSIM, wakalaCode, wakalaTIN, wakalaRegion;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_agent_info_confirmation);

        Realm.init(TigoPesaAgentInfoConfirmationActivity.this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Wakala> results = realm.where(Wakala.class).findAll();
        Log.d(TAG, " REsults: " + results);

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
        yes = findViewById(R.id.tigopesa_agent_info_confirm_yes);
        no = findViewById(R.id.tigopesa_agent_info_confirm_no);
        tigoPesaAgentInfoConfirmationButton = findViewById(R.id.tigopesa_agent_info_confirmation_button);


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

//        dbRef = FirebaseDatabase.getInstance().getReference("Wakalas").child("-McJd4rKl-F4yAgbDLOT");
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                String wakalaID = dataSnapshot.child("ID_No").getValue().toString();
//                String wakalaFName = dataSnapshot.child("FirstName").getValue().toString();
//                String wakalaMName = dataSnapshot.child("MiddleName").getValue().toString();
//                String wakalaLName = dataSnapshot.child("LastName").getValue().toString();
//                String wakalaDoB = dataSnapshot.child("DoB").getValue().toString();
//                String wakalaLicence = dataSnapshot.child("Licence_No").getValue().toString();
//                String wakalaSIM = dataSnapshot.child("SIM_No").getValue().toString();
//                String wakalaCode = dataSnapshot.child("Code_No").getValue().toString();
//                String wakalaTIN = dataSnapshot.child("TIN_No").getValue().toString();
//                String wakalaRegion = dataSnapshot.child("BusinessRegion").getValue().toString();
//
//                ID_no.setText(wakalaID);
//                fname.setText(wakalaFName);
//                mname.setText(wakalaMName);
//                lname.setText(wakalaLName);
//                birthdate.setText(wakalaDoB);
//                licence_no.setText(wakalaLicence);
//                SIM_no.setText(wakalaSIM);
//                code_no.setText(wakalaCode);
//                TIN_no.setText(wakalaTIN);
//                business_region.setText(wakalaRegion);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(TigoPesaAgentInfoConfirmationActivity.this, "Haukufanikisha, jaribu tena..!", Toast.LENGTH_LONG).show();
//            }
//        });

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
