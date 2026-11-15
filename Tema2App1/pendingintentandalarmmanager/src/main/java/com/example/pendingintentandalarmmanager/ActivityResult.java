package com.example.pendingintentandalarmmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResult extends AppCompatActivity {

    private Button optionAButton;
    private Button optionBButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        optionAButton = findViewById(R.id.optionAButton);
        optionBButton = findViewById(R.id.optionBButton);

        // Listener para la opcion A
        optionAButton.setOnClickListener(v -> returnResult("Opcion A"));



    }

    private void returnResult(String selectedOption) {
        // Crear un intent vacio para guardar los datos de vuelta
        Intent data = new Intent();

        // Añadir el dato
        data.putExtra("RESULT_KEY", selectedOption);

        // Establecer el resultado como OK y adjuntar el intent con los datos
        setResult(RESULT_OK, data);

        // Cerrar esta actividad y volver a la anterior
        finish();



    }
}