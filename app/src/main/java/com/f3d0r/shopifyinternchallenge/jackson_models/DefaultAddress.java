package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DefaultAddress implements Serializable {

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("address2")
    private Object address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("province_code")
    private String provinceCode;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("default")
    private boolean jsonMemberDefault;

    @JsonProperty("province")
    private String province;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("company")
    private Object company;

    @JsonProperty("id")
    private long id;

    @JsonProperty("customer_id")
    private long customerId;

    @JsonProperty("first_name")
    private String firstName;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isJsonMemberDefault() {
        return jsonMemberDefault;
    }

    public void setJsonMemberDefault(boolean jsonMemberDefault) {
        this.jsonMemberDefault = jsonMemberDefault;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return
                "DefaultAddress{" +
                        "zip = '" + zip + '\'' +
                        ",country = '" + country + '\'' +
                        ",address2 = '" + address2 + '\'' +
                        ",city = '" + city + '\'' +
                        ",address1 = '" + address1 + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",province_code = '" + provinceCode + '\'' +
                        ",country_code = '" + countryCode + '\'' +
                        ",default = '" + jsonMemberDefault + '\'' +
                        ",province = '" + province + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",name = '" + name + '\'' +
                        ",country_name = '" + countryName + '\'' +
                        ",company = '" + company + '\'' +
                        ",id = '" + id + '\'' +
                        ",customer_id = '" + customerId + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        "}";
    }
}