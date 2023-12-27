package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Choose_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_home);
    }

   public void pro_home(View v){
        Intent  i=new Intent(this, Provider_home.class);
        startActivity(i);
   }
    public void seek_home(View v){

        Intent i=new Intent(this,Seeker_home.class);
        startActivity(i);
    }
}