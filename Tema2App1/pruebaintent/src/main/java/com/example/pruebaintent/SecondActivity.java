package com.example.pruebaintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Encontrar el TewtView en el layout de secondactivity
        TextView receivedTextView = findViewById(R.id.receivedTextView);

        // Obtener el intent que ha iniciado esta actividad
        Intent intent = getIntent();

        // Comprobar que el intent no es nulo y que contiene el extra
        if (intent != null && intent.hasExtra("MESSAGE_KEY")){

            // Extraer el texto del intent
            String message = intent.getStringExtra("MESSAGE_KEY");

            // Poner el texto en el textView
            receivedTextView.setText(message);
        }

    }
}