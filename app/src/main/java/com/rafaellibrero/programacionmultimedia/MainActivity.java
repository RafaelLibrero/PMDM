package com.rafaellibrero.programacionmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name,mail,number;
    private Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.etName);
        mail=findViewById(R.id.etEmail);
        number=findViewById(R.id.etPhone);
        accept=findViewById(R.id.btAccept);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entradaName = name.getText().toString();
                String entradaMail = mail.getText().toString();
                String entradaNumber = number.getText().toString();

                if (entradaName.isEmpty() || entradaName.length()>30){
                    name.setError("Nombre demasiado largo o vacio");
                }

                else if (!entradaName.matches("[a-zA-Z ]+")) {
                    name.setError("Caracteres invalidos");
                }

                else if (entradaMail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(entradaMail).matches()){
                    mail.setError("Formato de email invalido");
                }

                else if (entradaNumber.isEmpty() || !Patterns.PHONE.matcher(entradaNumber).matches()){
                    number.setError("Numero de telefono invalido");
                }

                else{
                    Intent intent = new Intent(MainActivity.this, DrawerNavigation.class);
                    intent.putExtra("nombre", entradaName);
                    intent.putExtra("email", entradaMail);
                    intent.putExtra("telefono", entradaNumber);
                    startActivity(intent);
                }

            }
        });


    }
}