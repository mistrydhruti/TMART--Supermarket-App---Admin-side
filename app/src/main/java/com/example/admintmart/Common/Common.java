package com.example.admintmart.Common;

import com.example.admintmart.Remote.APIService;
import com.example.admintmart.Remote.RetrofitClient;

public class Common {

    private static final String BASE_URL="https://fcm.googleapis.com/";

    public static final String UserIdKey="UserId";
    public static final String UserPasswordKey="UserPassword";


    public static APIService getFCMService()
    {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
