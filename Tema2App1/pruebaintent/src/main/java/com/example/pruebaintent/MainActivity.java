package com.example.pruebaintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button sendButton;
    private Button webButton;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas desde el layout
        editText = editText.findViewById(R.id.editText);
        sendButton = sendButton.findViewById(R.id.sendButton);
        webButton = webButton.findViewById(R.id.webButton);
        shareButton = shareButton.findViewById(R.id.shareButton);

        // Configurar listeners para cada boton

        // Enviar a actividad 2 (Intent explicito)
        sendButton.setOnClickListener(v -> {
            // Obtener texto del editText
            String texto = editText.getText().toString();
            // Intent explicito
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            // Añadir texto como un extra con clave-valor
            intent.putExtra("MESSAGE_KEY", texto);

            // Iniciar la SecondActivity
            startActivity(intent);
        });

        // Boton abrir pagina web
        webButton.setOnClickListener(v -> {
            // Crear el intent con la intencio de VER
            Intent intent = new Intent(Intent.ACTION_VIEW);
            // Establecer la url
            intent.setData(Uri.parse("https://www.android.com"));
            startActivity(intent);
        });

        // Boton compartir texto
        shareButton.setOnClickListener(v -> {
            // Obtener texto
            String texto = editText.getText().toString();

            //Crear intent con intencion de enviar
            Intent intent = new Intent(Intent.ACTION_SEND);

            // Establecer tipo de dato
            intent.setType("text/plain");

            // Añadir el texto que se va a compartir
            intent.putExtra(Intent.EXTRA_TEXT, texto);

            // Iniciar el chooser (El menu de compartir del sistema)
            startActivity(Intent.createChooser(intent, "Compartir texto con..."));

        });




    }
}