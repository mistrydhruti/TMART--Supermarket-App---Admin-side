package com.example.admintmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admintmart.Model.Token;
import com.example.admintmart.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        updateToken(FirebaseInstanceId.getInstance().getToken());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    private void updateToken(String token1) {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference tokens=db.getReference("Token");

        Token token = new Token(token1,true);
        tokens.child("admin").setValue(token);

    }

    public void add_product_admin(View view) {
        Intent i = new Intent(Home.this,ShopByCategories.class);
        i.putExtra("type","addproduct");
        startActivity(i);
    }

    public void update_product_admin(View view) {
        Intent i = new Intent(Home.this,ShopByCategories.class);
        i.putExtra("type","updateproduct");
        startActivity(i);
    }

    public void delete_products_admin(View view) {
        Intent i = new Intent(Home.this,ShopByCategories.class);
        i.putExtra("type","deleteproduct");
        startActivity(i);
    }

    public void bestselling_admin(View view) {
        Intent i = new Intent(Home.this,ShopByCategories.class);
        i.putExtra("type","seeallproduct");
        startActivity(i);
    }

    public void daily_news(View view) {
        Intent i = new Intent(Home.this,DailyNews.class);
        startActivity(i);
        finish();

    }

    public void new_orders_admin(View view) {
        Intent i = new Intent(Home.this,AdminNewOrdersActivity.class);
        startActivity(i);
    }

    public void order_history(View view) {
        Intent i = new Intent(Home.this,OrderHistory.class);
        startActivity(i);
        finish();
    }

    public void approve_delboy_admin(View view) {
        Intent i = new Intent(Home.this,ApproveDeliveryPerson.class);
        startActivity(i);
    }

    public void delboy_admin(View view) {
        Intent i = new Intent(Home.this,DeliveryBoyDetails.class);
        startActivity(i);
    }


}
