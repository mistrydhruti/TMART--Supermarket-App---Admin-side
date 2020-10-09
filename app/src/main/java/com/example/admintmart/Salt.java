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

public class Salt extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Salt ", "Sugar","Jaggery"};
    int images[] = {R.drawable.salt, R.drawable.sugar, R.drawable.jaggery};
    private String type="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salt);

        type=getIntent().getExtras().get("type").toString();

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);
        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                   // Toast.makeText(Salt.this, "Salt", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Salt.this,AddProductActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Salt");
                        i.putExtra("title","Salt");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Salt.this, SaltSection.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Salt.this,DeleteActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Salt");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Salt.this,SeeAllActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Salt");
                        i.putExtra("title","Salt");
                        startActivity(i); } }

                if (position ==  1) {
                   // Toast.makeText(Salt.this, "Sugar", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Salt.this,AddProductActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Sugar");
                        i.putExtra("title","Sugar");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Salt.this, Sugar.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Salt.this,DeleteActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Sugar");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Salt.this,SeeAllActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Sugar");
                        i.putExtra("title","Sugar");
                        startActivity(i); } }

                if (position ==  2) {
                    Toast.makeText(Salt.this, "Jaggery", Toast.LENGTH_SHORT).show();
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Salt.this,AddProductActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Jaggery");
                        i.putExtra("title","Jaggery");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Salt.this, Jaggery.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Salt.this,DeleteActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Jaggery");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Salt.this,SeeAllActivity.class);
                        i.putExtra("Categories","Salt /Sugar/ Jaggery -> Jaggery");
                        i.putExtra("title","Jaggery");
                        startActivity(i); } }


            }
        });
        // so item click is done now check list view
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(Salt.this,Home.class);
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
        Intent i = new Intent(Salt.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(0,0);

    }
}


