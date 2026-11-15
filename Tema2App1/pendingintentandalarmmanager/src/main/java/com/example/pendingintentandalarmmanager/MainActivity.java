package com.example.pendingintentandalarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.Security;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SELECTION = 101;
    private TextView resultTextView;
    private Button selectButton;
    private Button alarmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        resultTextView = findViewById(R.id.resultTextView);
        selectButton = findViewById(R.id.selectButton);
        alarmButton = findViewById(R.id.alarmButton);

        // Parte 1: Iniciar actividad esperando un resultado
        selectButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityResult.class);
            // Lanzamos la actividad con un codigo de peticion
            startActivityForResult(intent, REQUEST_CODE_SELECTION);
        });

       // Parte 2: Programar una accion futura con PendingIntent
        alarmButton.setOnClickListener(v -> scheduleActivityLaunch());

    }

    private void scheduleActivityLaunch() {
        // Crear el intent que queremos ejecutar en el futuro
        Intent intent = new Intent(this, ActivityResult.class);

        // Crear el PendingIntent
        // Envuelve nuestro Intent para que el AlarmManager lo pueda usar en nuestro nombre
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Obtener el servicio de AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Calcular el tiempo de disparo (10s desde ahora)
        long triggerTime = System.currentTimeMillis() + (10 * 1000);

        // Programar la alarma
        try {
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            Toast.makeText(this, "Actividad programada en 10s", Toast.LENGTH_SHORT).show();

        } catch (SecurityException e) {
            Toast.makeText(this, "Error: se necesita permismo para programar alarmas", Toast.LENGTH_SHORT).show();
        }


    }


    // Parte 1: recepcion: metodo que redibe el resultado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        // Es la respuesta a neustra peticion y salio bien? (RESULT_OK)
        if (requestCode == REQUEST_CODE_SELECTION && requestCode == RESULT_OK) {

            // Comprobamos que "data" no es nulo
            if (data != null && data.hasExtra("RESULT_kEY")){
                // Etraemos el string del extra
                String result = data.getStringExtra("RESULT_KEY");
                resultTextView.setText("Opcion seleccionada: " + result);
            }
        }



    }





}