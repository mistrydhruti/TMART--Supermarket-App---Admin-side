package com.example.admintmart.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admintmart.Interface.ItemClickListner;
import com.example.admintmart.R;

public class DeliveryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_name,phone;
    public ImageView photo;
    public Button details,approve,reject;

    public ItemClickListner listner;
    public DeliveryViewHolder(@NonNull View itemView) {
        super(itemView);


       txt_name=(TextView)itemView.findViewById(R.id.del_name);
       phone=(TextView)itemView.findViewById(R.id.del_phone);
       photo=(ImageView)itemView.findViewById(R.id.del_image);
       details=(Button)itemView.findViewById(R.id.details_delboy);
       approve=(Button)itemView.findViewById(R.id.approve);
       reject=(Button)itemView.findViewById(R.id.reject);

    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner=listner;
    }

    @Override
    public void onClick(View v) {
        listner.onClick(v,getAdapterPosition(),false);

    }
}



