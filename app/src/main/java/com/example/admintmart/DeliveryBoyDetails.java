package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admintmart.Model.DeliveryModel;
import com.example.admintmart.ViewHolder.AssignOrderViewHolder;
import com.example.admintmart.ViewHolder.DetailsDeliveryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class DeliveryBoyDetails extends AppCompatActivity {

    private DatabaseReference delref, orderref;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_boy_details);
        delref = FirebaseDatabase.getInstance().getReference().child("Delivery Person Details");

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<DeliveryModel> options = new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                .setQuery(delref.orderByChild("Status").equalTo("Approved"), DeliveryModel.class)
                .build();
        FirebaseRecyclerAdapter<DeliveryModel, DetailsDeliveryViewHolder> adapter = new FirebaseRecyclerAdapter<DeliveryModel, DetailsDeliveryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull DetailsDeliveryViewHolder holder, int i, @NonNull final DeliveryModel model) {
                holder.txt_name.setText(model.getName());
                holder.phone.setText(model.getPhone());
                holder.location.setText(model.getLocation());
                Picasso.get().load(model.getPhoto()).into(holder.photo1);
                holder.details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                        Bundle bundle = new Bundle();
                        bundle.putString("link", model.getPhone());
                        bottomSheetDialog.setArguments(bundle);
                        bottomSheetDialog.show(getSupportFragmentManager(), "Details");

                    }

                });


            }

            @NonNull
            @Override
            public DetailsDeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_deliveryperson_layout, parent, false);
                DetailsDeliveryViewHolder holder = new DetailsDeliveryViewHolder(view);
                return holder;
            }
        };

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }

    public void Go_to_home(View view) {
        Intent i = new Intent(DeliveryBoyDetails.this,Home.class);
        startActivity(i);
        finish();
    }
}
