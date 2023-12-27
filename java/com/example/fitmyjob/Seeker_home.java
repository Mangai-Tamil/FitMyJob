package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class Seeker_home extends AppCompatActivity  {

    CardView carpentor;
    CardView constructor;
    CardView welder;
    CardView electrician;
    CardView chef;
    CardView vehiclerepair;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_home);

        carpentor=findViewById(R.id.carpentor);
        constructor=findViewById(R.id.constructor);
        welder=findViewById(R.id.welder);
        electrician=findViewById(R.id.electrician);
        chef=findViewById(R.id.cook);
        vehiclerepair=findViewById(R.id.vehiclerepair);

        carpentor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), Carpentor_home.class));

              }

            });

        constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Constructor_home.class));

            }

        });

        welder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Welder_home.class));

            }

        });

        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Electrician_home.class));

            }

        });

        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Job_post_item.class));

            }

        });

        vehiclerepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Seeker_navi_home.class));


            }

        });



    }
}