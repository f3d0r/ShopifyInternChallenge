package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class LineItemsItem implements Serializable {

    @JsonProperty("variant_title")
    private String variantTitle;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("fulfillable_quantity")
    private int fulfillableQuantity;

    @JsonProperty("total_discount")
    private String totalDiscount;

    @JsonProperty("fulfillment_status")
    private Object fulfillmentStatus;

    @JsonProperty("fulfillment_service")
    private String fulfillmentService;

    @JsonProperty("taxable")
    private boolean taxable;

    @JsonProperty("gift_card")
    private boolean giftCard;

    @JsonProperty("requires_shipping")
    private boolean requiresShipping;

    @JsonProperty("title")
    private String title;

    @JsonProperty("variant_inventory_management")
    private Object variantInventoryManagement;

    @JsonProperty("product_exists")
    private boolean productExists;

    @JsonProperty("variant_id")
    private long variantId;

    @JsonProperty("tax_lines")
    private List<Object> taxLines;

    @JsonProperty("price")
    private String price;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("grams")
    private int grams;

    @JsonProperty("properties")
    private List<Object> properties;

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFulfillableQuantity(int fulfillableQuantity) {
        this.fulfillableQuantity = fulfillableQuantity;
    }

    public int getFulfillableQuantity() {
        return fulfillableQuantity;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setFulfillmentStatus(Object fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public Object getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentService(String fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    public String getFulfillmentService() {
        return fulfillmentService;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setGiftCard(boolean giftCard) {
        this.giftCard = giftCard;
    }

    public boolean isGiftCard() {
        return giftCard;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setVariantInventoryManagement(Object variantInventoryManagement) {
        this.variantInventoryManagement = variantInventoryManagement;
    }

    public Object getVariantInventoryManagement() {
        return variantInventoryManagement;
    }

    public void setProductExists(boolean productExists) {
        this.productExists = productExists;
    }

    public boolean isProductExists() {
        return productExists;
    }

    public void setVariantId(long variantId) {
        this.variantId = variantId;
    }

    public long getVariantId() {
        return variantId;
    }

    public void setTaxLines(List<Object> taxLines) {
        this.taxLines = taxLines;
    }

    public List<Object> getTaxLines() {
        return taxLines;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    public void setProperties(List<Object> properties) {
        this.properties = properties;
    }

    public List<Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return
                "LineItemsItem{" +
                        "variant_title = '" + variantTitle + '\'' +
                        ",quantity = '" + quantity + '\'' +
                        ",fulfillable_quantity = '" + fulfillableQuantity + '\'' +
                        ",total_discount = '" + totalDiscount + '\'' +
                        ",fulfillment_status = '" + fulfillmentStatus + '\'' +
                        ",fulfillment_service = '" + fulfillmentService + '\'' +
                        ",taxable = '" + taxable + '\'' +
                        ",gift_card = '" + giftCard + '\'' +
                        ",requires_shipping = '" + requiresShipping + '\'' +
                        ",title = '" + title + '\'' +
                        ",variant_inventory_management = '" + variantInventoryManagement + '\'' +
                        ",product_exists = '" + productExists + '\'' +
                        ",variant_id = '" + variantId + '\'' +
                        ",tax_lines = '" + taxLines + '\'' +
                        ",price = '" + price + '\'' +
                        ",vendor = '" + vendor + '\'' +
                        ",product_id = '" + productId + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",sku = '" + sku + '\'' +
                        ",grams = '" + grams + '\'' +
                        ",properties = '" + properties + '\'' +
                        "}";
    }
}