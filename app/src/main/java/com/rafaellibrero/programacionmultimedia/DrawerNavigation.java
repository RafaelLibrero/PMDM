package com.rafaellibrero.programacionmultimedia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

public class DrawerNavigation extends AppCompatActivity {

    private EditText name2,mail2,number2;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        name2 = findViewById(R.id.etName2);
        mail2 = findViewById(R.id.etEmail2);
        number2 = findViewById(R.id.etPhone2);

        drawerLayout = findViewById(R.id.navigator);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        String valor = getIntent().getStringExtra("nombre");
        name2.setText(valor);
        valor = getIntent().getStringExtra("email");
        mail2.setText(valor);
        valor = getIntent().getStringExtra("telefono");
        number2.setText(valor);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //appBarConfiguration = new AppBarConfiguration.Builder().setOpenableLayout(drawerLayout).build();

        /*navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
    }
/*
    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }*/
}