package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_screen.this, Login_btn.class);
                startActivity(intent);
                finish();
            }
        }, 3000 );
    }
}

