package com.example.agendacontactoslistview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contactList;
    private ContactAdapter adapter;


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
        ListView listViewContacts = findViewById(R.id.listViewContacts);
        Button btnAddContact = findViewById(R.id.btnAddContent);

        // Datos + adaptador + vista
        contactList = new ArrayList<>();
        adapter = new ContactAdapter(this, contactList);
        listViewContacts.setAdapter(adapter);

        btnAddContact.setOnClickListener(v -> showAddContactDialog());


    }


    private void showAddContactDialog() {
        // Inflamos el layout del dialogo para acceder a sus editText
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_contact, null);
        EditText etContactName = dialogView.findViewById((R.id.etContactName));
        EditText etContactNumber = dialogView.findViewById((R.id.etContactNumber));

        new AlertDialog.Builder(this)
                .setTitle("Agregar contato")
                .setView(dialogView)
                .setPositiveButton("Agregar", (dialog, which) ->{
                    String name = etContactName.getText().toString().trim();
                    String number = etContactNumber.getText().toString().trim();

                    if (name.isEmpty() || number.isEmpty()){
                        Toast.makeText(this, "Rellena nombre y telefono", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    contactList.add(new Contact(name, number));
                    adapter.notifyDataSetChanged(); // AVISA DEL CAMBIO Y RENUEVA EL LISTVIEW, IMPRESCINDIBLE!!


                })

                .setNegativeButton("Cancelar", null).show();





    }


}