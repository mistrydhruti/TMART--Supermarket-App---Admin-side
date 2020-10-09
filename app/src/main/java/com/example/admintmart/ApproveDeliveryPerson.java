package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admintmart.Model.DeliveryModel;
import com.example.admintmart.Model.ProductModel;
import com.example.admintmart.ViewHolder.DeliveryViewHolder;
import com.example.admintmart.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Random;

public class ApproveDeliveryPerson extends AppCompatActivity {

    private DatabaseReference delref;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    int n1;
    private TextView tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_delivery_person);

        delref= FirebaseDatabase.getInstance().getReference().child("Delivery Person Details");
        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tit=findViewById(R.id.tit);

        delref.orderByChild("Status").equalTo("not approved").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int a=(int)dataSnapshot.getChildrenCount();
              //  tit.setText(String.valueOf(a));
                if(a==0)
                {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(ApproveDeliveryPerson.this);
                    builder1.setMessage("No New Registration");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(ApproveDeliveryPerson.this,Home.class);
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
        FirebaseRecyclerOptions<DeliveryModel> options=new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                .setQuery(delref.orderByChild("Status").equalTo("not approved"),DeliveryModel.class)
                .build();
        FirebaseRecyclerAdapter<DeliveryModel, DeliveryViewHolder> adapter=new FirebaseRecyclerAdapter<DeliveryModel, DeliveryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull DeliveryViewHolder holder, int i, @NonNull final DeliveryModel model) {
               holder.txt_name.setText(model.getName());
               holder.phone.setText(model.getPhone());
               Picasso.get().load(model.getPhoto()).into(holder.photo);

               holder.details.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       BottomSheetDialog bottomSheetDialog= new BottomSheetDialog();
                       Bundle bundle = new Bundle();
                       bundle.putString("link",model.getPhone());
                       bottomSheetDialog.setArguments(bundle);
                       bottomSheetDialog.show(getSupportFragmentManager(),"Details");

                   }
               });

               holder.approve.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {


                      // final String phoneno=model.getPhone();
                       ChangeStatus(model.getPhone(),model.getEmail(),model.getName(),model.getLocation());
                   }
               });
               holder.reject.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       delref.child(model.getPhone()).child("Status").setValue("rejected").addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               Toast.makeText(ApproveDeliveryPerson.this, "Rejected Successfully!", Toast.LENGTH_SHORT).show();
                           }
                       });
                   }
               });
            }
            @NonNull
            @Override
            public DeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_boy_layout,parent,false);
                DeliveryViewHolder holder=new DeliveryViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    private void ChangeStatus(final String phoneno, final String email, final String delname, final String loc) {
        delref.child(phoneno).child("Status").setValue("Approved").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Random r = new Random();
                n1=r.nextInt(1000000000);

                DatabaseReference appro=FirebaseDatabase.getInstance().getReference().child("Approved Login Details");

                HashMap<String, Object> appo  = new HashMap<>();
                appo.put("ID",String.valueOf(n1));
                appo.put("Password",phoneno);
                appo.put("Name",delname);
                appo.put("Location",loc);

                appro.child(phoneno).updateChildren(appo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        String subject = "Admin Approval !";
                        String message = "Congratulations you can now take orders. Your Id and passowrd for login are as follows : " +
                                "ID = "+String.valueOf(n1)+"  and password is your phone number.  Tmart family is happy to work with you.";

                        //Creating SendMail object
                        SendMail sm = new SendMail(ApproveDeliveryPerson.this, email, subject, message);

                        //Executing sendmail to send email
                        sm.execute();

                        Toast.makeText(ApproveDeliveryPerson.this, "Delivery Person is now available to take orders", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
    }


    public void Go_to_home(View view) {
        Intent i = new Intent(ApproveDeliveryPerson.this,Home.class);
        startActivity(i);
        finish();

    }
}
