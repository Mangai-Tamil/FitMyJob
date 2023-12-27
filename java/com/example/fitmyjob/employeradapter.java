package com.example.fitmyjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class employeradapter extends RecyclerView.Adapter<employeradapter.MyViewHolder> {


    private Context context;
    private List<employer> dataList;

    public employeradapter(Context context, List<employer> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public employeradapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.activity_job_post_item,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull employeradapter.MyViewHolder holder, int position) {



        holder.company_name.setText(dataList.get(position).getEditename());

        holder.date.setText(dataList.get(position).getEditposition());
        holder.description.setText(dataList.get(position).getEditpcity());

        holder.location.setText(dataList.get(position).getEdob());
        holder.salary.setText(dataList.get(position).getEditecountry());
        holder.test.setText(dataList.get(position).getEditdocumentid());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView company_name, date,description,  location,salary, test;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            company_name= itemView.findViewById(R.id.job_companyname);

            date= itemView.findViewById(R.id.job_date);
            description= itemView.findViewById(R.id.job_description);

            location= itemView.findViewById(R.id.job_location);
            salary=itemView.findViewById(R.id.job_salary);
            test=itemView.findViewById(R.id.job_test);


        }
    }



}




