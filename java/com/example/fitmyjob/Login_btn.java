package com.example.fitmyjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_btn extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private Button btnLogin;
    private Button btnRegistration;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_btn);

        mAuth=FirebaseAuth.getInstance();

        mDialog= new ProgressDialog(this );

        LoginFunction();
    }

    private void LoginFunction(){

        email=findViewById(R.id.email_login);
        password=findViewById(R.id.login_password);

        btnLogin=findViewById(R.id.btn_login);
        btnRegistration=findViewById(R.id.btn_reg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mEmail= email.getText().toString().trim();
                String pass=password.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail)){
                    email.setError("Required Field...");
                    return;

                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Required Field...");
                    return;

                }

                mDialog.setMessage("Processing..");
                mDialog.show();


                mAuth   .signInWithEmailAndPassword(mEmail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Choose_home.class));

                            mDialog.dismiss();

                        } else {
                            Toast.makeText(getApplicationContext(),"Login Failed..",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),Registration_b.class));

            }
        });


    }

    }
