package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Spinner;
import android.widget.Toast;

import com.miguelnieves.solarsports.models.TerrazaSolar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class RegisterTerrazaActivity extends AppCompatActivity {

    Spinner spinnerTerrazas, spinnerMeses;
    String selectedTerraza, selectedMeses;
    Button buttonNewTerraza;
    ImageView IconHome;


    EditText energiaProducida, valorAhorrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_terraza);

        spinnerTerrazas = findViewById(R.id.spinnerTerrazas);
        spinnerMeses = findViewById(R.id.spinnerMeses);
        buttonNewTerraza = findViewById(R.id.buttonNewTerraza);

        energiaProducida = findViewById(R.id.editTextEnergiaProducida);
        valorAhorrado = findViewById(R.id.editTextValorAhorrado);


        // Mostrar cada opcion del Array Terrazas en el Spinner
        ArrayAdapter<CharSequence> adapterTerrazas = ArrayAdapter.createFromResource(
                this,
                R.array.terrazas_array,
                android.R.layout.simple_spinner_item
        );
        adapterTerrazas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTerrazas.setAdapter(adapterTerrazas);

        // Mostrar cada opcion del Array Meses en el Spinner
        ArrayAdapter<CharSequence> adapterMeses = ArrayAdapter.createFromResource(
                this,
                R.array.meses_array,
                android.R.layout.simple_spinner_item
        );
        adapterMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMeses.setAdapter(adapterMeses);

        // Capturar la opción seleccionada del Spinner Terrazas
        spinnerTerrazas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la opción seleccionada del Spinner
                selectedTerraza = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedTerraza = "";
            }
        });

        // Capturar la opción seleccionada del Spinner Meses
        spinnerMeses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la opción seleccionada del Spinner
                selectedMeses = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedMeses = "";
            }
        });


        // Registrar terraza
        buttonNewTerraza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Verificamos si los valores estan vacios
                if(!selectedTerraza.equals("Seleccione una opción") && !energiaProducida.getText().toString().isEmpty() && !valorAhorrado.getText().toString().isEmpty() && !selectedMeses.equals("Seleccione una opción")){

                    TerrazaSolar terraza = new TerrazaSolar(selectedTerraza, Integer.parseInt(energiaProducida.getText().toString()), Integer.parseInt(valorAhorrado.getText().toString()), selectedMeses);

                    saveTerraza(terraza);


                }else{
                    Log.d("Formulario terrazas vacio", "Espacios vacios");
                    Toast.makeText(RegisterTerrazaActivity.this, "Todos los campos deben estar diligenciados", Toast.LENGTH_LONG).show();
                }
            }
        });




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
    }


    public void saveTerraza(TerrazaSolar terraza){

        File file= new File(getFilesDir(),"terrazasSolares.txt");
        try {
            System.out.println("Funcion saveTerraza: entro al Try catch");
            FileWriter writer= new FileWriter(file,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(terraza.getTerraza()+","+terraza.getEnergia()+","+
                    terraza.getValorAhorrado()+","+terraza.getMes());
            bufferedWriter.newLine();
            bufferedWriter.close();


            spinnerTerrazas.setSelection(0);
            energiaProducida.setText("");
            valorAhorrado.setText("");
            spinnerMeses.setSelection(0);

            Toast.makeText(this, "Terraza solar registrada!", Toast.LENGTH_LONG).show();
            System.out.println("Terraza registrada");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
