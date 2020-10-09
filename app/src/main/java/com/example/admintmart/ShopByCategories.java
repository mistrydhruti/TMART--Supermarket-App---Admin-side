package com.example.admintmart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Slide;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ShopByCategories extends AppCompatActivity implements View.OnClickListener {


    SearchView searchView;
    private String type="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type=getIntent().getExtras().get("type").toString();

        setContentView(R.layout.activity_shop_by_categories);

        View card1 = findViewById(R.id.pulses);
        View card2 = findViewById(R.id.bread);
        View card3 = findViewById(R.id.personal_care);
        View card4 = findViewById(R.id.snacks);
        View card5 = findViewById(R.id.salt);
        View card6 = findViewById(R.id.jams);
        View card7 = findViewById(R.id.masala);
        View card8 = findViewById(R.id.ghee);
        View card9 = findViewById(R.id.chocolate);
        View card10 = findViewById(R.id.biscuits);
        View card11 = findViewById(R.id.baby_products);
        View card12 = findViewById(R.id.dry_fruits);
        View card13 = findViewById(R.id.oil);
        View card14 = findViewById(R.id.rice);
        View card15 = findViewById(R.id.flour);
        View card16 = findViewById(R.id.soups);
        View card17 = findViewById(R.id.breakfast);
        View card18 = findViewById(R.id.home_kitchen);
        View card19 = findViewById(R.id.pickles);

        card1.setOnClickListener((View.OnClickListener) this);
        card2.setOnClickListener((View.OnClickListener) this);
        card3.setOnClickListener((View.OnClickListener) this);
        card4.setOnClickListener((View.OnClickListener) this);
        card5.setOnClickListener((View.OnClickListener) this);
        card6.setOnClickListener((View.OnClickListener) this);
        card7.setOnClickListener((View.OnClickListener) this);
        card8.setOnClickListener((View.OnClickListener) this);
        card9.setOnClickListener((View.OnClickListener) this);
        card10.setOnClickListener((View.OnClickListener) this);
        card11.setOnClickListener((View.OnClickListener) this);
        card12.setOnClickListener((View.OnClickListener) this);
        card13.setOnClickListener((View.OnClickListener) this);
        card14.setOnClickListener((View.OnClickListener) this);
        card15.setOnClickListener((View.OnClickListener) this);
        card16.setOnClickListener((View.OnClickListener) this);
        card17.setOnClickListener((View.OnClickListener) this);
        card18.setOnClickListener((View.OnClickListener) this);
        card19.setOnClickListener((View.OnClickListener) this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pulses:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                    i.putExtra("title","Pulses and Dals");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Pulses.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Pulses and Dals -> Pulses and Dals");
                    i.putExtra("title","Pulses and Dals");
                    startActivity(i); }
                break;

            case R.id.bread:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                    i.putExtra("title","Breads and Bakery");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Bread.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Breads and Bakery -> Breads and Bakery");
                    i.putExtra("title","Breads and Bakery");
                    startActivity(i); }
                break;

            case R.id.personal_care:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,PersonalCare.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, PersonalCare.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,PersonalCare.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,PersonalCare.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.snacks:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Snacks.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Snacks.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Snacks.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Snacks.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.salt:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Salt.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Salt.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Salt.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Salt.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.jams:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Jams.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Jams.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Jams.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Jams.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.masala:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Masala.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Masala.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Masala.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Masala.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.ghee:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                    i.putExtra("title","Ghee and Vanaspati");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Ghee.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Ghee and Vanaspati -> Ghee and Vanaspati");
                    i.putExtra("title","Ghee and Vanaspati");
                    startActivity(i); }
                break;

            case R.id.chocolate:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Chocolates -> Chocolates");
                    i.putExtra("title","Chocolates");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Chocolate.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Chocolates -> Chocolates");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Chocolates -> Chocolates");
                    i.putExtra("title","Chocolates");
                    startActivity(i); }
                break;

            case R.id.baby_products:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                    i.putExtra("title","Baby Stuffs");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, BabyProducts.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Baby Stuffs -> Baby Stuffs");
                    i.putExtra("title","Baby Stuffs");
                    startActivity(i); }
                break;

            case R.id.biscuits:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Biscuits.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Biscuits.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Biscuits.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Biscuits.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.dry_fruits:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                    i.putExtra("title","Dry Fruits");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, DryFruits.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Dry Fruits -> Dry Fruits");
                    i.putExtra("title","Dry Fruits");
                    startActivity(i); }
                break;

            case R.id.oil:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Oil.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Oil.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Oil.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Oil.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;


            case R.id.rice:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Rice Products -> Rice Products");
                    i.putExtra("title","Rice Products");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Rice.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Rice Products -> Rice Products");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Rice Products -> Rice Products");
                    i.putExtra("title","Rice Products");
                    startActivity(i); }
                break;


            case R.id.flour:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                    i.putExtra("title","Flours and Grains");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Flour.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Flours and Grains -> Flours and Grains");
                    i.putExtra("title","Flours and Grains");
                    startActivity(i); }
                break;


            case R.id.soups:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Soups -> Soups");
                    i.putExtra("title","Soups");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Soups.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Soups -> Soups");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Soups -> Soups");
                    i.putExtra("title","Soups");
                    startActivity(i); }
                break;

            case R.id.breakfast:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Breakfast.class);
                    i.putExtra("type","addproduct");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Breakfast.class);
                    intent1.putExtra("type","updateproduct");
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Breakfast.class);
                    i.putExtra("type","deleteproduct");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,Breakfast.class);
                    i.putExtra("type","seeallproduct");
                    startActivity(i); }
                break;

            case R.id.home_kitchen:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                    i.putExtra("title","Home and Kitchen");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, HomeKitchen.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Home and Kitchen -> Home and Kitchen");
                    i.putExtra("title","Home and Kitchen");
                    startActivity(i); }
                break;

            case R.id.pickles:
                if(type.equals("addproduct")) {
                    Intent i = new Intent(ShopByCategories.this,AddProductActivity.class);
                    i.putExtra("Categories","Pickles -> Pickles");
                    i.putExtra("title","Pickles");
                    startActivity(i); }
                else if(type.equals("updateproduct")) {
                    Intent intent1 = new Intent(ShopByCategories.this, Pickles.class);
                    startActivity(intent1); }
                else if(type.equals("deleteproduct")) {
                    Intent i = new Intent(ShopByCategories.this,DeleteActivity.class);
                    i.putExtra("Categories","Pickles -> Pickles");
                    startActivity(i); }
                else if(type.equals("seeallproduct")) {
                    Intent i = new Intent(ShopByCategories.this,SeeAllActivity.class);
                    i.putExtra("Categories","Pickles -> Pickles");
                    i.putExtra("title","Pickles");
                    startActivity(i); }
                break;


        }
    }

    public void Go_to_home(View view) {
        Intent i = new Intent(ShopByCategories.this,Home.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }


    public void search(View view) {


        if(type.equals("addproduct")) {
            Intent i = new Intent(ShopByCategories.this,Search.class);
            i.putExtra("type","addproduct");
            startActivity(i);
        }
        else if(type.equals("updateproduct")) {
            Intent i = new Intent(ShopByCategories.this,Search.class);
            i.putExtra("type","updateproduct");
            startActivity(i);
        }
        else if(type.equals("deleteproduct")) {
            Intent i = new Intent(ShopByCategories.this,Search.class);
            i.putExtra("type","deleteproduct");
            startActivity(i);
            }
        else if(type.equals("seeallproduct")) {
            Intent i = new Intent(ShopByCategories.this,Search.class);
            i.putExtra("type","seeallproduct");
            startActivity(i);
             }


    }
}
