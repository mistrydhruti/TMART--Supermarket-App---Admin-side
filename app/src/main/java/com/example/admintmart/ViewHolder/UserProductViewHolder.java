package com.example.admintmart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admintmart.Interface.ItemClickListner;
import com.example.admintmart.R;

public class UserProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_prodname,txt_prodprice,txt_mrp,txt_amount;
    public ImageView prod_image;

    public ItemClickListner listner;
    public UserProductViewHolder(@NonNull View itemView) {
        super(itemView);

        prod_image=(ImageView)itemView.findViewById(R.id.prod_image);
        txt_prodname=(TextView)itemView.findViewById(R.id.product_name);
        txt_prodprice=(TextView)itemView.findViewById(R.id.tmart_price);
        txt_mrp=(TextView)itemView.findViewById(R.id.mrp);
        txt_amount=(TextView)itemView.findViewById(R.id.num_of_items);

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