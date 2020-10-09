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

import com.example.admintmart.Model.OrderHistoryModel;
import com.example.admintmart.Model.OrderModel;
import com.example.admintmart.ViewHolder.OrderHistoryViewHolder;
import com.example.admintmart.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderHistory extends AppCompatActivity {

    private RecyclerView orderlist;
    private DatabaseReference orderhist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);


        orderhist= FirebaseDatabase.getInstance().getReference().child("Order History");
        orderlist = findViewById(R.id.recycler_menu);
        orderlist.setHasFixedSize(true);
        orderlist.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerOptions<OrderHistoryModel> options=new FirebaseRecyclerOptions.Builder<OrderHistoryModel>()
                .setQuery(orderhist,OrderHistoryModel.class)
                .build();
        FirebaseRecyclerAdapter<OrderHistoryModel, OrderHistoryViewHolder> adapter=new FirebaseRecyclerAdapter<OrderHistoryModel, OrderHistoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int i, @NonNull final OrderHistoryModel model) {

                holder.order_id.setText(model.getOrderId());
                holder.order_date.setText(model.getDeliveredDate());
                holder.detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OrderBottomSheetDialog bottomSheetDialog= new OrderBottomSheetDialog();
                        Bundle bundle = new Bundle();
                        bundle.putString("link",model.getOrderId());
                        bottomSheetDialog.setArguments(bundle);
                        bottomSheetDialog.show(getSupportFragmentManager(),"Details");

                    }
                });



            }
            @NonNull
            @Override
            public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_layout,parent,false);
                OrderHistoryViewHolder holder=new OrderHistoryViewHolder(view);
                return holder;
            }
        };
        orderlist.setAdapter(adapter);
        adapter.startListening();
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(OrderHistory.this,Home.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(OrderHistory.this,Home.class);
        startActivity(i);
        overridePendingTransition(0,0);

    }
}
