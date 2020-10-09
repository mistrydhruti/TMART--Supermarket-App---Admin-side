package com.example.admintmart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Masala extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Powdered Spices","Whole Spices","Cooking Pastes","Herbs and Seasionings","Ready Mix Masalas"};
    int images[] = {R.drawable.powderedspices, R.drawable.whole, R.drawable.cookingoil, R.drawable.herbs, R.drawable.readymix};
    private String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masala);
        type=getIntent().getExtras().get("type").toString();


        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        // now set item click on list view
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    //Toast.makeText(Masala.this, "Powdered Spices", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Masala.this,AddProductActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Powdered Spices");
                        i.putExtra("title","Powdered Spices");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Masala.this, Powdered.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Masala.this,DeleteActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Powdered Spices");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Masala.this,SeeAllActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Powdered Spices");
                        i.putExtra("title","Powdered Spices");
                        startActivity(i); } }

                if (position ==  1) {
                  //  Toast.makeText(Masala.this, "Whole Spices", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Masala.this,AddProductActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Whole Spices");
                        i.putExtra("title","Whole Spices");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Masala.this, Whole.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Masala.this,DeleteActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Whole Spices");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Masala.this,SeeAllActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Whole Spices");
                        i.putExtra("title","Whole Spices");
                        startActivity(i); } }

                if (position ==  2) {
                    //Toast.makeText(Masala.this, "Cooking Pastes", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Masala.this,AddProductActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Cooking Pastes");
                        i.putExtra("title","Cooking Pastes");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Masala.this, Cooking.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Masala.this,DeleteActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Cooking Pastes");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Masala.this,SeeAllActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Cooking Pastes");
                        i.putExtra("title","Cooking Pastes");
                        startActivity(i); } }

                if (position ==  3) {
                  //  Toast.makeText(Masala.this, "Herbs and Seasonings", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Masala.this,AddProductActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Herbs and Seasonings");
                        i.putExtra("title","Herbs and Seasonings");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Masala.this, Herbs.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Masala.this,DeleteActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Herbs and Seasonings");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Masala.this,SeeAllActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Herbs and Seasonings");
                        i.putExtra("title","Herbs and Seasonings");
                        startActivity(i); } }

                if (position ==  4) {
                   // Toast.makeText(Masala.this, "Ready Mix Masalas", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Masala.this,AddProductActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Ready Mix Masaalas");
                        i.putExtra("title","Ready Mix Masaalas");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Masala.this, Ready.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Masala.this,DeleteActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Ready Mix Masaalas");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Masala.this,SeeAllActivity.class);
                        i.putExtra("Categories","Masalas and Spices -> Ready Mix Masaalas");
                        i.putExtra("title","Ready Mix Masaalas");
                        startActivity(i); } }


            }
        });
        // so item click is done now check list view
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(Masala.this,Home.class);
        startActivity(i);
        finish();
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        //String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[],  int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            //  this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            //TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            //  myDescription.setText(rDescription[position]);




            return row;
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Masala.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }
}


