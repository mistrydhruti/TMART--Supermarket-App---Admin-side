package com.example.admintmart.Model;

public class OrderHistoryModel {

    private String DeliveredDate,OrderId,ShipperName,ShipperPhoneNo,CustomerEmail;

    public OrderHistoryModel()
    {

    }

    public OrderHistoryModel(String deliveredDate, String orderId, String shipperName, String shipperPhoneNo, String customerEmail) {
        DeliveredDate = deliveredDate;
        OrderId = orderId;
        ShipperName = shipperName;
        ShipperPhoneNo = shipperPhoneNo;
        CustomerEmail = customerEmail;
    }

    public String getDeliveredDate() {
        return DeliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        DeliveredDate = deliveredDate;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public String getShipperPhoneNo() {
        return ShipperPhoneNo;
    }

    public void setShipperPhoneNo(String shipperPhoneNo) {
        ShipperPhoneNo = shipperPhoneNo;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }
}
