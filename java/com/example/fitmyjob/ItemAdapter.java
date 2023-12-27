package com.example.fitmyjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;



import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    Context context;
    ArrayList<Jobitem> list;

    public ItemAdapter(Context context, ArrayList<Jobitem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.activity_job_post_item,parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Jobitem user=list.get(position);
        holder.company_name.setText(user.getCompany_name());
        holder.date.setText(user.getDate());
        holder.description.setText(user.getDescription());
        holder.location.setText(user.getLocation());
        holder.salary.setText(user.getSalary());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView company_name, date, description, location, salary, test;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            company_name= itemView.findViewById(R.id.job_company_name);
            date= itemView.findViewById(R.id.job_date);
            description= itemView.findViewById(R.id.job_description);
            location= itemView.findViewById(R.id.job_location);
            salary= itemView.findViewById(R.id.job_salary);
            test= itemView.findViewById(R.id.job_test);

        }
    }
}
