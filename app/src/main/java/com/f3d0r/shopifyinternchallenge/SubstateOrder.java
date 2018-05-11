package com.f3d0r.shopifyinternchallenge;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class SubstateOrder implements Parcelable {

    public static final Creator<SubstateOrder> CREATOR = new Creator<SubstateOrder>() {
        @Override
        public SubstateOrder createFromParcel(Parcel in) {
            return new SubstateOrder(in);
        }

        @Override
        public SubstateOrder[] newArray(int size) {
            return new SubstateOrder[size];
        }
    };
    private String orderNumber;
    private String totalPrice;
    private String customerName;
    private String numberItems;
    private String shippingLocation;
    private String orderTime;

    SubstateOrder(String orderNumber, String totalPrice, String customerName, String numberItems, String shippingLocation, String orderTime) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.numberItems = numberItems;
        this.shippingLocation = shippingLocation;
        this.orderTime = orderTime;
    }

    private SubstateOrder(Parcel in) {
        orderNumber = in.readString();
    }

    @Override
    public String toString() {
        return "SubstateOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", customerName='" + customerName + '\'' +
                ", numberItems='" + numberItems + '\'' +
                ", shippingLocation='" + shippingLocation + '\'' +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubstateOrder)) return false;
        SubstateOrder that = (SubstateOrder) o;
        return Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(numberItems, that.numberItems) &&
                Objects.equals(shippingLocation, that.shippingLocation) &&
                Objects.equals(orderTime, that.orderTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderNumber, totalPrice, customerName, numberItems, shippingLocation, orderTime);
    }

    public String getOrderNumber() {

        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(String numberItems) {
        this.numberItems = numberItems;
    }

    public String getShippingLocation() {
        return shippingLocation;
    }

    public void setShippingLocation(String shippingLocation) {
        this.shippingLocation = shippingLocation;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderNumber);
    }
}
