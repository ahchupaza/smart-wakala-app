package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TigoPesaUlizaSalioActivity extends AppCompatActivity {

    private TextView rudiMenuKuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_uliza_salio);

        rudiMenuKuu = findViewById (R.id.back_to_main_menu_activity);

//            startActivity(new Intent(TigoPesaUlizaSalioActivity.this, UserDashboardActivity.class)); }

    }
}