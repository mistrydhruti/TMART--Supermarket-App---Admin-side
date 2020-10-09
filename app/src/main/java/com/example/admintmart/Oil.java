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

public class Oil extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Sunflower oil","Blended Oil","Rice Bran Oil","Groundnut Oil","Olive Oil","Mustard oil"};
    int images[] = {R.drawable.sunfloweroil, R.drawable.cookingoil, R.drawable.ricebranoil, R.drawable.groundnutoil, R.drawable.cookingoil,R.drawable.mustardoil};
    private String type="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);

        type=getIntent().getExtras().get("type").toString();

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);
        // now set item click on list view
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                   // Toast.makeText(Oil.this, "Sunflower Oil", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Oil.this,AddProductActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Sunflower Oil");
                        i.putExtra("title","Sunflower Oil");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Oil.this, SunflowerOil.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Oil.this,DeleteActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Sunflower Oil");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Oil.this,SeeAllActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Sunflower Oil");
                        i.putExtra("title","Sunflower Oil");
                        startActivity(i); } }

                    if (position ==  1) {
                   // Toast.makeText(Oil.this, "Blended Oil", Toast.LENGTH_SHORT).show();
                        if(type.equals("addproduct")) {
                            Intent i = new Intent(Oil.this,AddProductActivity.class);
                            i.putExtra("Categories","Cooking Oil -> Blended Oil");
                            i.putExtra("title","Blended Oil");
                            startActivity(i); }
                        else if(type.equals("updateproduct")) {
                            Intent intent1 = new Intent(Oil.this, BlendedOil.class);
                            startActivity(intent1); }
                        else if(type.equals("deleteproduct")) {
                            Intent i = new Intent(Oil.this,DeleteActivity.class);
                            i.putExtra("Categories","Cooking Oil -> Blended Oil");
                            startActivity(i); }
                        else if(type.equals("seeallproduct")) {
                            Intent i = new Intent(Oil.this,SeeAllActivity.class);
                            i.putExtra("Categories","Cooking Oil -> Blended Oil");
                            i.putExtra("title","Blended Oil");
                            startActivity(i); } }

                if (position ==  2) {
                   // Toast.makeText(Oil.this, "Rice Bran Oil", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Oil.this,AddProductActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Rice Bran  Oil");
                        i.putExtra("title","Rice Bran  Oil");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Oil.this, RiceBranOil.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Oil.this,DeleteActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Rice Bran  Oil");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Oil.this,SeeAllActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Rice Bran  Oil");
                        i.putExtra("title","Rice Bran  Oil");
                        startActivity(i); } }


                if (position ==  3) {
                  //  Toast.makeText(Oil.this, "Groundnut Oil", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Oil.this,AddProductActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Groundnut Oil");
                        i.putExtra("title","Groundnut Oil");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Oil.this, GroundnutOil.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Oil.this,DeleteActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Groundnut Oil");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Oil.this,SeeAllActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Groundnut Oil");
                        i.putExtra("title","Groundnut Oil");
                        startActivity(i); } }

                if (position ==  4) {
                    //Toast.makeText(Oil.this, "Olive Oil", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Oil.this,AddProductActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Olive Oil");
                        i.putExtra("title","Olive Oil");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Oil.this, OliveOil.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Oil.this,DeleteActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Olive Oil");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Oil.this,SeeAllActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Olive Oil");
                        i.putExtra("title","Olive Oil");
                        startActivity(i); } }

                if (position ==  5) {
                   // Toast.makeText(Oil.this, "Mustard Oil", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Oil.this,AddProductActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Mustard Oil");
                        i.putExtra("title","Mustard Oil");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Oil.this, Mustard.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Oil.this,DeleteActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Mustard Oil");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Oil.this,SeeAllActivity.class);
                        i.putExtra("Categories","Cooking Oil -> Mustard Oil");
                        i.putExtra("title","Mustard Oil");
                        startActivity(i); } }


            }
        });
        // so item click is done now check list view
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(Oil.this,Home.class);
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
        Intent i = new Intent(Oil.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }
}