package com.example.smartwakala.tigo;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartwakala.R;
import com.example.smartwakala.models.Wakala;
import com.example.smartwakala.utils.BasicJobs;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TigoPesaNambaYaMtejaActivity extends AppCompatActivity {

    EditText namba, kiasi;
    String mKiasi, mNamba;
    long balance;

    BasicJobs bj;
    String wakalaNamba, wakalaID;

    public String fullname;
    boolean v = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_namba_ya_mteja);

        namba = findViewById(R.id.customer_number_request);
        kiasi = findViewById(R.id.customer_amount_request);

        bj = new BasicJobs();
        wakalaNamba = bj.getNumber(TigoPesaNambaYaMtejaActivity.this);


        findViewById(R.id.customer_number_submit_button).setOnClickListener(view -> {

            if (namba.getText().toString().isEmpty()){
                namba.setError("Ingiza namba");
                namba.requestFocus();

                return;
            }

            if (kiasi.getText().toString().isEmpty()){
                kiasi.setError("Ingiza kiasi");
                kiasi.requestFocus();

                return;
            }

            mKiasi = kiasi.getText().toString();
            mNamba = namba.getText().toString();

            boolean inatosha = checkBalance(mKiasi);

            if (inatosha) {

                getNambaJina(mNamba);

                Log.d("TAG", "onCreate: " + fullname);

                new AlertDialog.Builder(TigoPesaNambaYaMtejaActivity.this)
                        .setTitle("Thibitisha Muamala")
                        .setMessage("Unatuma kiasi cha Tsh." + kiasi.getText().toString() +
                                " kwenda kwa " + fullname + "? ")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation

                                String deduct = String.valueOf(balance - Long.parseLong(mKiasi));

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




        });
    }

    private void deductTransaction(String deductKiasi) {

        FirebaseDatabase  database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef = database.getReference().child("Wakala").child(wakalaID);

        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put("Balance", Long.parseLong(deductKiasi));

        mDatabaseRef.updateChildren(hopperUpdates)
                .addOnSuccessListener(unused -> {

            new AlertDialog.Builder(TigoPesaNambaYaMtejaActivity.this)
                    .setTitle("Thibitisha Muamala")
                    .setMessage("Muamala umefanikiwa")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(TigoPesaNambaYaMtejaActivity.this, "Muamala haujafanikiwa", Toast.LENGTH_SHORT).show();
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

                    if (wakalaNamba.equals(checkNamba)) {

                        wakalaID = childSnapshot.getKey();
                        Log.d("TAG", "onDataChange wakala key: " + wakalaID);

                        long number = (long) childSnapshot.child("Balance").getValue();

                        Log.d("TAG", "onDataChange: " + number);

                        if (Long.parseLong(kiasi) >= number) {

                            v = false;

                            new AlertDialog.Builder(TigoPesaNambaYaMtejaActivity.this)
                                    .setTitle("Thibitisha Muamala")
                                    .setMessage("Salio halitoshi")

                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                    .setPositiveButton(android.R.string.ok, null)

                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(TigoPesaNambaYaMtejaActivity.this, "Muamala haujafanikiwa", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();

                        }else {

                            balance = number;

                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
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

                    Log.d("TAG", "onDataChange Wakala Namba: " + number);
                    Log.d("TAG", "onDataChange: " + nambaMteja);

                    if (number.equals(nambaMteja)) {

                        fullname = firstname + " " + lastname;

                        Log.d("TAG", "onDataChange Wakala Namba: " + number);
                        Log.d("TAG", "onDataChange: " + fullname);

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