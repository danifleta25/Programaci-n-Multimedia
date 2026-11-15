package com.example.interfazcontrolesbasicos;


import android.graphics.Color;
import android.graphics.Typeface;
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
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        TextView texto = findViewById(R.id.textViewBlue);
        String t = "Texto construido desde Java \nTamaño 20dp, Italic y color Blue";
        texto.setText(t);
        texto.setTextColor(Color.BLUE);
        texto.setTextSize(20);
        texto.setTypeface(null, Typeface.ITALIC);




    }
}