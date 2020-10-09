package com.example.admintmart.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admintmart.Interface.ItemClickListner;
import com.example.admintmart.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderHistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView order_id,order_date;
    public CircleImageView detail;

    public ItemClickListner listner;
    public OrderHistoryViewHolder(@NonNull View itemView) {
        super(itemView);


        order_id=(TextView)itemView.findViewById(R.id.order_id);
        order_date=(TextView)itemView.findViewById(R.id.order_date);
        detail=(CircleImageView) itemView.findViewById(R.id.detail);


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
