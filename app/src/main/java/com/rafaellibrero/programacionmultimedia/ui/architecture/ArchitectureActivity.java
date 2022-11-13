package com.rafaellibrero.programacionmultimedia.ui.architecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.rafaellibrero.programacionmultimedia.R;
import com.rafaellibrero.programacionmultimedia.ui.architecture.recycler.Arquitectura;
import com.rafaellibrero.programacionmultimedia.ui.architecture.recycler.Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ArchitectureActivity extends AppCompatActivity {

    private ArrayList<Arquitectura> elements;

    private static final String TAG = "ArchitectureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);

        elements = new ArrayList<>();

        Adapter recyclerViewAdapter = new Adapter(elements, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);

        addItemsFromJSON();

    }

    private void addItemsFromJSON() {
        try {

            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                int numColegiado = itemObj.getInt("NumColegiado");
                String nombre = itemObj.getString("Nombre");
                String especialidad = itemObj.getString("Especialidad");
                boolean estaActivo = itemObj.getBoolean("EstaActivo");
                int fechaNacimiento = itemObj.getInt("FechaNacimiento");

                Arquitectura arquitectura = new Arquitectura
                        (numColegiado,nombre,especialidad, estaActivo, fechaNacimiento);
                elements.add(arquitectura);
            }

        } catch (JSONException | IOException e) {
            Log.d(TAG, "addItemsFromJSON: ", e);
        }
    }

    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {

            String jsonString;
            inputStream = getResources().openRawResource(R.raw.arquitectura);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }
}