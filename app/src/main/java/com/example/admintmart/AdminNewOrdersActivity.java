package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admintmart.Model.OrderModel;
import com.example.admintmart.Model.ProductModel;
import com.example.admintmart.ViewHolder.OrderViewHolder;
import com.example.admintmart.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class AdminNewOrdersActivity extends AppCompatActivity {

    private RecyclerView orderlist;
    private DatabaseReference orderref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_orders);

        orderref = FirebaseDatabase.getInstance().getReference().child("Orders").child("User Order Details");

        orderlist = findViewById(R.id.recycler_menu);
        orderlist.setHasFixedSize(true);
        orderlist.setLayoutManager(new LinearLayoutManager(this));

        orderref.orderByChild("state").equalTo("not shipped").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int a=(int)dataSnapshot.getChildrenCount();

                if (a==0)
                {
                    android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(AdminNewOrdersActivity.this);
                    builder1.setMessage("No New Orders");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(AdminNewOrdersActivity.this,Home.class);
                                    startActivity(i);
                                    finish();

                                }

                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerOptions<OrderModel> options=new FirebaseRecyclerOptions.Builder<OrderModel>()
                .setQuery(orderref.orderByChild("state").equalTo("not shipped"),OrderModel.class)
                .build();
        FirebaseRecyclerAdapter<OrderModel, OrderViewHolder> adapter=new FirebaseRecyclerAdapter<OrderModel, OrderViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder holder, int i, @NonNull final OrderModel model) {

                holder.txt_name.setText(model.getName());
                holder.txt_email.setText(model.getEmail());
                holder.txt_address.setText(model.getAddress());
               holder.txt_payment.setText(model.getPayment());
                holder.txt_price.setText(model.getTotalamount());
                holder.txt_extime.setText(model.getExTime());
                holder.txt_date.setText(model.getOrderedDate());
                holder.txt_time.setText(model.getOrderedTime());
                holder.viewprod.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AdminNewOrdersActivity.this,AdminUserProductsActivity.class);
                        i.putExtra("unino",model.getUniqueNo());
                        startActivity(i);
                    }
                });

                holder.assignord.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AdminNewOrdersActivity.this,AssignOrders.class);
                        i.putExtra("OrderID",model.getOrderId());
                        i.putExtra("DeliverTo",model.getName());
                        i.putExtra("DeliverAddr",model.getAddress());
                        i.putExtra("ExpectedTime",model.getExTime());
                        i.putExtra("Payment",model.getPayment());
                        i.putExtra("Totalamount",model.getTotalamount());
                        i.putExtra("UniqueNo",model.getUniqueNo());
                        i.putExtra("Email",model.getEmail());
                        startActivity(i);
                    }
                });




            }
            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_layout,parent,false);
                OrderViewHolder holder=new OrderViewHolder(view);
                return holder;
            }
        };
        orderlist.setAdapter(adapter);
        adapter.startListening();
    }


    public void Go_to_home(View view) {
        Intent i = new Intent(AdminNewOrdersActivity.this,Home.class);
        startActivity(i);
        finish();


    }
}
