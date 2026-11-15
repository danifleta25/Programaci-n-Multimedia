package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPaises;
    private TextView textViewPaisSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Referenciar los componentes de la interfaz
        listViewPaises = findViewById(R.id.listViewPaises);
        textViewPaisSeleccionado = findViewById(R.id.textViewPaisSeleccionado);

        // 2. Definir el origen de datos (10 países europeos)
        String[] paises = {
                "España", "Francia", "Italia", "Alemania", "Portugal",
                "Países Bajos", "Bélgica", "Suecia", "Noruega", "Grecia"
        };

        // 3. Crear el adaptador usando el layout predefinido de Android para listas simples
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises
        );

        // 4. Asignar el adaptador al ListView
        listViewPaises.setAdapter(adaptador);

        // 5. Configurar el escuchador de eventos al pulsar un elemento
        listViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el texto del elemento pulsado según su posición
                String paisElegido = paises[position];
                // Mostrarlo en el TextView
                textViewPaisSeleccionado.setText("País seleccionado: " + paisElegido);
            }
        });
    }
}