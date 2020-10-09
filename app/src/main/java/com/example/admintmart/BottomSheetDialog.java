package com.example.admintmart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.admintmart.Model.DeliveryModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private DatabaseReference delref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout,container,false);

        Bundle bundle = getArguments();
        String Link = bundle.getString("link");

        //DeliveryModel d=new DeliveryModel();
        delref= FirebaseDatabase.getInstance().getReference().child("Delivery Person Details").child(Link);

        final TextView name=(TextView)v.findViewById(R.id.delboy_name);
        final TextView phone=(TextView)v.findViewById(R.id.delboy_phone);
        final TextView aadhar=(TextView)v.findViewById(R.id.delboy_aadhar);
        final TextView drivli=(TextView)v.findViewById(R.id.delboy_license);
        final TextView location=(TextView)v.findViewById(R.id.delboy_location);



        delref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String N=dataSnapshot.child("Name").getValue().toString();
                    String P=dataSnapshot.child("Phone").getValue().toString();
                    String A=dataSnapshot.child("Aadhar").getValue().toString();
                    String D=dataSnapshot.child("DrivingLicense").getValue().toString();
                    String L=dataSnapshot.child("Location").getValue().toString();



                    name.setText(N);
                    phone.setText(P);
                    aadhar.setText(A);
                    drivli.setText(D);
                    location.setText(L);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return v;
    }


}
