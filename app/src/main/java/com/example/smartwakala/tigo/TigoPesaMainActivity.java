package com.example.smartwakala.tigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.smartwakala.R;

public class TigoPesaMainActivity extends AppCompatActivity {

    Button tigoPesaMainMenuButton;
    RadioButton ulizaSalio, usajili, wekaPesa, toaKwaAsiyesajiliwa, wakalaKutoaPesa, mudaWaMaongeziEPOD, akauntiYangu, toaPesaBenki;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigo_pesa_main);

        ulizaSalio = (RadioButton) findViewById(R.id.tigopesa_uliza_salio);
        usajili = (RadioButton) findViewById(R.id.tigopesa_usajili);
        wekaPesa = (RadioButton) findViewById(R.id.tigopesa_weka_pesa);
        toaKwaAsiyesajiliwa = (RadioButton) findViewById(R.id.tigopesa_toa_kwa_asiyesajiliwa);
        wakalaKutoaPesa = (RadioButton) findViewById(R.id.tigopesa_wakala_kutoa_pesa);
        mudaWaMaongeziEPOD = (RadioButton) findViewById(R.id.tigopesa_muda_wa_maongezi_epod);
        akauntiYangu = (RadioButton) findViewById(R.id.tigopesa_akaunti_yangu);
        toaPesaBenki = (RadioButton) findViewById(R.id.tigopesa_toa_pesa_benki);
        tigoPesaMainMenuButton = (Button)findViewById(R.id.tigopesa_main_menu_continue_button);


        tigoPesaMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ulizaSalio.isChecked()) {
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaUlizaSalioActivity.class));
                }
                else if (usajili.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaUsajiliActivity.class));
                }
                else if (wekaPesa.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMtejaActivity.class));
                }
                else if (toaKwaAsiyesajiliwa.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMpokeajiActivity.class));
                }
                else if (wakalaKutoaPesa.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaWakalaKutoaPesaActivity.class));
                }
                else if (mudaWaMaongeziEPOD.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMtejaActivity.class));
                }
                else if (akauntiYangu.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaAkauntiYanguActivity.class));
                }
                else if (toaPesaBenki.isChecked()){
                    startActivity(new Intent(TigoPesaMainActivity.this, TigoPesaWakalaKutoaBenkiActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Haujafanya chaguo lolote!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
