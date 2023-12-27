package com.example.fitmyjob;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Welder_home extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    MainAdapter mainAdapter;
    ArrayList<employer> list;

    private FirebaseAuth mAuth;

    public FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference ref = db.collection("Employees");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welder_home);

        recyclerView=findViewById(R.id.userList5);

        db = FirebaseFirestore.getInstance();




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<employer>();
        mainAdapter = new MainAdapter(this, list);
        recyclerView.setAdapter(mainAdapter);

        EventChangeListener();

    }



    private void EventChangeListener() {

        db.collection("Employees").orderBy("employee name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                        if(error!=null)
                        {



                            Log.e("Firestore Error", error.getMessage());
                            return;

                        }
                        for(DocumentChange dc:value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED){

                                list.add(dc.getDocument().toObject(employer.class));

                            }

                            mainAdapter.notifyDataSetChanged();

                        }
                    }
                });
    }


}