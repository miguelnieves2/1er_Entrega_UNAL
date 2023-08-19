package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.miguelnieves.solarsports.models.User;
import com.miguelnieves.solarsports.utils.userUtils;


public class RegisterActivity extends AppCompatActivity {

    Button register;

    TextView login;

    // User data

    EditText name;
    EditText email;
    EditText username;
    EditText password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);

        register = findViewById(R.id.buttonNewTerraza);


        Intent homeScreen = new Intent(this,HomeActivity.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Si esta vacio el formulario

                if (
                        !name.getText().toString().isEmpty() &&
                                !email.getText().toString().isEmpty() &&
                                !username.getText().toString().isEmpty() &&
                                !password.getText().toString().isEmpty()
                ) {
                    // Verifica si existe el usuario
                    if (userUtils.checkUser(
                            email.getText().toString(),
                            getFilesDir()
                    )
                    ) {
                        // Usuario esta registrado
                        Toast.makeText(getApplicationContext(), "Este usuario esta registrado.", Toast.LENGTH_SHORT).show();
                    } else {
                         User user = new User(name.getText().toString(), email.getText().toString(), username.getText().toString(), password.getText().toString());
                         saveUser(user);
                         startActivity(homeScreen);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Todos los campos deben estar diligenciados",Toast.LENGTH_LONG).show();
                }
            }

        });


    }

    public void saveUser(User user){

        File file= new File(getFilesDir(),"userData.txt");
        try {
            FileWriter writer= new FileWriter(file,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(user.getName()+","+user.getEmail()+","+
                    user.getUsername()+","+user.getPassword());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}


