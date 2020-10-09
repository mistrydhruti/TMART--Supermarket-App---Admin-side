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

public class PersonalCare extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Skin Care ", "Hair Care", "Oral Care", "Sanitary Napkins", "Deos and Perfumes", "Shaving Creams"};
    int images[] = {R.drawable.skincare, R.drawable.haircare, R.drawable.oralcare, R.drawable.sanitarycare, R.drawable.deos,R.drawable.shaving};
    private String type="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_care);
        type=getIntent().getExtras().get("type").toString();


        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        // now set item click on list view
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    //Toast.makeText(PersonalCare.this, "Skin Care", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Skin Care");
                        i.putExtra("title","Skin Care");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Skin.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Skin Care");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Skin Care");
                        i.putExtra("title","Skin Care");
                        startActivity(i); }

                }
                if (position ==  1) {
                  //  Toast.makeText(PersonalCare.this, "Hair Care", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Hair Care");
                        i.putExtra("title","Hair Care");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Hair.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Hair Care");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Hair Care");
                        i.putExtra("title","Hair Care");
                        startActivity(i); }

                }
                if (position ==  2) {
                  //  Toast.makeText(PersonalCare.this, "Oral Care", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Oral Care");
                        i.putExtra("title","Oral Care");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Oral.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Oral Care");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Oral Care");
                        i.putExtra("title","Oral Care");
                        startActivity(i); }

                }
                if (position ==  3) {
                   // Toast.makeText(PersonalCare.this, "Sanitary Napkins", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Sanitary Napkins");
                        i.putExtra("title","Sanitary Napkins");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Sanitory.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Sanitary Napkins");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Sanitary Napkins");
                        i.putExtra("title","Sanitary Napkins");
                        startActivity(i); }


                }
                if (position ==  4) {
                   // Toast.makeText(PersonalCare.this, "deos and perfumes", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Deos and Perfumes");
                        i.putExtra("title","Deos and Perfumes");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Deos.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Deos and Perfumes");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Deos and Perfumes");
                        i.putExtra("title","Deos and Perfumes");
                        startActivity(i); }

                }
                if (position ==  5) {
                   // Toast.makeText(PersonalCare.this, "shaviing creams", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(PersonalCare.this,AddProductActivity.class);
                        i.putExtra("Categories","Personal Care -> Shaving Needs");
                        i.putExtra("title","Shaving Needs");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(PersonalCare.this, Shave.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(PersonalCare.this,DeleteActivity.class);
                        i.putExtra("Categories","Personal Care -> Shaving Needs");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(PersonalCare.this,SeeAllActivity.class);
                        i.putExtra("Categories","Personal Care -> Shaving Needs");
                        i.putExtra("title","Shaving Needs");
                        startActivity(i); }

                }
            }
        });
        // so item click is done now check list view
    }


    public void Go_to_home(View view) {
        Intent i = new Intent(PersonalCare.this,Home.class);
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
        Intent i = new Intent(PersonalCare.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);
    }

}


