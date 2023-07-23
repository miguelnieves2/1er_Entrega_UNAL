package com.miguelnieves.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

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

        LinearLayout linearLayoutStadium = findViewById(R.id.LinearLayoutStadium);
        LinearLayout linearLayoutGym = findViewById(R.id.LinearLayoutGym);
        LinearLayout linearLayoutSkate = findViewById(R.id.linearLayoutSkate);
        LinearLayout linearLayoutSoccer = findViewById(R.id.linearLayoutSoccer);
        LinearLayout linearLayoutOthers = findViewById(R.id.linearLayoutOthers);

        linearLayoutStadium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, RegisterTerrazaActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, RegisterTerrazaActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutSkate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, RegisterTerrazaActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, RegisterTerrazaActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, RegisterTerrazaActivity.class);
                startActivity(intent);
            }
        });


    }
}
