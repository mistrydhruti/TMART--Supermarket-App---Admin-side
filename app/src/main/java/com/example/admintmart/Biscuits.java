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

public class Biscuits extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Cookies","Glucose Biscuits","Marie Biscuits","Salty BIscuits","Cream Biscuits","Wafer Biscuits","Khari and toast"};
    int images[] = {R.drawable.biscuits, R.drawable.glucose, R.drawable.marie, R.drawable.salty, R.drawable.cream,R.drawable.wafer,R.drawable.khari};
    private String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscuits);
        type=getIntent().getExtras().get("type").toString();
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);
        // now set item click on list view
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                   // Toast.makeText(Biscuits.this, "Cookies", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cookies");
                        i.putExtra("title","Cookies");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, Cookies.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cookies");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cookies");
                        i.putExtra("title","Cookies");
                        startActivity(i); } }

                if (position ==  1) {
                   // Toast.makeText(Biscuits.this, "Glucose Biscuits", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Glucose Biscuits");
                        i.putExtra("title","Glucose Biscuits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, Glucose.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Glucose Biscuits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Glucose Biscuits");
                        i.putExtra("title","Glucose Biscuits");
                        startActivity(i); } }

                if (position ==  2) {
                   // Toast.makeText(Biscuits.this, "Marie Biscuits", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Marie Biscuits");
                        i.putExtra("title","Marie Biscuits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, Marie.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Marie Biscuits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Marie Biscuits");
                        i.putExtra("title","Marie Biscuits");
                        startActivity(i); } }

                if (position ==  3) {
                   // Toast.makeText(Biscuits.this, "Salty Biscuits", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Salty Biscuits");
                        i.putExtra("title","Salty Biscuits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, Salty.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Salty Biscuits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Salty Biscuits");
                        i.putExtra("title","Salty Biscuits");
                        startActivity(i); } }

                if (position ==  4) {
                   // Toast.makeText(Biscuits.this, "Cream Biscuits", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cream Biscuits");
                        i.putExtra("title","Cream Biscuits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, CreamBiscuits.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cream Biscuits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Cream Biscuits");
                        i.putExtra("title","Cream Biscuits");
                        startActivity(i); } }

                if (position ==  5) {
                   // Toast.makeText(Biscuits.this, "Wafer Biscuits", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Wafer Biscuits");
                        i.putExtra("title","Wafer Biscuits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, WaferBiscuits.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Wafer Biscuits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Wafer Biscuits");
                        i.putExtra("title","Wafer Biscuits");
                        startActivity(i); } }

                if (position ==  6) {
                   // Toast.makeText(Biscuits.this, "Khari and Toasts", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Biscuits.this,AddProductActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Khari and Toast");
                        i.putExtra("title","Khari and Toast");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Biscuits.this, Khari.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Biscuits.this,DeleteActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Khari and Toast");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Biscuits.this,SeeAllActivity.class);
                        i.putExtra("Categories","Biscuits and Cookies -> Khari and Toast");
                        i.putExtra("title","Khari and Toast");
                        startActivity(i); } }


            }
        });
    }


    public void Go_to_home(View view) {
        Intent i = new Intent(Biscuits.this,Home.class);
        startActivity(i);
        finish(); }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];
        MyAdapter (Context c, String title[],  int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Biscuits.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }

}


