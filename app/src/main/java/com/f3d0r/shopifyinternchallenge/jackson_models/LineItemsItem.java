package com.f3d0r.shopifyinternchallenge.jackson_models;

/*
  Generated JSON conversion/de-serialization object for use with Retrofit.

  @author Fedor Paretsky
 */

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

    @JsonProperty("admin_graphql_api_id")
    private String adminGraphqlApiId;

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

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFulfillableQuantity() {
        return fulfillableQuantity;
    }

    public void setFulfillableQuantity(int fulfillableQuantity) {
        this.fulfillableQuantity = fulfillableQuantity;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Object getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(Object fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getFulfillmentService() {
        return fulfillmentService;
    }

    public void setFulfillmentService(String fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public boolean isGiftCard() {
        return giftCard;
    }

    public void setGiftCard(boolean giftCard) {
        this.giftCard = giftCard;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getVariantInventoryManagement() {
        return variantInventoryManagement;
    }

    public void setVariantInventoryManagement(Object variantInventoryManagement) {
        this.variantInventoryManagement = variantInventoryManagement;
    }

    public boolean isProductExists() {
        return productExists;
    }

    public void setProductExists(boolean productExists) {
        this.productExists = productExists;
    }

    public long getVariantId() {
        return variantId;
    }

    public void setVariantId(long variantId) {
        this.variantId = variantId;
    }

    public List<Object> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<Object> taxLines) {
        this.taxLines = taxLines;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getAdminGraphqlApiId() {
        return adminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        this.adminGraphqlApiId = adminGraphqlApiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public List<Object> getProperties() {
        return properties;
    }

    public void setProperties(List<Object> properties) {
        this.properties = properties;
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
                        ",admin_graphql_api_id = '" + adminGraphqlApiId + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",sku = '" + sku + '\'' +
                        ",grams = '" + grams + '\'' +
                        ",properties = '" + properties + '\'' +
                        "}";
    }
}