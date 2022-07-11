package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int alturaEmCentimetros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alturaEmCentimetros = progress;
                String texto = formataValorComDoisDigitos(progress/100.0);
                texto += " m.";
                txtMetros.setText(texto);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPes.setText("Toque em Converter");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double alturaEmPes = alturaEmCentimetros / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });
    }
    private String formataValorComDoisDigitos(double valor){
        return String.format(Locale.FRANCE, "%.2f", valor);
    }
}