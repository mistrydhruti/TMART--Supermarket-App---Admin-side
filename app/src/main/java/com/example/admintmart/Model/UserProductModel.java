package com.example.admintmart.Model;

public class UserProductModel {
    private String Pname,amount,category,date,image,mrp,price,time,quantity;

    public UserProductModel()
    {

    }

    public UserProductModel(String pname, String amount, String category, String date, String image, String mrp, String price, String time, String quantity) {
        Pname = pname;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.image = image;
        this.mrp = mrp;
        this.price = price;
        this.time = time;
        this.quantity = quantity;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
