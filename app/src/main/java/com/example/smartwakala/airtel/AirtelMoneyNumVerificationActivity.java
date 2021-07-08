package com.example.smartwakala.airtel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import io.realm.Realm;

import static io.realm.Realm.getDefaultInstance;

import com.example.smartwakala.R;

public class AirtelMoneyNumVerificationActivity extends AppCompatActivity {

    private static final String TAG = "AirtelMoneyNumVerificationActivity";
    private DatabaseReference dbRef;
    public EditText airtelMoneyNumSearch;
    private TextView airtelmoneyNoAgentInfo;
    //firebase
    FirebaseDatabase database;
    private Button airtelMoneyNumVerificationButton;
    private ProgressBar progressBar;
    //realm
    Realm realm;
    private EditText airtelMoneyNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_num_verification);

        Realm.init(AirtelMoneyNumVerificationActivity.this);
        database = FirebaseDatabase.getInstance();
        realm = getDefaultInstance();

        airtelMoneyNumSearch = findViewById(R.id.airtelMoneyNumToBeRegistered);
        airtelMoneyNum = airtelMoneyNumSearch;

        progressBar = findViewById(R.id.airtelmoney_num_verification_loading);
        airtelmoneyNoAgentInfo = findViewById(R.id.airtelmoney_no_agent_info);
        airtelMoneyNumVerificationButton = findViewById(R.id.airtelmoney_num_verification_hakiki_button);

        airtelMoneyNumVerificationButton.setOnClickListener(view -> {

            if (airtelMoneyNum.getText().toString().isEmpty()) {
                airtelMoneyNum.setError("Haujaingiza namba!");
                airtelMoneyNum.requestFocus();

                return;
            }

            if (airtelMoneyNum.length() < 10){
                airtelMoneyNum.setError("Tarakimu hazijakamilika 10!");
                airtelMoneyNum.requestFocus();

                return;
            }

            String airtelMoneyNumber = airtelMoneyNum.getText().toString();

            if (!(airtelMoneyNumber.startsWith("068") || airtelMoneyNumber.startsWith("069") || airtelMoneyNumber.startsWith("078"))) {
                airtelMoneyNum.setError("Namba siyo ya Airtel!");
                airtelMoneyNum.requestFocus();

                return;
            }
            else {

                progressBar.setVisibility(View.VISIBLE);

                DatabaseReference dbRef = database.getReference("Wakala");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        //for loop to retrieve the child node
                        for (DataSnapshot childSnapshot: snapshot.getChildren()) {
                            String number = childSnapshot.child("SIM_No").getValue().toString();

                            if (number.equals(airtelMoneyNumber)) {
                                com.example.smartwakala.models.Wakala wakala = childSnapshot.getValue(Wakala.class);
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

                            else {
                                progressBar.setVisibility(View.GONE);
                                airtelmoneyNoAgentInfo.setText("Samahani, hakuna taarifa!");
                            }

                            //print to logcat
                            Log.d(TAG, "onDataChange: " + childSnapshot);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

        });
    }

}