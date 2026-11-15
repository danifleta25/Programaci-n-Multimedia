package com.example.radiobuttons;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvDiaSeleccionado = findViewById(R.id.tvDiaSeleccionado);
        RadioGroup radioGroupDias = findViewById(R.id.radioGroupDias);

        radioGroupDias.setOnCheckedChangeListener((group, checkedId) -> {
            // Buscamos el RadioButton concreto que se ha marcado usando su ID
            RadioButton rbSeleccionado = findViewById(checkedId);

            if (rbSeleccionado != null) {
                String dia = rbSeleccionado.getText().toString();
                tvDiaSeleccionado.setText("PULSADO " + dia);
            }
        });
    }
}