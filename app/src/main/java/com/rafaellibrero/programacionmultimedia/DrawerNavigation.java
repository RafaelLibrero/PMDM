package com.rafaellibrero.programacionmultimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.rafaellibrero.programacionmultimedia.ui.architecture.ArchitectureActivity;
import com.rafaellibrero.programacionmultimedia.ui.help.HelpActivity;
import com.rafaellibrero.programacionmultimedia.ui.picture.PictureActivity;

public class DrawerNavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView name,mail,number;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        name = findViewById(R.id.tvName);
        mail = findViewById(R.id.tvEmail);
        number = findViewById(R.id.tvPhone);

        drawerLayout = findViewById(R.id.navigator);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        String valor = getIntent().getStringExtra("nombre");
        name.setText(getString(R.string.drawer_username,valor));
        valor = getIntent().getStringExtra("email");
        mail.setText(getString(R.string.drawer_email,valor));
        valor = getIntent().getStringExtra("telefono");
        number.setText(getString(R.string.drawer_phone,valor));

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.nav_paint:
                intent = new Intent(DrawerNavigation.this, PictureActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_architecture:
                intent = new Intent(DrawerNavigation.this, ArchitectureActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_ayuda:
                intent = new Intent(DrawerNavigation.this, HelpActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}