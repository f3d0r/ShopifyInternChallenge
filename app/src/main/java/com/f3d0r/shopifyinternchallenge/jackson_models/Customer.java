package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Customer implements Serializable {

    @JsonProperty("total_spent")
    private String totalSpent;

    @JsonProperty("note")
    private Object note;

    @JsonProperty("last_order_name")
    private String lastOrderName;

    @JsonProperty("last_order_id")
    private long lastOrderId;

    @JsonProperty("tax_exempt")
    private boolean taxExempt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("multipass_identifier")
    private Object multipassIdentifier;

    @JsonProperty("verified_email")
    private boolean verifiedEmail;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("orders_count")
    private int ordersCount;

    @JsonProperty("default_address")
    private DefaultAddress defaultAddress;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("accepts_marketing")
    private boolean acceptsMarketing;

    @JsonProperty("phone")
    private Object phone;

    @JsonProperty("admin_graphql_api_id")
    private String adminGraphqlApiId;

    @JsonProperty("id")
    private long id;

    @JsonProperty("state")
    private String state;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("email")
    private String email;

    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getTotalSpent() {
        return totalSpent;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Object getNote() {
        return note;
    }

    public void setLastOrderName(String lastOrderName) {
        this.lastOrderName = lastOrderName;
    }

    public String getLastOrderName() {
        return lastOrderName;
    }

    public void setLastOrderId(long lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public long getLastOrderId() {
        return lastOrderId;
    }

    public void setTaxExempt(boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMultipassIdentifier(Object multipassIdentifier) {
        this.multipassIdentifier = multipassIdentifier;
    }

    public Object getMultipassIdentifier() {
        return multipassIdentifier;
    }

    public void setVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setDefaultAddress(DefaultAddress defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public DefaultAddress getDefaultAddress() {
        return defaultAddress;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setAcceptsMarketing(boolean acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
    }

    public boolean isAcceptsMarketing() {
        return acceptsMarketing;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getPhone() {
        return phone;
    }

    public String getAdminGraphqlApiId() {
        return adminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        this.adminGraphqlApiId = adminGraphqlApiId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "Customer{" +
                        "total_spent = '" + totalSpent + '\'' +
                        ",note = '" + note + '\'' +
                        ",last_order_name = '" + lastOrderName + '\'' +
                        ",last_order_id = '" + lastOrderId + '\'' +
                        ",tax_exempt = '" + taxExempt + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",multipass_identifier = '" + multipassIdentifier + '\'' +
                        ",verified_email = '" + verifiedEmail + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",orders_count = '" + ordersCount + '\'' +
                        ",default_address = '" + defaultAddress + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",accepts_marketing = '" + acceptsMarketing + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",admin_graphql_api_id = '" + adminGraphqlApiId + '\'' +
                        ",id = '" + id + '\'' +
                        ",state = '" + state + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}