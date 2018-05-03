package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingAddress {

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address2")
    private Object address2;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("province_code")
    private String provinceCode;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("province")
    private String province;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("company")
    private Object company;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("longitude")
    private double longitude;

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public Object getCompany() {
        return company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return
                "ShippingAddress{" +
                        "zip = '" + zip + '\'' +
                        ",country = '" + country + '\'' +
                        ",city = '" + city + '\'' +
                        ",address2 = '" + address2 + '\'' +
                        ",address1 = '" + address1 + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",province_code = '" + provinceCode + '\'' +
                        ",country_code = '" + countryCode + '\'' +
                        ",province = '" + province + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",name = '" + name + '\'' +
                        ",company = '" + company + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}