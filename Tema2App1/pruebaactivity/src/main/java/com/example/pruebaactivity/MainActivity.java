package com.example.pruebaactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView logTextView;
    private EditText userInputEditText;
    private static final String TAG = "LIFECYCLE"; // Etiqueta para filtrar en logcat
    private static final String USER_INPUT_KEY = "userInput"; // Clave para guardar el texto



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logTextView = findViewById(R.id.logTextView);
        userInputEditText = findViewById(R.id.userInputEditText);

        addLog("--> onCreate");

        // Restaurar estado si el Bundle no es nulo
        if (savedInstanceState != null){
            userInputEditText.setText(savedInstanceState.getString(USER_INPUT_KEY));
            addLog("--> Estado restaurado desde el Bundle");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        addLog("--> onSaveInstanceState()");
        // Guardar el texto actual del editText en el Bundle
        outState.putString(USER_INPUT_KEY, userInputEditText.getText().toString());
    }

    @Override
    protected void onStart(){
        super.onStart();
        addLog("--> onStart"); // La actividad se hace visible
    }

    @Override
    protected void onResume(){
        super.onResume();
        addLog("--> onResume"); // La actividad toma primer plano y es interactiva
    }

    @Override
    protected void onPause() {
        super.onPause();
        addLog("<-- onPause()"); // Otra actividad toma el primer plano
    }

    @Override
    protected void onStop() {
        super.onStop();
        addLog("<-- onStop()"); // La actividad ya no es visible
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addLog("--> onRestart()"); // Se llama antes de onStart() cuando la actividad vuelve a ser visible
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Nota: El log en el TextView no se verá porque la UI ya no existe.
        Log.i(TAG, "<-- onDestroy()"); // La actividad es destruida y eliminada de memoria
    }


    // Metodo esccritura logs
    void addLog(String message) {
        Log.i(TAG, message);
        logTextView.append(message + "\n");
    }


}