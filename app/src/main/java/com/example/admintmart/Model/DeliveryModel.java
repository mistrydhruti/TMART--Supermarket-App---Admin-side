package com.example.admintmart.Model;

public class DeliveryModel {
    private String Name,Phone,Email,Aadhar,DrivingLicense,Photo,Location,Status;

    public DeliveryModel()
    {

    }

    public DeliveryModel(String name, String phone, String email, String aadhar, String drivingLicense, String photo, String location, String status) {
        Name = name;
        Phone = phone;
        Email = email;
        Aadhar = aadhar;
        DrivingLicense = drivingLicense;
        Photo = photo;
        Location = location;
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAadhar() {
        return Aadhar;
    }

    public void setAadhar(String aadhar) {
        Aadhar = aadhar;
    }

    public String getDrivingLicense() {
        return DrivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        DrivingLicense = drivingLicense;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
