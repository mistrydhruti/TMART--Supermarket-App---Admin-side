package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admintmart.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class AdminLogin extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView info;
    private CheckBox remme;
    private int counter = 5;
    private String u, p, Id, pass;


    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        remme = findViewById(R.id.remme);
        Paper.init(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        info = (TextView) findViewById(R.id.info);

        loadingbar = new ProgressDialog(this);


        String userIdKey = Paper.book().read(Common.UserIdKey);
        String userPasswordKey = Paper.book().read(Common.UserPasswordKey);

        if (userIdKey != null && userPasswordKey != null) {
            if (!TextUtils.isEmpty(userIdKey) && !TextUtils.isEmpty(userPasswordKey)) {
                docheck(userIdKey, userPasswordKey);
                loadingbar.setTitle("Logging in");
                loadingbar.setMessage("Please wait unitil we check your credentials.");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
            }
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = username.getText().toString();
                p = password.getText().toString();
                ;
                if ((TextUtils.isEmpty(u)) || (TextUtils.isEmpty(p))) {
                    username.setError("This field is required");
                    username.requestFocus();
                    password.setError("This field is required");
                    password.requestFocus();
                } else {
                    check(u, p);
                    loadingbar.setTitle("Logging in");
                    loadingbar.setMessage("Please wait unitil we check your credentials.");
                    loadingbar.setCanceledOnTouchOutside(false);
                    loadingbar.show();
                }
            }
        });


    }

    private void docheck(final String userIdKey, final String userPasswordKey) {

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Admin Login");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Id = dataSnapshot.child("ID").getValue().toString();
                pass = dataSnapshot.child("Password").getValue().toString();


                dorecheck(userIdKey, userPasswordKey);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void dorecheck(String userIdKey, String userPasswordKey) {
        if (userIdKey.equals(Id) && userPasswordKey.equals(pass)) {
            loadingbar.dismiss();
            Intent i = new Intent(AdminLogin.this, Home.class);
            startActivity(i);
            finish();
        }
    }

    private void check(String u, String p) {

        if (remme.isChecked()) {
            Paper.book().write(Common.UserIdKey, u);
            Paper.book().write(Common.UserPasswordKey, p);
        }


        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Admin Login");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String Id = dataSnapshot.child("ID").getValue().toString();
                String pass = dataSnapshot.child("Password").getValue().toString();


                recheck(Id, pass);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void recheck(String id, String pass) {

        if (id.equals(u) && pass.equals(p)) {
            loadingbar.dismiss();
            Intent i = new Intent(AdminLogin.this, Home.class);
            startActivity(i);
            finish();
        } else {
            counter--;
            info.setText("No.of attempts remaining:" + String.valueOf(counter));
            if (counter == 0) {
                Toast.makeText(AdminLogin.this, "Sorry, You cant access this !", Toast.LENGTH_SHORT).show();
            }

        }

    }
}

