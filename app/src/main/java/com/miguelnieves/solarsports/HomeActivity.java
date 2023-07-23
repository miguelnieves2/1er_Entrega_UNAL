package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    ImageView iconLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iconLogout = findViewById(R.id.iconArrowBack);
        Intent login = new Intent(this,LoginActivity.class);
        iconLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });


        // Ir a Estadisticas
        LinearLayout LinearLayoutEstadisticas;

        LinearLayoutEstadisticas = findViewById(R.id.LinearLayoutEstadisticas);
        Intent estadisticas = new Intent(this, EstadisticasActivity.class);
        LinearLayoutEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(estadisticas);
            }
        });


        // Ir a Categorias
        LinearLayout LinearLayoutCategorias;

        LinearLayoutCategorias = findViewById(R.id.LinearLayoutCategorias);
        Intent categories = new Intent(this, CategoriesActivity.class);
        LinearLayoutCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categories);
            }
        });

        // Ir a Beneficios
        LinearLayout linearLayoutBeneficios;
        linearLayoutBeneficios = findViewById(R.id.linearLayoutBeneficios);
        Intent beneficios = new Intent(this, BeneficiosActivity.class);
        linearLayoutBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(beneficios);
            }
        });

    }
}