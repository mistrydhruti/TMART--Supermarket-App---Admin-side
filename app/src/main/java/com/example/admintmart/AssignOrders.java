package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admintmart.Common.Common;
import com.example.admintmart.Model.DeliveryModel;
import com.example.admintmart.Model.MyResponse;
import com.example.admintmart.Model.Notification;
import com.example.admintmart.Model.OrderModel;
import com.example.admintmart.Model.Sender;
import com.example.admintmart.Model.Token;
import com.example.admintmart.Remote.APIService;
import com.example.admintmart.ViewHolder.AssignOrderViewHolder;
import com.example.admintmart.ViewHolder.DeliveryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignOrders extends AppCompatActivity {

    private DatabaseReference delref,orderref;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String orderId="";
    private String Delname="";
    private String DelAddress="";
    private String EXTime="";
    private String payment="";
    private String Totalamount="";
    private String Unino="";
    private String Email1="";
    APIService mservice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mservice= Common.getFCMService();
        setContentView(R.layout.activity_assign_orders);

        Email1=getIntent().getStringExtra("Email");
        orderId=getIntent().getStringExtra("OrderID");
        Delname=getIntent().getStringExtra("DeliverTo");
        DelAddress=getIntent().getStringExtra("DeliverAddr");
        EXTime=getIntent().getStringExtra("ExpectedTime");
        payment=getIntent().getStringExtra("Payment");
        Totalamount=getIntent().getStringExtra("Totalamount");
        Unino=getIntent().getStringExtra("UniqueNo");
        delref= FirebaseDatabase.getInstance().getReference().child("Delivery Person Details");
        orderref = FirebaseDatabase.getInstance().getReference().child("Orders").child("User Order Details").child(orderId);

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<DeliveryModel> options=new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                .setQuery(delref.orderByChild("Status").equalTo("Approved"),DeliveryModel.class)
                .build();
        FirebaseRecyclerAdapter<DeliveryModel, AssignOrderViewHolder> adapter=new FirebaseRecyclerAdapter<DeliveryModel, AssignOrderViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AssignOrderViewHolder holder, int i, @NonNull final DeliveryModel model) {
                holder.txt_name.setText(model.getName());
                holder.phone.setText(model.getPhone());
               holder.location.setText(model.getLocation());
               Picasso.get().load(model.getPhoto()).into(holder.photo1);
                holder.assignorder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(AssignOrders.this);
                        builder1.setMessage("Are You Sure ,you want to use this delivery person?");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        orderref.child("state").setValue("shipped");
                                        delref.child(model.getPhone()).child("Orders").setValue("assigned");

                                        addnewnode(model.getPhone(),orderId);
                                        // OrderModel o = new OrderModel();
                                        DatabaseReference assignref=FirebaseDatabase.getInstance().getReference().child("Assigned Orders");

                                        final HashMap<String,Object> order=new HashMap<>();
                                        order.put("OrderId",orderId);
                                        order.put("DeliveryTo",Delname);
                                        order.put("DeliveryAddress",DelAddress);
                                        order.put("ShipperName",model.getName());
                                        order.put("ShipperPhoneNo",model.getPhone());
                                        order.put("ShipperImage",model.getPhoto());
                                        order.put("ExpectedTime",EXTime);
                                        order.put("payment",payment);
                                        order.put("Totalamount",Totalamount);
                                        order.put("state","shipped");
                                        order.put("CustomerEmail",Email1);


                                        assignref.child(model.getPhone()).child(orderId).updateChildren(order);

                                        sendUpdateToUser(orderId,model.getPhone());
                                        deletecart();

                                    }
                                });

                        builder1.setNegativeButton(
                                "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();


                    }
                });



            }
            @NonNull
            @Override
            public AssignOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.assign_orders_delboy,parent,false);
                AssignOrderViewHolder holder=new AssignOrderViewHolder(view);
                return holder;
            }
        };
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    private void addnewnode(String phone, String orderId) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("OrderID and PhoneNo");

        final HashMap<String,Object> newthing=new HashMap<>();
        newthing.put("OrderID",orderId);
        newthing.put("ShipperPhone",phone);

        db.child(orderId).updateChildren(newthing);



    }

    private void sendUpdateToUser(final String orderId, final String Phone) {
        DatabaseReference tokens=FirebaseDatabase.getInstance().getReference().child("Token");;
        tokens.orderByKey().equalTo(Unino).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Token servertoken=dataSnapshot1.getValue(Token.class);

                    Notification notification=new Notification("Your order "+orderId+" is shipped. View Orders to get further details on your order.","TMART");
                    Sender content=new Sender(servertoken.getToken(),notification);
                    mservice.sendNotification(content)
                            .enqueue(new Callback<MyResponse>() {
                                @Override
                                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                    if(response.body().success==1)
                                    {
                                        Toast.makeText(AssignOrders.this, "Order shipped", Toast.LENGTH_SHORT).show();
                                        finish();

                                        sendNotificationToShipper(Phone);
                                    }
                                    else
                                    {
                                        //Toast.makeText(AssignOrders.this, "Failed !!", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<MyResponse> call, Throwable t) {

                                    Log.e("ERROR",t.getMessage());
                                }
                            });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void sendNotificationToShipper(String phone) {
        DatabaseReference tokens=FirebaseDatabase.getInstance().getReference().child("Token").child("delivery person");;
        tokens.orderByKey().equalTo(phone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Token servertoken=dataSnapshot1.getValue(Token.class);

                    Notification notification=new Notification("New order "+orderId+" .","TMART");
                    Sender content=new Sender(servertoken.getToken(),notification);
                    mservice.sendNotification(content)
                            .enqueue(new Callback<MyResponse>() {
                                @Override
                                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                    if(response.body().success==1)
                                    {
                                        Toast.makeText(AssignOrders.this, "Order shipped", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(AssignOrders.this,AdminNewOrdersActivity.class);
                                        startActivity(i);
                                        finish();



                                    }
                                    else
                                    {
                                        //Toast.makeText(AssignOrders.this, "Failed !!", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<MyResponse> call, Throwable t) {

                                    Log.e("ERROR",t.getMessage());
                                }
                            });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void deletecart() {
        final DatabaseReference dbref=FirebaseDatabase.getInstance().getReference().child("Cart List");
        dbref.child("User View").child(Unino).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                dbref.child("Admin View").child(Unino).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       // Toast.makeText(AssignOrders.this, "finish", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });

    }

    public void Go_to_home(View view) {
        Intent i = new Intent(AssignOrders.this,Home.class);
        startActivity(i);
        finish();
    }
}
