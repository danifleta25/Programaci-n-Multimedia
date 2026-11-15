package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView gridViewPaises;
    private TextView textViewPaisSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Referenciar los componentes de la interfaz
        gridViewPaises = findViewById(R.id.gridViewPaises);
        textViewPaisSeleccionado = findViewById(R.id.textViewPaisSeleccionado);

        // 2. Definir el origen de datos (10 países europeos)
        String[] paises = {
                "España", "Francia", "Italia", "Alemania", "Portugal",
                "Países Bajos", "Bélgica", "Suecia", "Noruega", "Grecia"
        };

        // 3. Crear el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises
        );

        // 4. Asignar el adaptador al GridView
        gridViewPaises.setAdapter(adaptador);

        // 5. Configurar el escuchador de eventos al pulsar una celda
        gridViewPaises.setOnItemClickListener((parent, view, position, id) -> {
            String paisElegido = paises[position];
            textViewPaisSeleccionado.setText("País seleccionado: " + paisElegido);
        });
    }
}