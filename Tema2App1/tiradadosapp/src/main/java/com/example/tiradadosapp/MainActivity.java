package com.example.tiradadosapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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

        ImageView ivDado = findViewById(R.id.ivDado);
        Button btnLanzar = findViewById(R.id.btnLanzar);

        // Inicializar imagen con la cara 1 del dado
        ivDado.setImageResource(R.drawable.dado_1);

        btnLanzar.setOnClickListener(view -> {
            //Generar numero aleatorio entre 1 y 6
            Random random = new Random();
            int numero = random.nextInt(7); // 7 porque nextInt llega hasta antes del comienzo cel numero

            // Seleccionar imagen del dado
            int idRecursoDrawable;
            switch (numero){
                case 1: idRecursoDrawable = R.drawable.dado_1;break;
                case 2: idRecursoDrawable = R.drawable.dado_2;break;
                case 3: idRecursoDrawable = R.drawable.dado_3;break;
                case 4: idRecursoDrawable = R.drawable.dado_4;break;
                case 5: idRecursoDrawable = R.drawable.dado_5;break;
                default: idRecursoDrawable = R.drawable.dado_6;break;
            }

            // Asignar cara a la ImageView
            ivDado.setImageResource(idRecursoDrawable);

        });


    }
}