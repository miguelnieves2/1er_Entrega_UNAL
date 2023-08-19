package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.miguelnieves.solarsports.models.TerrazaSolar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaTerrazasActivity extends AppCompatActivity {

    ImageView ArrowBack;
    ImageView IconHome;


    TableLayout tableTerrazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_terrazas);

        tableTerrazas = findViewById(R.id.tableListaTerrazas);


        // Volver a home
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



        // Cargar archivo de terrazas solares
        File terrazasFile = new File(getFilesDir(), "terrazasSolares.txt");

        // Lista terrazas
        if (terrazasFile.exists()) {
            try {
                List<TerrazaSolar> listaTerrazas = readFile(terrazasFile);
                inflateTable(listaTerrazas);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            inflateTable(new ArrayList<TerrazaSolar>());
            Log.d("ListaTerrazasActivity", "El archivo terrazasSolares.txt no existe.");
        }


    }

    public List<TerrazaSolar> readFile(File terrazas) throws IOException {

        List<TerrazaSolar> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(terrazas));
        String terraza;
        while((terraza = bufferedReader.readLine()) != null) {

            // Tipo terraza, energia, ingresos, mes
            String[] dataTerraza = terraza.split(",");

            // ["Gym","250","50000", "Agosto"]
            String tipoTerraza = dataTerraza[0];
            int energia = Integer.parseInt(dataTerraza[1]);
            int ingresos = Integer.parseInt(dataTerraza[2]);
            String mes = dataTerraza[3];

            TerrazaSolar createTerraza = new TerrazaSolar(tipoTerraza, energia, ingresos, mes);
            list.add(createTerraza);
        }
        return list;
    }


    public void inflateTable(List<TerrazaSolar> terrazaList){
        try {
            for (TerrazaSolar i : terrazaList) {
                TableRow row = new TableRow(this);

                TextView cellTipoTerraza = new TextView(this);
                cellTipoTerraza.setText(i.getTerraza());
                cellTipoTerraza.setGravity(Gravity.CENTER);
                cellTipoTerraza.setBackgroundResource(R.drawable.cell_background);
                cellTipoTerraza.setPadding(10, 10, 10, 10);
                cellTipoTerraza.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                TextView cellEnergia = new TextView(this);
                cellEnergia.setGravity(Gravity.CENTER);
                cellEnergia.setText(String.valueOf(i.getEnergia()));
                cellEnergia.setBackgroundResource(R.drawable.cell_background);
                cellEnergia.setPadding(10, 10, 10, 10);
                cellEnergia.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                TextView cellIngresos = new TextView(this);
                cellIngresos.setText(String.valueOf(i.getValorAhorrado()));
                cellIngresos.setGravity(Gravity.CENTER);
                cellIngresos.setBackgroundResource(R.drawable.cell_background);
                cellIngresos.setPadding(10, 10, 10, 10);
                cellIngresos.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                TextView cellMes = new TextView(this);
                cellMes.setText(i.getMes());
                cellMes.setGravity(Gravity.CENTER);
                cellMes.setBackgroundResource(R.drawable.cell_background);
                cellMes.setPadding(10, 10, 10, 10);
                cellMes.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                row.addView(cellTipoTerraza);
                row.addView(cellEnergia);
                row.addView(cellIngresos);
                row.addView(cellMes);

                tableTerrazas.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}