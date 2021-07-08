package com.example.smartwakala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MaoniActivity extends AppCompatActivity {

    private DatabaseReference dbRef;

    private EditText userFdbk;
    private ProgressBar progressBar;
    private Button tumaMaoniButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maoni);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Maoni");

        userFdbk = (EditText) findViewById(R.id.maoni_edtxt);

        progressBar = (ProgressBar) findViewById(R.id.maoni_loading);

        tumaMaoniButton = (Button) findViewById(R.id.tuma_maoni_button);
        tumaMaoniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendFeedbck();
            }
        });
    }

    private void sendFeedbck() {
        String maoni = userFdbk.getText().toString().trim();

        if (maoni.isEmpty()){
            userFdbk.setError("Haukuandika maoni!");
            userFdbk.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        MaoniObject maoniObject =  new MaoniObject(maoni);

        dbRef.push().setValue(maoniObject).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(MaoniActivity.this, "Maoni yako yamepokelewa!", Toast.LENGTH_LONG).show();
                    userFdbk.setText("");
                    progressBar.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MaoniActivity.this, "Maoni yako hayajaenda, jaribu tena!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}