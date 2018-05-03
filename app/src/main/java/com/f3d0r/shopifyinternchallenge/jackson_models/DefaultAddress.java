package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultAddress {

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

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
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

    public void setJsonMemberDefault(boolean jsonMemberDefault) {
        this.jsonMemberDefault = jsonMemberDefault;
    }

    public boolean isJsonMemberDefault() {
        return jsonMemberDefault;
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

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public Object getCompany() {
        return company;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
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