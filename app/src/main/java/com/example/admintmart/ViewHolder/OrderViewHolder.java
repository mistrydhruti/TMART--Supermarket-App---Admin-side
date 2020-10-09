package com.example.admintmart.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admintmart.Interface.ItemClickListner;
import com.example.admintmart.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_name,txt_email,txt_address,txt_date,txt_time,txt_price,txt_extime,txt_payment,txt_ordtime;
    public Button viewprod,assignord;

    public ItemClickListner listner;
    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);


        txt_name=(TextView) itemView.findViewById(R.id.user_name);
        txt_email=(TextView)itemView.findViewById(R.id.email);
        txt_address=(TextView)itemView.findViewById(R.id.order_address);
        txt_date=(TextView)itemView.findViewById(R.id.order_date);
        txt_time=(TextView)itemView.findViewById(R.id.order_time);
        txt_price=(TextView)itemView.findViewById(R.id.order_totprice);
        txt_extime=(TextView)itemView.findViewById(R.id.delivery_time);
        txt_payment=(TextView)itemView.findViewById(R.id.payment_method);
        viewprod=(Button)itemView.findViewById(R.id.viewprod);
        assignord=(Button)itemView.findViewById(R.id.assignorderdel);

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
