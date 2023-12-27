package com.example.fitmyjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHoler> {

    Context context;
    ArrayList<employer> list;

    public MainAdapter(Context context, ArrayList<employer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainAdapter.MainViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MainViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHoler holder, int position) {

        employer employer=list.get(position);
        holder.editename.setText(employer.getEditename());
        holder.editposition.setText(employer.getEditposition());
        holder.editpcity.setText(employer.getEditpcity());
        holder.edob.setText(employer.getEdob());
        holder.editecountry.setText(employer.getEditecountry());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MainViewHoler extends RecyclerView.ViewHolder{
        TextView editename,editposition,editpcity,edob,editecountry,editdocumentid;
        public MainViewHoler(@NonNull View itemView) {
            super(itemView);

            editename=itemView.findViewById(R.id.job_companyname);
            editposition=itemView.findViewById(R.id.job_description);
            editpcity  =itemView.findViewById(R.id.job_location);
            edob=itemView.findViewById(R.id.job_salary);
            editecountry=itemView.findViewById(R.id.job_test);
        }
    }
}

