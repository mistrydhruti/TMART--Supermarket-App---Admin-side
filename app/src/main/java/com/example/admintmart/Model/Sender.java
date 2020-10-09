package com.example.admintmart.Model;

public class Sender {
    public String to;
    public Notification notification;

    public Sender()
    {

    }

    public Sender(String to, Notification notification) {
        this.to = to;
        this.notification = notification;
    }


}
