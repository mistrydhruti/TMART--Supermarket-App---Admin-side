package com.example.admintmart.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admintmart.Interface.ItemClickListner;
import com.example.admintmart.R;

public class DetailsDeliveryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_name,phone,location;
    public ImageView photo1;
    public Button details;

    public ItemClickListner listner;
    public DetailsDeliveryViewHolder(@NonNull View itemView) {
        super(itemView);


        txt_name=(TextView)itemView.findViewById(R.id.del_name);
        phone=(TextView)itemView.findViewById(R.id.del_phone);
        location=(TextView)itemView.findViewById(R.id.del_location);

        photo1=(ImageView)itemView.findViewById(R.id.see_image);
        details=(Button)itemView.findViewById(R.id.details);

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