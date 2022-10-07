package com.rafaellibrero.programacionmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText name2,mail2,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name2 = findViewById(R.id.etName2);
        mail2 = findViewById(R.id.etEmail2);
        number2 = findViewById(R.id.etPhone2);

        String valor = getIntent().getStringExtra("nombre");
        name2.setText(valor);
        valor = getIntent().getStringExtra("email");
        mail2.setText(valor);
        valor = getIntent().getStringExtra("telefono");
        number2.setText(valor);


    }
}