package com.example.listadodepaises;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View raiz = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(raiz, (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        // (1) Instanciar los objetos del layout
        ListView listaPaises = findViewById(R.id.listaPaises);
        TextView tvSeleccion = findViewById(R.id.tvSeleccion);

        // (2) Los datos: los 10 países de res/values/paises.xml
        String[] paises = getResources().getStringArray(R.array.paises);

        // (3) El adaptador: una fila simple de texto por cada país
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, paises);

        // (4) Asociar el adaptador a la lista
        listaPaises.setAdapter(adaptador);

        // (5) Al pulsar un elemento, su texto pasa al TextView
        listaPaises.setOnItemClickListener((parent, view, posicion, id) -> {
            String pais = (String) parent.getItemAtPosition(posicion);
            tvSeleccion.setText(pais);
        });
    }
}