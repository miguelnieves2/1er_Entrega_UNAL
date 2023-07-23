package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.Spinner;


public class RegisterTerrazaActivity extends AppCompatActivity {

    Spinner spinnerTerrazas;
    Button buttonNewTerraza;
    ImageView IconHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_terraza);

        spinnerTerrazas = findViewById(R.id.spinnerTerrazas);
        buttonNewTerraza = findViewById(R.id.buttonNewTerraza);


        // Mostrar cada opcion del Array en el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.terrazas_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTerrazas.setAdapter(adapter);


        // Volver a categorías
        ImageView ArrowBack;

        ArrowBack = findViewById(R.id.iconArrowBack);
        Intent categories = new Intent(this, CategoriesActivity.class);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categories);
            }
        });

        // Volver a Home
        IconHome = findViewById(R.id.iconHome);
        Intent home = new Intent(this, HomeActivity.class);
        IconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });


        // Volver a categorias
        buttonNewTerraza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categories);
            }
        });







    }
}
