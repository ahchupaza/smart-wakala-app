package com.example.smartwakala.airtel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.smartwakala.R;
import com.example.smartwakala.tigo.TigoPesaMainActivity;
import com.example.smartwakala.tigo.TigoPesaWakalaKutoaBenkiActivity;

import static android.util.Log.d;

public class AirtelMoneyMainActivity extends AppCompatActivity {

    Button airtel_continue_button;
    RadioButton airtel_weka_pesa,airtel_toa_pesa, airtel_uza_muda, airtel_uza_bidhaa, airtel_cash_drop,airtel_akaunti_yangu, airtel_rejesha_muamala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel_money_main);

        airtel_weka_pesa = (RadioButton) findViewById(R.id. airtel_weka_pesa);
        airtel_toa_pesa = (RadioButton) findViewById(R.id.airtel_toa_pesa);
        airtel_uza_muda = (RadioButton) findViewById(R.id.airtel_uza_muda);
        airtel_uza_bidhaa = (RadioButton) findViewById(R.id.airtel_uza_bidhaa);
        airtel_cash_drop = (RadioButton) findViewById(R.id.airtel_cash_drop);
        airtel_akaunti_yangu = (RadioButton) findViewById(R.id.airtel_akaunti_yangu);
        airtel_rejesha_muamala = (RadioButton) findViewById(R.id.airtel_rejesha_muamala);

        airtel_continue_button= (Button) findViewById(R.id.airtel_continue_button);
        airtel_continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (airtel_weka_pesa.isChecked()) {
                    Intent goToAirtelMoneyIngizaNambayaSimuActivity = new Intent(AirtelMoneyMainActivity.this, AirtelMoneyIngizaNambayaSimuActivity.class);
                    startActivity(goToAirtelMoneyIngizaNambayaSimuActivity);
                }
                else if(airtel_toa_pesa.isChecked()) {
                    Intent goToAirtelMoneyToaPesaActivity = new Intent(AirtelMoneyMainActivity.this, AirtelMoneyToaPesaActivity.class);
                    startActivity(goToAirtelMoneyToaPesaActivity);
                }
                else if(airtel_uza_muda.isChecked()){
                    Intent goToAirtelMoneyUzamudaWaMaongeziActivity = new Intent(AirtelMoneyMainActivity.this, AirtelMoneyUzamudaWaMaongeziActivity.class);
                    startActivity(goToAirtelMoneyUzamudaWaMaongeziActivity);
                }
                else if(airtel_uza_bidhaa.isChecked()){
                    Intent goToAirtelMoneyUzaBidhaaActivity= new Intent(AirtelMoneyMainActivity.this, AirtelMoneyUzaBidhaaActivity.class);
                    startActivity(goToAirtelMoneyUzaBidhaaActivity);
                }
                else if(airtel_cash_drop.isChecked()){
                    Intent goToAirtelMoneyCashDropActivity= new Intent(AirtelMoneyMainActivity.this, AirtelMoneyCashDropActivity.class);
                    startActivity(goToAirtelMoneyCashDropActivity);
                }
                else if(airtel_akaunti_yangu.isChecked()){
                    Intent goToAirtelMoneyAkauntiYanguActivity= new Intent(AirtelMoneyMainActivity.this, AirtelMoneyAkauntiYanguActivity.class);
                    startActivity(goToAirtelMoneyAkauntiYanguActivity);
                }
                else if (airtel_rejesha_muamala.isChecked()){
                    startActivity(new Intent(AirtelMoneyMainActivity.this, AirtelMoneyRejeshaMuamalaActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Haujafanya chaguo lolote!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
