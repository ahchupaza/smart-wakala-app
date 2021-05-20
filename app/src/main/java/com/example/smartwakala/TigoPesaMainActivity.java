package com.example.smartwakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

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
                    Intent goToUlizaSalioActivity = new Intent(TigoPesaMainActivity.this, TigoPesaUlizaSalioActivity.class);
                    startActivity(goToUlizaSalioActivity);
                }
                else if (usajili.isChecked()){
                    Intent goToTigoPesaUsajiliActivity = new Intent(TigoPesaMainActivity.this, TigoPesaUsajiliActivity.class);
                    startActivity(goToTigoPesaUsajiliActivity);
                }
                else if (wekaPesa.isChecked()){
                    Intent goToTigoPesaNambaYaMtejaActivity = new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMtejaActivity.class);
                    startActivity(goToTigoPesaNambaYaMtejaActivity);
                }
                else if (toaKwaAsiyesajiliwa.isChecked()){
                    Intent goToTigoPesaNambaYaMpokeajiActivity = new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMpokeajiActivity.class);
                    startActivity(goToTigoPesaNambaYaMpokeajiActivity);
                }
                else if (wakalaKutoaPesa.isChecked()){
                    Intent goToTigoPesaWakalaKutoaPesaActivity = new Intent(TigoPesaMainActivity.this, TigoPesaWakalaKutoaPesaActivity.class);
                    startActivity(goToTigoPesaWakalaKutoaPesaActivity);
                }
                else if (mudaWaMaongeziEPOD.isChecked()){
                    Intent goToTigoPesaNambaYaMtejaActivity = new Intent(TigoPesaMainActivity.this, TigoPesaNambaYaMtejaActivity.class);
                    startActivity(goToTigoPesaNambaYaMtejaActivity);
                }
                else if (akauntiYangu.isChecked()){
                    Intent goToTigoPesaAkauntiYanguActivity = new Intent(TigoPesaMainActivity.this, TigoPesaAkauntiYanguActivity.class);
                    startActivity(goToTigoPesaAkauntiYanguActivity);
                }
                else {
                    Intent goToTigoPesaWakalaKutoaBenkiActivity = new Intent(TigoPesaMainActivity.this, TigoPesaWakalaKutoaBenkiActivity.class);
                    startActivity(goToTigoPesaWakalaKutoaBenkiActivity);
                }

            }
        });
    }
}
