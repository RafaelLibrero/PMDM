package com.rafaellibrero.programacionmultimedia.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rafaellibrero.programacionmultimedia.R;
import com.rafaellibrero.programacionmultimedia.ui.recycler.ListElement;
import com.rafaellibrero.programacionmultimedia.ui.recycler.RVAdapter;

import java.util.ArrayList;

public class PictureActivity extends AppCompatActivity {

    ArrayList<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        elements = new ArrayList<>();
        elements.add(new ListElement("La creación de Adán", "1512", "Capilla Sixtina", R.drawable.creation_of_adam));
        elements.add(new ListElement("El Juicio Final", "1541", "Capilla Sixtina", R.drawable.last_judgement));
        elements.add(new ListElement("Doni Tonda", "1507", "Galería de los Uffizi", R.drawable.tondo_doni));

        RVAdapter recyclerViewAdapter = new RVAdapter(elements);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        recyclerViewAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] opciones={"Ok"};
                AlertDialog.Builder datos = new AlertDialog.Builder(PictureActivity.this);
                datos.setTitle(elements.get(recyclerView.getChildAdapterPosition(view)).getName());
                datos.setMessage("\nAño de realización: "+elements.get(recyclerView.getChildAdapterPosition(view)).getYear()+
                        "\nUbicación: "+elements.get(recyclerView.getChildAdapterPosition(view)).getUbication());
                datos.show();
            }
        });



    }
}