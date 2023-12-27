package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Provider_home extends AppCompatActivity {

    private Button btnAllJob;
    private Button btnPostJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);








        btnAllJob=findViewById(R.id.btn_allJob);
        btnPostJob=findViewById(R.id.btn_PostJob);

        btnAllJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AllJobActivity.class));

            }
        });

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Provi_seeker_home.class));

            }
        });


    }


}