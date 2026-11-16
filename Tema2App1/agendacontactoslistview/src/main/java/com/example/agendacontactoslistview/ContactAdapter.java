package com.example.agendacontactoslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> contacts){
        super(context, 0, contacts);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){
        //Reciclar: inflar solo si no hay vista reutilizable
        if (converView == null){
            converView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        // Obtener el dato de esta posición
        Contact contact = getItem(position);

        // Rellenar la vista con el dato
        TextView tvContactName = converView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = converView.findViewById(R.id.tvContactNumber);

        if (contact != null) {
            tvContactName.setText((contact.getName()));
            tvContactNumber.setText(contact.getNumber());
        }

        return converView;
    }


}
