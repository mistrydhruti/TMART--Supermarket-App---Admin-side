package com.example.admintmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Search extends AppCompatActivity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    private String type="";

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        type=getIntent().getExtras().get("type").toString();

        // Listview Data
        final String products[] = {"Pulses and Dals", "Bread and Bakery", "Personal Care", "Snacks and Farsan", "Salt and Sugar and Jaggery",
                "Jams and Spreads", "Masala and Spices",
                "Ghee and Vanaspati", "Chocolates", "Biscuits and Cookies", "Baby and Kids", "Dry Fruits", "Cooking Oil", "Rice Products", "Flours and Grains", "Soups",
                "Breakfast and Cereals", "Home and Kitchen", "Pickles"
        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (products[position]== "Pulses and Dals")
                {
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                        i.putExtra("title","Pulses and Dals");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Pulses.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                        i.putExtra("title","Pulses and Dals");
                        startActivity(i); }

                }
                else if (products[position]== "Bread and Bakery"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                        i.putExtra("title","Breads and Bakery");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Bread.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                        i.putExtra("title","Breads and Bakery");
                        startActivity(i);}
                }
                else if (products[position]== "Personal Care"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,PersonalCare.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, PersonalCare.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,PersonalCare.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,PersonalCare.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }


                }
                else if (products[position]== "Snacks and Farsan"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Snacks.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Snacks.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Snacks.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Snacks.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }

                }
                else if (products[position]== "Salt and Sugar and Jaggery"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Salt.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Salt.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Salt.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Salt.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]== "Jams and Spreads"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Jams.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Jams.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Jams.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Jams.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]==  "Masala and Spices"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Masala.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Masala.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Masala.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Masala.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]== "Ghee and Vanaspati"){

                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                        i.putExtra("title","Ghee and Vanaspati");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Ghee.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                        i.putExtra("title","Ghee and Vanaspati");
                        startActivity(i); }
                }
                else if (products[position]== "Chocolates"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Chocolates -> Chocolates");
                        i.putExtra("title","Chocolates");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Chocolate.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Chocolates -> Chocolates");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Chocolates -> Chocolates");
                        i.putExtra("title","Chocolates");
                        startActivity(i); }
                }
                else if (products[position]== "Biscuits and Cookies"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Biscuits.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Biscuits.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Biscuits.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Biscuits.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]== "Baby and Kids"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                        i.putExtra("title","Baby Stuffs");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, BabyProducts.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                        i.putExtra("title","Baby Stuffs");
                        startActivity(i); }
                }
                else if (products[position]== "Dry Fruits"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                        i.putExtra("title","Dry Fruits");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, DryFruits.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                        i.putExtra("title","Dry Fruits");
                        startActivity(i); }
                }
                else if (products[position]== "Cooking Oil"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Oil.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Oil.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Oil.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Oil.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]== "Rice Products"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Rice Products -> Rice Products");
                        i.putExtra("title","Rice Products");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Rice.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Rice Products -> Rice Products");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Rice Products -> Rice Products");
                        i.putExtra("title","Rice Products");
                        startActivity(i); }
                }
                else if (products[position]== "Flours and Grains"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                        i.putExtra("title","Flours and Grains");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Flour.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                        i.putExtra("title","Flours and Grains");
                        startActivity(i); }
                }
                else if (products[position]== "Soups"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Soups -> Soups");
                        i.putExtra("title","Soups");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Soups.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Soups -> Soups");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Soups -> Soups");
                        i.putExtra("title","Soups");
                        startActivity(i); }
                }
                else if (products[position]== "Breakfast and Cereals"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,Breakfast.class);
                        i.putExtra("type","addproduct");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Breakfast.class);
                        intent1.putExtra("type","updateproduct");
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,Breakfast.class);
                        i.putExtra("type","deleteproduct");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,Breakfast.class);
                        i.putExtra("type","seeallproduct");
                        startActivity(i); }
                }
                else if (products[position]== "Home and Kitchen"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                        i.putExtra("title","Home and Kitchen");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, HomeKitchen.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                        i.putExtra("title","Home and Kitchen");
                        startActivity(i); }
                }
                else if (products[position]== "Pickles"){
                    if(type.equals("addproduct")) {
                        Intent i = new Intent(Search.this,AddProductActivity.class);
                        i.putExtra("Categories","Pickles -> Pickles");
                        i.putExtra("title","Pickles");
                        startActivity(i); }
                    else if(type.equals("updateproduct")) {
                        Intent intent1 = new Intent(Search.this, Pickles.class);
                        startActivity(intent1); }
                    else if(type.equals("deleteproduct")) {
                        Intent i = new Intent(Search.this,DeleteActivity.class);
                        i.putExtra("Categories","Pickles -> Pickles");
                        startActivity(i); }
                    else if(type.equals("seeallproduct")) {
                        Intent i = new Intent(Search.this,SeeAllActivity.class);
                        i.putExtra("Categories","Pickles -> Pickles");
                        i.putExtra("title","Pickles");
                        startActivity(i); }
                }
            }
        });
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Search.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }
}