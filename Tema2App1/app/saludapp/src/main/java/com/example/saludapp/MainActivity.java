package com.example.saludapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener referencias a las vistas usando la clase R
        EditText etNombre = findViewById(R.id.etNombre);
        Button btnSaludar = findViewById(R.id.btnSaludar);
        TextView tvResultado = findViewById(R.id.tvResultado);

        // Accion del boton
        btnSaludar.setOnClickListener(view -> {
            //Obtener el texto del editView
            String nombre = "Hola " + etNombre.getText().toString() + "!";

            // Crear el mensaje de saludo
            if (nombre.isEmpty()) {
                tvResultado.setText("Por favor escribe tu nombre");
            } else {
                tvResultado.setText(nombre);
            }
        });

    }
}