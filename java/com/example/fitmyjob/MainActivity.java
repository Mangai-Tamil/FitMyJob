package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pro_h(View v){

        Intent i=new Intent(this,Provider_home.class);
        startActivity(i);
    }
    public void seek_h(View v){

        Intent i=new Intent(this,Seeker_home.class);
        startActivity(i);
    }
}