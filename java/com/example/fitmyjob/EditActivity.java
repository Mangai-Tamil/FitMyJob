package com.example.fitmyjob;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class EditActivity extends AppCompatActivity  implements View.OnClickListener {

    TextView tv_personal,tv_education,tv_name,tv_email;
    ImageView profileimg;
    Fragment Edit_PersonalFragment;
    private final int REQUEST_CODE_GALLERY=999;
    ImageView iv_back;
    public String emailh=Seeker_navi_home.canemail;
    public String name=Seeker_navi_home.name;
    public String degree=Seeker_navi_home.getdegree;
    public String fos=Seeker_navi_home.getfos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);tv_personal=findViewById(R.id.TV_editPersonal);

        iv_back=findViewById(R.id.IV_back_arrow);
        profileimg=findViewById(R.id.imageView);
        tv_name=findViewById(R.id.TV_name);
        tv_email=findViewById(R.id.TV_email);

        tv_name.setText(name);
        tv_email.setText(emailh);


        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(EditActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);

            }
        });

        tv_personal.setOnClickListener(this);

        iv_back.setOnClickListener(this);
        tv_personal.setBackgroundColor(Color.rgb(255,87,34));
        tv_personal.setTextColor(Color.rgb(255, 255, 255));


        loadProfilePic();

    }

    private void loadProfilePic() {

        DBManager db=new DBManager(this);
        byte[] byteimg=db.getImage(Seeker_navi_home.canemail);
        if(byteimg!=null){
            Bitmap bitimg= BitmapFactory.decodeByteArray(byteimg, 0, byteimg.length);
            try{
                profileimg.setImageBitmap(bitimg);
            }
            catch (Exception ex)
            {
                Log.d("logcheck","exception "+ex);
            }
        }
    }

    //Permission menu for access gallery or camera

    //Setting image to image View after permission granted



    //Adding image to database


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.TV_editPersonal)
        {
            tv_personal.setBackgroundColor(Color.rgb(255,87,34));
            tv_personal.setTextColor(Color.rgb(255, 255, 255));

        }

        else if(view.getId()==R.id.IV_back_arrow){
            Intent intent=new Intent(EditActivity.this, Seeker_navi_home.class);
            intent.putExtra("emailid",emailh);
            intent.putExtra("name",name);
            intent.putExtra("getdegree",degree);
            intent.putExtra("getfos",fos);
            startActivity(intent);
            overridePendingTransition(R.anim.topttobottom,R.anim.bottomtotop);
            finish();
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(EditActivity.this,Seeker_navi_home.class);
        intent.putExtra("emailid",emailh);
        intent.putExtra("name",name);
        intent.putExtra("getdegree",degree);
        intent.putExtra("getfos",fos);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.topttobottom,R.anim.bottomtotop);
    }
}