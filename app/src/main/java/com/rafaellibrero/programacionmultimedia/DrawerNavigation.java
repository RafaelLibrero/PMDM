package com.rafaellibrero.programacionmultimedia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class DrawerNavigation extends AppCompatActivity {

    private EditText name2,mail2,number2;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation);

        name2 = findViewById(R.id.etName2);
        mail2 = findViewById(R.id.etEmail2);
        number2 = findViewById(R.id.etPhone2);
        drawerLayout = findViewById(R.id.navigator);
        navigationView = findViewById(R.id.nav_view);

        String valor = getIntent().getStringExtra("nombre");
        name2.setText(valor);
        valor = getIntent().getStringExtra("email");
        mail2.setText(valor);
        valor = getIntent().getStringExtra("telefono");
        number2.setText(valor);

        navigationView.bringToFront();
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
    }

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}