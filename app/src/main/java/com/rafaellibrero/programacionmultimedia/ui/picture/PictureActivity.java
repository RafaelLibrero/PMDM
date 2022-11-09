package com.rafaellibrero.programacionmultimedia.ui.picture;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.rafaellibrero.programacionmultimedia.R;
import com.rafaellibrero.programacionmultimedia.ui.picture.recycler.ListElement;
import com.rafaellibrero.programacionmultimedia.ui.picture.recycler.RVAdapter;

import java.util.ArrayList;

public class PictureActivity extends AppCompatActivity {

    private ArrayList<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        elements = new ArrayList<>();
        elements.add(new ListElement("La creación de Adán", "1512", "Capilla Sixtina", R.drawable.creation_of_adam));
        elements.add(new ListElement("El Juicio Final", "1541", "Capilla Sixtina", R.drawable.last_judgement));
        elements.add(new ListElement("Doni Tonda", "1507", "Galería de los Uffizi", R.drawable.tondo_doni));
        elements.add(new ListElement("El Diluvio Universal", "1509", "Capilla Sixtina", R.drawable.diluvio_universal));
        elements.add(new ListElement("La Creación de Eva", "1510", "Capilla Sixtina", R.drawable.creation_of_eva));
        elements.add(new ListElement("David y Goliat","1509", "Capilla Sixtina", R.drawable.david_and_goliat));
        elements.add(new ListElement("Sibila Délfica", "1509", "Capilla Sixtina", R.drawable.the_delphic_sibyl));
        elements.add(new ListElement("Sibila Líbica", "1512", "Capilla Sixtina", R.drawable.sibila_libica));
        elements.add(new ListElement("Venus y Cupido", "1533", "Galería de la Academia de Florencia", R.drawable.venus_cupido));
        elements.add(new ListElement("Santo Entierro", "1501", "Galería Nacional de Londres", R.drawable.santo_entierro));

        RVAdapter recyclerViewAdapter = new RVAdapter(elements);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        recyclerViewAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder datos = new AlertDialog.Builder(PictureActivity.this);
                datos.setTitle(elements.get(recyclerView.getChildAdapterPosition(view)).getName());
                datos.setMessage("\nAño de realización: "+elements.get(recyclerView.getChildAdapterPosition(view)).getYear()+
                        "\nUbicación: "+elements.get(recyclerView.getChildAdapterPosition(view)).getUbication());
                datos.show();
            }
        });

    }
}