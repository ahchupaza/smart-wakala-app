package com.example.smartwakala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TigoPesaNumVerificationActivity extends AppCompatActivity {

    private DatabaseReference dbRef;
    public EditText tigoPesaNumSearch;
//    private TextView wakalaSIMNo;
    private Button tigoPesaNumVerificationButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_num_verification);

        tigoPesaNumSearch = findViewById(R.id.tigoPesaNumToBeRegistered);

//        wakalaSIMNo = findViewById(R.id.tigopesa_agent_SIM_no_verified_data);

        progressBar = findViewById(R.id.tigopesa_num_verification_loading);
        tigoPesaNumVerificationButton = findViewById(R.id.tigopesa_num_verification_hakiki_button);

        tigoPesaNumVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TigoPesaNumVerificationActivity.this, TigoPesaAgentInfoConfirmationActivity.class));
            }
        });
    }

//    public void verifyWakalaNumber() {
//        String tigoPesaAgentNum = tigoPesaNumSearch.getText().toString().trim();
//
//        if (tigoPesaAgentNum.isEmpty()){
//            tigoPesaNumSearch.setError("Haujaingiza namba!");
//            tigoPesaNumSearch.requestFocus();
//            return;
//        }
//
//        progressBar.setVisibility(View.VISIBLE);
//
//        dbRef = (DatabaseReference) FirebaseDatabase.getInstance().getReference("Wakalas").child("SIM_No").equalTo(tigoPesaAgentNum);
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String wakalaNo = dataSnapshot.child(tigoPesaAgentNum).getValue().toString();
//                wakalaSIMNo.setText(wakalaNo);
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(TigoPesaNumVerificationActivity.this, "Haukufanikisha, jaribu tena..!", Toast.LENGTH_LONG).show();
//                progressBar.setVisibility(View.GONE);
//            }
//        });
//
//    }
}



