package com.example.smartwakala.halotel;

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

import java.util.Objects;

import io.realm.Realm;

import static io.realm.Realm.getDefaultInstance;

import com.example.smartwakala.R;

public class HaloPesaNumVerificationActivity extends AppCompatActivity {

    private static final String TAG = "HaloPesaNumVerificationActivity";
    private DatabaseReference dbRef;
    public EditText haloPesaNumSearch;
    public TextView halopesaNoAgentInfo;
    //firebase
    FirebaseDatabase database;
    private Button haloPesaNumVerificationButton;
    private ProgressBar progressBar;
    //realm
    Realm realm;
    private EditText haloPesaNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halo_pesa_num_verification);

        Realm.init(HaloPesaNumVerificationActivity.this);
        database = FirebaseDatabase.getInstance();
        realm = getDefaultInstance();

        haloPesaNumSearch = findViewById(R.id.haloPesaNumToBeRegistered);
        haloPesaNum = haloPesaNumSearch;

        progressBar = findViewById(R.id.halopesa_num_verification_loading);
        halopesaNoAgentInfo = findViewById(R.id.halopesa_no_agent_info);
        haloPesaNumVerificationButton = findViewById(R.id.halopesa_num_verification_hakiki_button);

        haloPesaNumVerificationButton.setOnClickListener(view -> {

            if (haloPesaNum.getText().toString().isEmpty()) {
                haloPesaNum.setError("Haujaingiza namba!");
                haloPesaNum.requestFocus();

                return;
            }

            if (haloPesaNum.length() < 10){
                haloPesaNum.setError("Tarakimu hazijakamilika 10!");
                haloPesaNum.requestFocus();

                return;
            }

            String haloPesaNumber = haloPesaNum.getText().toString();

            if (!(haloPesaNumber.startsWith("062"))) {
                haloPesaNum.setError("Namba siyo ya Halotel!");
                haloPesaNum.requestFocus();

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
                            String number = Objects.requireNonNull(childSnapshot.child("SIM_No").getValue()).toString();

                            if (number.equals(haloPesaNumber)) {
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
                                halopesaNoAgentInfo.setText("Samahani, hakuna taarifa!");
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