package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admintmart.Model.ProductModel;
import com.example.admintmart.Model.UserProductModel;
import com.example.admintmart.ViewHolder.ProductViewHolder;
import com.example.admintmart.ViewHolder.UserProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AdminUserProductsActivity extends AppCompatActivity {

    private DatabaseReference prodRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String unino="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_products);


        unino=getIntent().getStringExtra("unino");
        prodRef = FirebaseDatabase.getInstance().getReference().child("Cart List").child("Admin View").child(unino);


        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<UserProductModel> options=new FirebaseRecyclerOptions.Builder<UserProductModel>()
                .setQuery(prodRef,UserProductModel.class)
                .build();
        FirebaseRecyclerAdapter<UserProductModel, UserProductViewHolder> adapter=new FirebaseRecyclerAdapter<UserProductModel, UserProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserProductViewHolder holder, int i, @NonNull final UserProductModel model) {
                holder.txt_prodname.setText(model.getPname());
                holder.txt_prodprice.setText(model.getPrice());
                holder.txt_mrp.setText(model.getMrp());
                holder.txt_amount.setText(model.getAmount());
                Picasso.get().load(model.getImage()).into(holder.prod_image);

            }
            @NonNull
            @Override
            public UserProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ordered_product_layout,parent,false);
                UserProductViewHolder holder=new UserProductViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
    public void back_button(View view) {
        Intent i = new Intent(AdminUserProductsActivity.this,AdminNewOrdersActivity.class);
        startActivity(i);
        finish(); }

    public void Go_to_home(View view) {
        Intent i = new Intent(AdminUserProductsActivity.this,Home.class);
        startActivity(i);
        finish(); }

}

