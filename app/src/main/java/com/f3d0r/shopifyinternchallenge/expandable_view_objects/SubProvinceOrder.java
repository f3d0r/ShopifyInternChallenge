package com.f3d0r.shopifyinternchallenge.expandable_view_objects;

/*
  Order object containing information for specific order to be used only with expanded RecyclerView adapter
  to show order information under specific province view.

  @author Fedor Paretsky
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class SubProvinceOrder implements Parcelable {

    public static final Creator<SubProvinceOrder> CREATOR = new Creator<SubProvinceOrder>() {
        @Override
        public SubProvinceOrder createFromParcel(Parcel in) {
            return new SubProvinceOrder(in);
        }

        @Override
        public SubProvinceOrder[] newArray(int size) {
            return new SubProvinceOrder[size];
        }
    };
    private String orderNumber;
    private String totalPrice;
    private String customerName;
    private String numberItems;
    private String shippingLocation;
    private String orderTime;

    public SubProvinceOrder(String orderNumber, String totalPrice, String customerName, String numberItems, String shippingLocation, String orderTime) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.numberItems = numberItems;
        this.shippingLocation = shippingLocation;
        this.orderTime = orderTime;
    }

    private SubProvinceOrder(Parcel in) {
        orderNumber = in.readString();
    }

    @Override
    public String toString() {
        return "SubProvinceOrder{" +
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
        if (!(o instanceof SubProvinceOrder)) return false;
        SubProvinceOrder that = (SubProvinceOrder) o;
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getNumberItems() {
        return numberItems;
    }

    public String getShippingLocation() {
        return shippingLocation;
    }

    public String getOrderTime() {
        return orderTime;
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
