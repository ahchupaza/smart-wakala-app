package com.example.smartwakala.tigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartwakala.R;

public class TigoPesaConfirmTransaction extends AppCompatActivity {

    String jina;

    TextView jinaLaMteja;
    Button confrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_confirm_transaction);

        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
            jina = (String) b.get("jina");
;
        }

    }
}