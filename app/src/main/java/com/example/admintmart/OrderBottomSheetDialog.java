package com.example.admintmart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderBottomSheetDialog extends BottomSheetDialogFragment {

    private DatabaseReference delref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.orderhistory_bottom_sheet,container,false);

        Bundle bundle = getArguments();
        String Link = bundle.getString("link");

        //DeliveryModel d=new DeliveryModel();
        delref= FirebaseDatabase.getInstance().getReference().child("Order History").child(Link);

        final TextView orderid=(TextView)v.findViewById(R.id.orderid);
        final TextView delname=(TextView)v.findViewById(R.id.delname);
        final TextView delphone=(TextView)v.findViewById(R.id.delphone);
        final TextView custemail=(TextView)v.findViewById(R.id.customer_email);
        final TextView orderdate=(TextView)v.findViewById(R.id.orderdate);






        delref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String date=dataSnapshot.child("DeliveredDate").getValue().toString();
                    String em=dataSnapshot.child("CustomerEmail").getValue().toString();
                    String oid=dataSnapshot.child("OrderId").getValue().toString();
                    String shname=dataSnapshot.child("ShipperName").getValue().toString();
                    String shphone=dataSnapshot.child("ShipperPhoneNo").getValue().toString();


                    orderid.setText(oid);
                    delname.setText(shname);
                    delphone.setText(shphone);
                    custemail.setText(em);
                    orderdate.setText(date);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return v;
    }


}

