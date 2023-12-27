package com.example.fitmyjob;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import java.util.Calendar;

public class Edit_PersonalFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener,  TextWatcher {
    private EditText et_email, et_dob,et_mobile,et_name,et_address,et_pincode,et_city,et_degree,et_fos;
    private RadioButton radio_male,radio_female;
    private ImageView iv_dob;
    private TextView tv_btnnext,tv_age;
    private ProgressBar progressBar;


    private String degreeUrl="http://103.230.103.142/jobportalapp/job.asmx/GetCourse";
    private String fosUrl="http://103.230.103.142/jobportalapp/job.asmx/GetBranch";
    private String editcandidate="http://103.230.103.142/jobportalapp/job.asmx/EditCandidatePersonalDetails";
    private String getcandidatedetail="http://103.230.103.142/jobportalapp/job.asmx/GetCandidateDetails";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_edit_personal_fragment,container,false);
        //Binding view to references

        et_name= view.findViewById(R.id.ET_name);
        et_mobile=view.findViewById(R.id.ET_mobie);
        et_address=view.findViewById(R.id.ET_address);
        et_pincode= view.findViewById(R.id.ET_pincode);
        et_city=view.findViewById(R.id.ET_currentcity);
        et_dob=view.findViewById(R.id.ET_dob);
        radio_male=view.findViewById(R.id.Radio_male);
        radio_female=view.findViewById(R.id.Radio_female);
        et_degree=view.findViewById(R.id.ET_degree);
        et_fos=view.findViewById(R.id.ET_fos);
        iv_dob=view.findViewById(R.id.IV_dob);
        tv_btnnext=view.findViewById(R.id.TV_btnnext);
        tv_age=view.findViewById(R.id.TV_age);
        progressBar=view.findViewById(R.id.progressbar);

        String email=Seeker_navi_home.canemail;



        et_dob.setOnClickListener(this);        //Edit Text dob click
        iv_dob.setOnClickListener(this);        //Image View dob click
        et_dob.setOnFocusChangeListener(this);  //Edit Text dob on focus
        et_mobile.addTextChangedListener(this);//Edit Text mobile on textchange


        tv_btnnext.setOnClickListener(this);

        return view;

    }



    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.TV_btnnext)
        {
            progressBar.setVisibility(View.VISIBLE);

            String email=et_email.getText().toString();
            String name=et_name.getText().toString();
            String mobile=et_mobile.getText().toString();
            String address=et_address.getText().toString();
            String pincode=et_pincode.getText().toString();
            String city=et_city.getText().toString();
            String dob=et_dob.getText().toString();

            String gender=null;
            boolean bol=radio_male.isChecked();
            if(bol)
                gender="Male";
            else
                gender="Female";



        }
        else if(v.getId()==R.id.ET_dob)
        {
            //Calling dateOfBirth on click on edittext
            dateOfBirth();
        }
        else if(v.getId()==R.id.IV_dob)
        {
            //Calling dateOfBirth on click on calendar ImageView
            dateOfBirth();
        }

    }



    private void dateOfBirth() {

        Calendar c=Calendar.getInstance();
        final int dd,mm,yy;
        dd=c.get(Calendar.DAY_OF_MONTH);
        mm=c.get(Calendar.MONTH);
        yy=c.get(Calendar.YEAR);

        DatePickerDialog dpd=new DatePickerDialog(getActivity(), (view, year, month, dayOfMonth) -> {
            month++;
            et_dob.setText(dayOfMonth+"/"+month+"/"+year);
            calculateAge(dd,mm,yy,dayOfMonth,month,year); //calling calculateage to show it on textview age
        },dd,mm,yy);

        dpd.updateDate(1980,0,1);
        dpd.show();
    }

    //On focus on edittext
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(v.getId()==R.id.ET_dob && hasFocus)
        {
            dateOfBirth();
        }

    }

// calculating age from datetimepicker and show it on textview age

    public void calculateAge(int cdd,int cmm,int cyy,int bdd,int bmm,int byy)
    {
        cmm++;
        bmm++;
        if(cdd<bdd)
            cmm=cmm-1;
        if(cmm<bmm)
            cyy=cyy-1;

        int age=cyy-byy;

        tv_age.setText("Age : "+age);
        tv_age.setVisibility(View.VISIBLE);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        String phoneno=et_mobile.getText().toString();

        if(phoneno.length()==1) {
            s.replace(0, phoneno.length(),"+91"+phoneno);
        }
        else if(phoneno.length()==3)
        {
            s.replace(0,phoneno.length(),"");
        }

    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }
}