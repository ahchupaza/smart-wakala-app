package com.example.smartwakala.airtel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartwakala.R;
import com.example.smartwakala.tigo.TigoPesaNambaYaMtejaActivity;
import com.example.smartwakala.utils.BasicJobs;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AirtelMoneyIngizaNambayaSimuActivity extends AppCompatActivity {

    EditText namba2, kiasi2;
    String mKiasi2, mNamba2;
    long balance2;
    long balanceMteja2;
    String mtejaId2;

    BasicJobs bj2;
    String wakalaNamba2, wakalaID2;

    public String fullname2;
    boolean v2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_ingiza_namba_ya_simu);

        namba2 = findViewById(R.id.airtel_ingiza_namba);
        kiasi2 = findViewById(R.id.airtel_ingiza_kiasi);

        bj2 = new BasicJobs();
        wakalaNamba2 = bj2.getNumber(AirtelMoneyIngizaNambayaSimuActivity.this);


        findViewById(R.id.airtel_customer_number_submit_button).setOnClickListener(view -> {

            if (namba2.getText().toString().isEmpty()){
                namba2.setError("Hujaingiza namba!");
                namba2.requestFocus();

                return;
            }
            if (namba2.length() < 10){
                namba2.setError("Tarakimu hazijakamilika 10!");
                namba2.requestFocus();

                return;
            }

            if (kiasi2.getText().toString().isEmpty()){
                kiasi2.setError("Hujaingiza kiasi!");
                kiasi2.requestFocus();

                return;
            }

            mNamba2 = namba2.getText().toString();
            mKiasi2 = kiasi2.getText().toString();

            int x = Integer.parseInt(mKiasi2);

            if (x < 1000){
                kiasi2.setError("Kiwango cha chini 1,000/-");
                kiasi2.requestFocus();

                return;
            }

            if (!(mNamba2.startsWith("068") || mNamba2.startsWith("069") || mNamba2.startsWith("078"))) {
                namba2.setError("Namba siyo ya Airtel!");
                namba2.requestFocus();

                return;
            }else {

                boolean inatosha = checkBalance(mKiasi2);

                if (inatosha) {

                    getNambaJina(mNamba2);

                    Log.d("TAG", "onCreate: " + fullname2);

                    new AlertDialog.Builder(AirtelMoneyIngizaNambayaSimuActivity.this)
                            .setTitle("Thibitisha Muamala")
                            .setMessage("Unakaribia kutuma kiasi cha Tsh." + kiasi2.getText().toString() +
                                    " kwenda kwa " + fullname2 + "! ")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation

                                    String deduct = String.valueOf(balance2 - Long.parseLong(mKiasi2));

                                    deductTransaction(deduct);
                                }

                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }

            }

        });
    }

    private void deductTransaction(String deductKiasi) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef = database.getReference().child("Wakala").child(wakalaID2);

        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put("Balance", Long.parseLong(deductKiasi));

        mDatabaseRef.updateChildren(hopperUpdates)
                .addOnSuccessListener(unused -> {

                    new AlertDialog.Builder(AirtelMoneyIngizaNambayaSimuActivity.this)
                            .setTitle("Thibitisha Muamala")
                            .setMessage("Muamala umefanikiwa!")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    balanceMteja2 += Long.parseLong(mKiasi2);
                                    updateMtejaSalio();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(AirtelMoneyIngizaNambayaSimuActivity.this, "Muamala haujafanikiwa!", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();




                })
                .addOnFailureListener(e -> {

                });

    }

    private boolean checkBalance(String kiasi) {

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Wakala");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                //for loop to retrieve the child node
                for (DataSnapshot childSnapshot: snapshot.getChildren()) {

                    String checkNamba = childSnapshot.child("SIM_No").getValue().toString();

                    if (wakalaNamba2.equals(checkNamba)) {

                        wakalaID2 = childSnapshot.getKey();
                        Log.d("TAG", "onDataChange wakala key: " + wakalaID2);

                        long number = (long) childSnapshot.child("Balance").getValue();

                        Log.d("TAG", "onDataChange: " + number);

                        if (Long.parseLong(kiasi) >= number) {

                            v2 = false;

                            new AlertDialog.Builder(AirtelMoneyIngizaNambayaSimuActivity.this)
                                    .setTitle("Thibitisha Muamala")
                                    .setMessage("Hauna salio la kutosha kufanya muamala huu!")

                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                    .setPositiveButton(android.R.string.ok, null)

                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(AirtelMoneyIngizaNambayaSimuActivity.this, "Muamala haujafanikiwa!", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();

                        }else {

                            balance2 = number;

                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return v2;
    }

    public void getNambaJina(String nambaMteja) {

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Mteja");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                //for loop to retrieve the child node
                for (DataSnapshot childSnapshot: snapshot.getChildren()) {
                    String number = childSnapshot.child("SIM_No").getValue().toString();

                    String firstname = childSnapshot.child("FirstName").getValue().toString();
                    String lastname = childSnapshot.child("LastName").getValue().toString();
                    balanceMteja2 = (long) childSnapshot.child("Balance").getValue();
                    mtejaId2 = childSnapshot.getKey();

                    Log.d("TAG", "onDataChange Wakala Namba: " + number);
                    Log.d("TAG", "onDataChange: " + nambaMteja);

                    if (number.equals(nambaMteja)) {

                        fullname2 = firstname + " " + lastname;

                        Log.d("TAG", "onDataChange Wakala Namba: " + number);
                        Log.d("TAG", "onDataChange: " + fullname2);

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

    public void updateMtejaSalio() {

        FirebaseDatabase  database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef = database.getReference().child("Mteja").child(mtejaId2);

        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put("Balance", balanceMteja2);

        mDatabaseRef.updateChildren(hopperUpdates).addOnSuccessListener(unused -> {
            Toast.makeText(this, "Salio la mteja limesahihishwa!", Toast.LENGTH_SHORT).show();
        });

        finish();
    }

}