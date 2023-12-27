package com.example.fitmyjob;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Uesr> dataList;

    private RecyclerViewClickListener listener;

    public MyAdapter(Context context, List<Uesr> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_job_post_item,parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.company_name.setText(dataList.get(position).getCompany_name());

        holder.date.setText(dataList.get(position).getDate());
        holder.description.setText(dataList.get(position).getDescription());

        holder.location.setText(dataList.get(position).getLocation());
        holder.salary.setText(dataList.get(position).getSalary());
        holder.test.setText(dataList.get(position).getTest());

        holder.btn_post_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(context, Electrician_home.class);
            context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface RecyclerViewClickListener{

        void onClick(View v, int position);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    Context context;

    TextView company_name, date,description,  location,salary, test, apply,btn_post_job;
    CardView cardView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);



        company_name= itemView.findViewById(R.id.job_companyname);

        date= itemView.findViewById(R.id.job_date);


        description= itemView.findViewById(R.id.job_description);

        location= itemView.findViewById(R.id.job_location);
        salary=itemView.findViewById(R.id.job_salary);
        test=itemView.findViewById(R.id.job_test);
        btn_post_job=itemView.findViewById(R.id.job_applybtn);



    }

    @Override
    public void onClick(View view) {



    }
}

