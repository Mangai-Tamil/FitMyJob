package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Provi_seeker_home extends AppCompatActivity {

    CardView carpentor;
    CardView constructor;
    CardView welder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provi_seeker_home);

        carpentor=findViewById(R.id.carpentor);
        constructor=findViewById(R.id.constructor);
        welder=findViewById(R.id.welder);

        carpentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Post_job_for_carpentor.class));

            }

        });

        constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PostJobActivity.class));

            }

        });

        welder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Welder_home.class));

            }

        });
    }
}