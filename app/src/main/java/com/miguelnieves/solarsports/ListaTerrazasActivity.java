package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.miguelnieves.solarsports.models.TerrazaSolar;

import java.io.File;
import java.util.List;

public class ListaTerrazasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_terrazas);

        // Volver a home
        ImageView ArrowBack;
        ImageView IconHome;

        ArrowBack = findViewById(R.id.iconArrowBack);
        Intent home = new Intent(this, HomeActivity.class);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });

        // Volver a Home por Navigation Bar
        IconHome = findViewById(R.id.iconHome);
        IconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });


        TableLayout tableTerrazas = findViewById(R.id.tableListaTerrazas);

        // Cargar archivo de terrazas solares
        File terrazasFile = new File(getFilesDir(), "terrazasSolares.txt");

        // Lista terrazas
        List<TerrazaSolar> listaTerrazas = readFile(terrazasFile);

    }

    public List<TerrazaSolar> readFile(File terrazas) {
        return null;
    }
}