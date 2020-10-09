package com.example.admintmart;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class SeeAllActivity extends AppCompatActivity {
    private EditText product_name,product_description,product_price,savings,mrp,quantity;
    private ImageView select_product_image;
    private Button add_product;
    private String CategoryName,Description,Price,Pname,Savings,saveCurrentDate,saveCurrentTime,Mrp,Quantity;
    private static final int GalleryPick=1;
    private Uri ImageUri;
    private String productRandomKey,downloadImageUri;
    private StorageReference ProductImageRef;
    private DatabaseReference ProductRef;
    private ProgressDialog loadingBar;

    private TextView title;
    private String tile="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        CategoryName=getIntent().getExtras().get("Categories").toString();
        ProductImageRef= FirebaseStorage.getInstance().getReference().child("Best Selling");
        ProductRef = FirebaseDatabase.getInstance().getReference().child("Best Selling");

        tile=getIntent().getStringExtra("title");
        title=findViewById(R.id.title);
        title.setText(tile);

        product_name=(EditText)findViewById(R.id.product_name);
        product_description=(EditText)findViewById(R.id.product_description);
        product_price=(EditText)findViewById(R.id.product_price);
        mrp=(EditText)findViewById(R.id.mrp);
        quantity=(EditText)findViewById(R.id.product_quantity);
        savings=(EditText)findViewById(R.id.savings);
        select_product_image=(ImageView)findViewById(R.id.select_product_image);
        add_product=(Button)findViewById(R.id.add_new_product);
        loadingBar=new ProgressDialog(this);


        select_product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateProductData();
            }
        });
    }

    private void OpenGallery() {

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GalleryPick && resultCode==RESULT_OK && data!=null)
        {
            ImageUri=data.getData();
            select_product_image.setImageURI(ImageUri);
        }
    }

    private void ValidateProductData() {
        Description=product_description.getText().toString();
        Price=product_price.getText().toString();
        Pname=product_name.getText().toString();
        Savings=savings.getText().toString();
        Mrp=mrp.getText().toString();
        Quantity=quantity.getText().toString();



        if(ImageUri == null)
        {
            Toast.makeText(this, "Product image is required", Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(Description))
        {
            product_description.setError("This field is required");
            product_description.requestFocus();
        }
        else if(TextUtils.isEmpty(Price))
        {
            product_price.setError("This field is required");
            product_price.requestFocus();
        }
        else if(TextUtils.isEmpty(Pname))
        {
            product_name.setError("This field is required");
            product_name.requestFocus();
        }
        else if(TextUtils.isEmpty(Savings))
        {
            savings.setError("This field is required");
            savings.requestFocus();
        }
        else if(TextUtils.isEmpty(Mrp))
        {
            savings.setError("This field is required");
            savings.requestFocus();
        }
        else if(TextUtils.isEmpty(Quantity))
        {
            quantity.setError("This field is required");
            quantity.requestFocus();
        }

        else
        {
            StoreProductInformation();
        }
    }

    private void StoreProductInformation() {
        loadingBar.setTitle("Adding new Product");
        loadingBar.setMessage("Please wait, while we add new product");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar=Calendar.getInstance();

        SimpleDateFormat currentdate=new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentdate.format(calendar.getTime());

        SimpleDateFormat currenttime=new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currenttime.format(calendar.getTime());

        productRandomKey=saveCurrentDate+saveCurrentTime;


        final StorageReference filepath=ProductImageRef.child(ImageUri.getLastPathSegment() + Pname + ".jpg");

        final UploadTask uploadTask= filepath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message=e.toString();
                Toast.makeText( SeeAllActivity.this, "Error"+message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

               // Toast.makeText(SeeAllActivity.this, "Product Image Uploaded succesfuly", Toast.LENGTH_SHORT).show();
                Task<Uri> uriTask=uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if(!task.isSuccessful())
                        {
                            throw task.getException();

                        }
                        downloadImageUri=filepath.getDownloadUrl().toString();
                        return filepath.getDownloadUrl();

                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if(task.isSuccessful())
                        {
                            downloadImageUri=task.getResult().toString();
                           // Toast.makeText(SeeAllActivity.this, "got the product image uri successfully", Toast.LENGTH_SHORT).show();

                            saveProductInfoToDatabase();
                        }
                    }
                });

            }
        });


    }

    private void saveProductInfoToDatabase() {

        HashMap<String,Object> productMap=new HashMap<>();
        productMap.put("pid",productRandomKey);
        productMap.put("date",saveCurrentDate);
        productMap.put("time",saveCurrentTime);
        productMap.put("Description",Description);
        productMap.put("Image",downloadImageUri);
        productMap.put("Category",CategoryName);
        productMap.put("price",Price);
        productMap.put("Pname",Pname);
        productMap.put("Savings",Savings);
        productMap.put("Mrp",Mrp);
        productMap.put("Quantity",Quantity);

        ProductRef.child(productRandomKey).updateChildren(productMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            //Intent i = new Intent(SeeAllActivity.this,ShopByCategories.class);
                           // startActivity(i);
                            loadingBar.dismiss();
                           // Toast.makeText(SeeAllActivity.this, "Product is added successfully", Toast.LENGTH_SHORT).show();

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(SeeAllActivity.this);
                            builder1.setMessage("Product Added Successfully !");
                            builder1.setCancelable(true);
                            builder1.setPositiveButton("ok",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            product_description.getText().clear();
                                            product_price.getText().clear();
                                            product_name.getText().clear();
                                            savings.getText().clear();
                                            mrp.getText().clear();
                                            quantity.getText().clear();



                                                                                 }

                                    });


                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }
                        else
                        {
                            loadingBar.dismiss();
                            String message=task.getException().toString();
                            Toast.makeText(SeeAllActivity.this, "Error"+message, Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(SeeAllActivity.this,Home.class);
        startActivity(i);
        finish(); }
}
