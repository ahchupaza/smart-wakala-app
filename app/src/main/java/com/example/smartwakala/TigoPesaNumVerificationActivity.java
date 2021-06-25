package com.example.smartwakala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartwakala.models.Wakala;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import io.realm.Realm;

import static io.realm.Realm.getDefaultInstance;

public class TigoPesaNumVerificationActivity extends AppCompatActivity {

    private static final String TAG = "TigoPesaNumVerificationActivity";
    private DatabaseReference dbRef;
    public EditText tigoPesaNumSearch;
    //firebase
    FirebaseDatabase database;
    private Button tigoPesaNumVerificationButton;
    private ProgressBar progressBar;
//    realm
    Realm realm;
    private EditText tigoPesaNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_num_verification);

        Realm.init(TigoPesaNumVerificationActivity.this);
        database = FirebaseDatabase.getInstance();
        realm = getDefaultInstance();

        tigoPesaNumSearch = findViewById(R.id.tigoPesaNumToBeRegistered);
        tigoPesaNum = findViewById(R.id.tigoPesaNumToBeRegistered);

        progressBar = findViewById(R.id.tigopesa_num_verification_loading);
        tigoPesaNumVerificationButton = findViewById(R.id.tigopesa_num_verification_hakiki_button);

        tigoPesaNumVerificationButton.setOnClickListener(view -> {

            if (tigoPesaNum.getText().toString().isEmpty()) {
                tigoPesaNum.setError("Haujaingiza namba!");
                tigoPesaNum.requestFocus();

                return;
            }

            if (tigoPesaNum.length() < 10){
                tigoPesaNum.setError("Tarakimu hazijakamilika 10!");
                tigoPesaNum.requestFocus();

                return;
            }

            String tigoPesaNumber = tigoPesaNum.getText().toString();

            progressBar.setVisibility(View.VISIBLE);

            DatabaseReference dbRef = database.getReference("Wakalas");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    //for loop to retrieve the child node
                    for (DataSnapshot childSnapshot: snapshot.getChildren()) {
                        String number = childSnapshot.child("SIM_No").getValue().toString();

                        if (number.equals(tigoPesaNumber)) {
                            Wakala wakala = childSnapshot.getValue(Wakala.class);
                            Log.d(TAG, "onDataChange Firstaname: " + wakala.getFirstName());


                            /** Ordinary way to store data to realm
                             *
                             *
                                 Realm realm = Realm.getDefaultInstance();
                                 realm.beginTransaction();
                                 realm.copyToRealm(wakala)
                                 realm.commitTransaction();

                             *
                             * */

                            try {
                                Realm realm = getDefaultInstance();
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.insertOrUpdate(wakala);

                                        startActivity(new Intent(getApplicationContext(), TigoPesaAgentInfoConfirmationActivity.class));

                                        progressBar.setVisibility(View.GONE);

                                    }
                                });
                            }finally {
                                if (realm != null) {
                                    realm.close();
                                }
                            }
                        }
//                        else
//                            Toast.makeText(TigoPesaNumVerificationActivity.this, "Samahani, hakuna usajili wenye namba hiyo. Tafadhali jaribu tena!", Toast.LENGTH_SHORT).show();
//                             progressBar.setVisibility(View.GONE);

                        //print to logcat
                        Log.d(TAG, "onDataChange: " + childSnapshot);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

}



