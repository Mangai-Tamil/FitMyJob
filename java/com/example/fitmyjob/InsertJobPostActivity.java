package com.example.fitmyjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

import Model.Data;


public class InsertJobPostActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private EditText job_company_name;
    private EditText job_description;

    private EditText job_salary;

    private EditText job_location;
    private EditText job_test;

    private Button btn_post_job;

    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();

        mJobPost= FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);

        InsertJob();

    }

    private void InsertJob(){

        job_company_name=findViewById(R.id.job_company_name);
        job_description=findViewById(R.id.job_description);

        job_salary=findViewById(R.id.job_salary);
        job_location=findViewById(R.id.job_location);
        job_test=findViewById(R.id.job_test);


        btn_post_job=findViewById(R.id.btn_job_post);

        btn_post_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String company_name= job_company_name.getText().toString().trim();
                String description= job_description.getText().toString().trim();

                String salary= job_salary.getText().toString().trim();
                String location= job_location.getText().toString().trim();
                String test= job_test.getText().toString().trim();

                if(TextUtils.isEmpty(company_name)){
                    job_company_name.setError("Required Field...");
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    job_description.setError("Required Field...");
                    return;
                }



                if (TextUtils.isEmpty(salary)){
                    job_salary.setError("Required Field...");
                    return;
                }

                if (TextUtils.isEmpty(location)){
                    job_location.setError("Required Field...");
                    return;
                }

                String id=mJobPost.push().getKey();

                String date= DateFormat.getDateInstance().format(new Date());

                Data data= new Data(company_name,description,location,salary,test,id,date);

                mJobPost.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Job Posted!!!",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));



            }
        });

    }


}