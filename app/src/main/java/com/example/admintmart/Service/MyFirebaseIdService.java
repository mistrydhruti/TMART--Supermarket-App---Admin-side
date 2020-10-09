package com.example.admintmart.Service;

import com.example.admintmart.Model.Token;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String tokenRefreshed1= FirebaseInstanceId.getInstance().getToken();
        updateToServer(tokenRefreshed1);

    }

    private void updateToServer(String tokenRefreshed) {

        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference tokens=db.getReference("Token");

        Token token = new Token(tokenRefreshed,true);
        tokens.child("admin").setValue(token);
    }
}
