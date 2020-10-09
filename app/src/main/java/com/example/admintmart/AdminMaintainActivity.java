package com.example.admintmart;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AdminMaintainActivity extends AppCompatActivity {
    private EditText product_name,product_description,product_price,savings,mrp,quantity;
    private ImageView select_product_image;
    private Button applychangebtn;
    private String category="";
    private String pname="";
    private String pimage="";
    private String saveCurrentDate,saveCurrentTime;
    private DatabaseReference productsRef;
    private String productRandomKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintain);

        category=getIntent().getStringExtra("category");
        pname=getIntent().getStringExtra("name");
        pimage=getIntent().getStringExtra("image");

        productsRef= FirebaseDatabase.getInstance().getReference().child("Products").child(category);

        product_name=(EditText)findViewById(R.id.product_name_maintain);
        product_description=(EditText)findViewById(R.id.product_description_maintain);
        product_price=(EditText)findViewById(R.id.product_price_maintain);
        mrp=(EditText)findViewById(R.id.mrp_maintain);
        quantity=(EditText)findViewById(R.id.product_quantity_maintain);
        savings=(EditText)findViewById(R.id.savings_maintain);
        select_product_image=(ImageView)findViewById(R.id.select_product_image_maintain);
        applychangebtn=(Button)findViewById(R.id.apply_changes);

        displaySpecificProductInfo();

        applychangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                applychanges();
            }
        });

    }

    private void applychanges() {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentdate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentdate.format(calendar.getTime());

        SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currenttime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;


        String pName = product_name.getText().toString();
        String description = product_description.getText().toString();
        String price = product_price.getText().toString();
        String pmrp = mrp.getText().toString();
        String save = savings.getText().toString();
        String quant = quantity.getText().toString();

        if (pName.equals("")) {
            product_name.setError("This field is required");
            product_name.requestFocus();
        } else if (description.equals("")) {
            product_description.setError("This field is required");
            product_description.requestFocus();
        } else if (price.equals("")) {
            product_price.setError("This field is required");
            product_price.requestFocus();
        } else if (pmrp.equals("")) {
            mrp.setError("This field is required");
            mrp.requestFocus();
        } else if (save.equals("")) {
            savings.setError("This field is required");
            savings.requestFocus();

        } else if (quant.equals("")) {
            quantity.setError("This field is required");
            quantity.requestFocus();
        }
        else {
            HashMap<String, Object> productMap = new HashMap<>();
            productMap.put("pid", productRandomKey);
            productMap.put("date", saveCurrentDate);
            productMap.put("time", saveCurrentTime);
            productMap.put("Description", description);
            productMap.put("Pname", pName);
            productMap.put("Category", category);
            productMap.put("price", price);
            productMap.put("Savings", save);
            productMap.put("Mrp", pmrp);
            productMap.put("Quantity", quant);


            productsRef.child(pName).updateChildren(productMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                //Toast.makeText(AdminMaintainActivity.this, "Changes applied Successfully", Toast.LENGTH_SHORT).show();

                                AlertDialog.Builder builder1 = new AlertDialog.Builder(AdminMaintainActivity.this);
                                builder1.setMessage("Product Updated Successfully !");
                                builder1.setCancelable(true);

                                AlertDialog alert11 = builder1.create();
                                alert11.show();

                            }
                        }
                    });

        }

    }


    private void displaySpecificProductInfo() {
        productsRef.child(pname).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String Pname=dataSnapshot.child("Pname").getValue().toString();
                    String Description=dataSnapshot.child("Description").getValue().toString();
                    String price=dataSnapshot.child("price").getValue().toString();
                    String Mrp = dataSnapshot.child("Mrp").getValue().toString();
                    String Savings=dataSnapshot.child("Savings").getValue().toString();
                    String Quantity=dataSnapshot.child("Quantity").getValue().toString();
                    String Image=dataSnapshot.child("Image").getValue().toString();

                    product_name.setText(Pname);
                    product_description.setText(Description);
                    product_price.setText(price);
                    mrp.setText(Mrp);
                    quantity.setText(Quantity);
                    savings.setText(Savings);
                    Picasso.get().load(Image).into(select_product_image);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(AdminMaintainActivity.this,Home.class);
        startActivity(i);
        finish(); }
}
