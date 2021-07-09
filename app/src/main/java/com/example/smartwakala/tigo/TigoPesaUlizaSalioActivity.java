package com.example.smartwakala.tigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartwakala.MainActivity;
import com.example.smartwakala.R;
import com.example.smartwakala.UserHelpActivity;
import com.example.smartwakala.models.Wakala;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import io.realm.Realm;
import io.realm.RealmResults;

public class TigoPesaUlizaSalioActivity extends AppCompatActivity {

    private TextView rudiMenuKuu;
    private TextView rudiNyuma;
    RadioButton ulizaSalio, kamisheni;

    FirebaseDatabase database;
    private DatabaseReference dbRef;

    Realm realm;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_uliza_salio);

        rudiMenuKuu = findViewById (R.id.back_to_main_menu_activity);
        rudiNyuma = findViewById (R.id.back_to_previous_activity);
        kamisheni = findViewById(R.id.tigopesa_angalia_kamisheni);
        ulizaSalio = findViewById(R.id.tigopesa_uliza_salio_uliza_salio);

        Realm.init(TigoPesaUlizaSalioActivity.this);
        Realm realm = Realm.getDefaultInstance();


        findViewById(R.id.continue_button).setOnClickListener(view -> {

            if (ulizaSalio.isChecked()){

                checkBalance();
//                Toast.makeText(this, "Tafadhali subiri..", Toast.LENGTH_SHORT).show();

            }else if (kamisheni.isChecked()){
                Toast.makeText(this, "Tafadhali subiri..", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this, "Haujafanya chaguo!", Toast.LENGTH_SHORT).show();
            }
        });

        rudiMenuKuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TigoPesaUlizaSalioActivity.this, TigoPesaMainActivity.class));
            }
        });

        rudiNyuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TigoPesaUlizaSalioActivity.this, TigoPesaMainActivity.class));
            }
        });

    }

    private void checkBalance() {

        Realm.init(TigoPesaUlizaSalioActivity.this);
        Realm realm = Realm.getDefaultInstance();

        RealmResults<com.example.smartwakala.models.Wakala> results = realm.where(Wakala.class).findAll();

        if (results != null) {
            for (Wakala wakala : results) {

//                Toast.makeText(this, "Tafadhali subiri..", Toast.LENGTH_SHORT).show();
                Log.d("wakala cm", "checkBalance: " + wakala.getSIM_No());

                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Wakala");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        //for loop to retrieve the child node
                        for (DataSnapshot childSnapshot: snapshot.getChildren()) {
                            String number = childSnapshot.child("SIM_No").getValue().toString();

                            Log.d("TAG", "onDataChange: " + number);
                            Log.d("Real Number", "onDataChange: " + wakala.getSIM_No() + wakala.getSIM_No());

                            if (number.equals(wakala.getSIM_No())) {
                                Wakala wakala = childSnapshot.getValue(Wakala.class);

                                Log.d("TAG", "onDataChange: " + wakala.getFirstName());

                                new AlertDialog.Builder(TigoPesaUlizaSalioActivity.this)
                                        .setTitle("Salio la Akaunti")
                                        .setMessage("Salio la akaunti yako ni Tsh." + wakala.getBalance() + "/= ")

                                        // Specifying a listener allows you to take an action before dismissing the dialog.
                                        // The dialog is automatically dismissed when a dialog button is clicked.
                                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Continue with delete operation
                                            }
                                        })

                                        // A null listener allows the button to dismiss the dialog and take no further action.
                                        .setNegativeButton(android.R.string.cancel, null)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                                break;

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        }
    }

}