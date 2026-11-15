package com.example.botonespersonalizados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText entrada;
    private TextView salida;



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


        /*
        Otra forma de hacerlo en lugar de con la funcion sePulsa()
         */
//        Button boton = findViewById(R.id.button);
//        boton.setOnClickListener(v ->
//                Toast.makeText(this, "pulsado", Toast.LENGTH_SHORT).show()
//                );


        entrada = findViewById(R.id.entrada);
        salida = findViewById(R.id.salida);

    }

    // Devuelve el doble de lo que haya eescrito en "entrada"
    public void sePulsa(View view){
        String texto = entrada.getText().toString().trim();
        if(texto.isEmpty()){
            Toast.makeText(this, R.string.error_vacio, Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double numero = Float.parseFloat(texto);
            salida.setText(String.valueOf(numero * 2.0));
        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.error_formato, Toast.LENGTH_SHORT).show();
        }
    }


    public void sePulsa0(View view){
        entrada.append((String)view.getTag());
    }
}