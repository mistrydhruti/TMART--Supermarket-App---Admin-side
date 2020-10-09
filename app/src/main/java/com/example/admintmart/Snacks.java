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

public class Snacks extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"PopCorn ", "Sev and Mixture", "Chips and Mixture", "Namkeen", "other snacks"};
    int images[] = {R.drawable.popcorn, R.drawable.sev, R.drawable.chips, R.drawable.namkeen, R.drawable.snacks2};
    private String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        type=getIntent().getExtras().get("type").toString();


        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    //Toast.makeText(Snacks.this, "PopCorn", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Snacks.this,AddProductActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> PopCorn");
                        i.putExtra("title","PopCorn");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Snacks.this, Popcorn.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Snacks.this,DeleteActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> PopCorn");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Snacks.this,SeeAllActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> PopCorn");
                        i.putExtra("title","PopCorn");
                        startActivity(i); } }

                if (position ==  1) {
                    //Toast.makeText(Snacks.this, "Sev and Miixture", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Snacks.this,AddProductActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Sev and Mixture");
                        i.putExtra("title","Sev and Mixture");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Snacks.this, Sev.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Snacks.this,DeleteActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Sev and Mixture");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Snacks.this,SeeAllActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Sev and Mixture");
                        i.putExtra("title","Sev and Mixture");
                        startActivity(i); } }

                if (position ==  2) {
                   // Toast.makeText(Snacks.this, "Chips and Mixture", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Snacks.this,AddProductActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Chips and Wafers");
                        i.putExtra("title","Chips and Wafers");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Snacks.this, Chips.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Snacks.this,DeleteActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Chips and Wafers");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Snacks.this,SeeAllActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Chips and Wafers");
                        i.putExtra("title","Chips and Wafers");
                        startActivity(i); } }

                if (position ==  3) {
                   // Toast.makeText(Snacks.this, "Namkeen", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Snacks.this,AddProductActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Namkeens");
                        i.putExtra("title","Namkeens");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Snacks.this, Namkeen.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Snacks.this,DeleteActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Namkeens");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Snacks.this,SeeAllActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Namkeens");
                        i.putExtra("title","Namkeens");
                        startActivity(i); } }


                if (position ==  4) {
                    Toast.makeText(Snacks.this, "Other Snacks", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Snacks.this,AddProductActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Other Snacks");
                        i.putExtra("title","Other Snacks");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Snacks.this, OtherSnack.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Snacks.this,DeleteActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Other Snacks");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Snacks.this,SeeAllActivity.class);
                        i.putExtra("Categories","Snacks and Farsan -> Other Snacks");
                        i.putExtra("title","Other Snacks");
                        startActivity(i); } }


            }
        });
        // so item click is done now check list view
    }


    public void Go_to_home(View view) {
        Intent i = new Intent(Snacks.this,Home.class);
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
        Intent i = new Intent(Snacks.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }

}

