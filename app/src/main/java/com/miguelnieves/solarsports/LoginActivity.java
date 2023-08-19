package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelnieves.solarsports.utils.userUtils;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView register;

    EditText user;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);

        // Login
        login = findViewById(R.id.buttonIniciarSesion);
        Intent homeScreen = new Intent(this,HomeActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 Si esta vacio el formulario
               if(!user.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    // Verifica si existe el usuario
                   if(userUtils.checkUser(
                           user.getText().toString(),
                           getFilesDir()
                   )){
                       // Usuario registrado, verifica si la contraseña es correcta
                       if(userUtils.checkPassword(user.getText().toString(), password.getText().toString(), getFilesDir())){
                           startActivity(homeScreen);
                       }else{
                           Toast.makeText(LoginActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                       }
                   }else{
                       Toast.makeText(LoginActivity.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                   }
               }else{
                   Toast.makeText(LoginActivity.this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
               }
            }
        });

        // Register
        register = findViewById(R.id.textViewRegister);
        Intent registerScreen = new Intent(this,RegisterActivity.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerScreen);
            }
        });




    }
}