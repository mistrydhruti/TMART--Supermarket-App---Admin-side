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

public class Jams extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Jams ", "Spreads", "Honey", "Mayonnaise", "Dips and Dressing"};
    int images[] = {R.drawable.jams, R.drawable.spreads, R.drawable.honey, R.drawable.mayo, R.drawable.dips};
    private String type="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jams);

        type=getIntent().getExtras().get("type").toString();

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        // now set item click on list view
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                   // Toast.makeText(Jams.this, "Jams", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Jams.this,AddProductActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Jams");
                        i.putExtra("title","Breads and Bakery");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Jams.this, JamSection.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Jams.this,DeleteActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Jams");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Jams.this,SeeAllActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Jams");
                        i.putExtra("title","Breads and Bakery");
                        startActivity(i); } }


                if (position ==  1) {
                   // Toast.makeText(Jams.this, "Spreads", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Jams.this,AddProductActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Spreads");
                        i.putExtra("title","Spreads");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Jams.this, Spreads.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Jams.this,DeleteActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Spreads");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Jams.this,SeeAllActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Spreads");
                        i.putExtra("title","Spreads");
                        startActivity(i); } }

                if (position ==  2) {
                   // Toast.makeText(Jams.this, "Honey", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Jams.this,AddProductActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Honey");
                        i.putExtra("title","Honey");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Jams.this, Honey.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Jams.this,DeleteActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Honey");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Jams.this,SeeAllActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Honey");
                        i.putExtra("title","Honey");
                        startActivity(i); } }

                if (position ==  3) {
                    //Toast.makeText(Jams.this, "Mayonnaise", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Jams.this,AddProductActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Mayonnaise");
                        i.putExtra("title","Mayonnaise");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Jams.this, Mayonnaise.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Jams.this,DeleteActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Mayonnaise");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Jams.this,SeeAllActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Mayonnaise");
                        i.putExtra("title","Mayonnaise");
                        startActivity(i); } }

                if (position ==  4) {
                   // Toast.makeText(Jams.this, "dips and Dressing", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Jams.this,AddProductActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Dips and Dressings");
                        i.putExtra("title","Dips and Dressings");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Jams.this, Dips.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Jams.this,DeleteActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Dips and Dressings");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Jams.this,SeeAllActivity.class);
                        i.putExtra("Categories","Jams and Spreads -> Dips and Dressings");
                        i.putExtra("title","Dips and Dressings");
                        startActivity(i); } }

            }
        });
        // so item click is done now check list view
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(Jams.this,Home.class);
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
        Intent i = new Intent(Jams.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }
}


