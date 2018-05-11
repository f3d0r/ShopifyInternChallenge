package com.f3d0r.shopifyinternchallenge.jackson_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    @JsonProperty("cancelled_at")
    private Object cancelledAt;

    @JsonProperty("fulfillment_status")
    private Object fulfillmentStatus;

    @JsonProperty("total_price_usd")
    private String totalPriceUsd;

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    @JsonProperty("line_items")
    private List<LineItemsItem> lineItems;

    @JsonProperty("location_id")
    private Object locationId;

    @JsonProperty("source_url")
    private Object sourceUrl;

    @JsonProperty("landing_site")
    private Object landingSite;

    @JsonProperty("source_identifier")
    private Object sourceIdentifier;

    @JsonProperty("reference")
    private Object reference;

    @JsonProperty("number")
    private int number;

    @JsonProperty("checkout_id")
    private Object checkoutId;

    @JsonProperty("checkout_token")
    private Object checkoutToken;

    @JsonProperty("tax_lines")
    private List<Object> taxLines;

    @JsonProperty("customer_locale")
    private Object customerLocale;

    @JsonProperty("id")
    private long id;

    @JsonProperty("app_id")
    private int appId;

    @JsonProperty("subtotal_price")
    private String subtotalPrice;

    @JsonProperty("closed_at")
    private Object closedAt;

    @JsonProperty("order_status_url")
    private String orderStatusUrl;

    @JsonProperty("test")
    private boolean test;

    @JsonProperty("device_id")
    private Object deviceId;

    @JsonProperty("payment_gateway_names")
    private List<String> paymentGatewayNames;

    @JsonProperty("total_tax")
    private String totalTax;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("processing_method")
    private String processingMethod;

    @JsonProperty("shipping_lines")
    private List<Object> shippingLines;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("phone")
    private Object phone;

    @JsonProperty("note_attributes")
    private List<Object> noteAttributes;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cart_token")
    private Object cartToken;

    @JsonProperty("landing_site_ref")
    private Object landingSiteRef;

    @JsonProperty("discount_codes")
    private List<Object> discountCodes;

    @JsonProperty("note")
    private Object note;

    @JsonProperty("order_number")
    private int orderNumber;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("taxes_included")
    private boolean taxesIncluded;

    @JsonProperty("buyer_accepts_marketing")
    private boolean buyerAcceptsMarketing;

    @JsonProperty("confirmed")
    private boolean confirmed;

    @JsonProperty("total_weight")
    private int totalWeight;

    @JsonProperty("contact_email")
    private String contactEmail;

    @JsonProperty("refunds")
    private List<Object> refunds;

    @JsonProperty("total_discounts")
    private String totalDiscounts;

    @JsonProperty("fulfillments")
    private List<Object> fulfillments;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("referring_site")
    private Object referringSite;

    @JsonProperty("processed_at")
    private String processedAt;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    @JsonProperty("email")
    private String email;

    @JsonProperty("browser_ip")
    private Object browserIp;

    @JsonProperty("source_name")
    private String sourceName;

    @JsonProperty("total_price")
    private String totalPrice;

    @JsonProperty("total_line_items_price")
    private String totalLineItemsPrice;

    @JsonProperty("token")
    private String token;

    @JsonProperty("cancel_reason")
    private Object cancelReason;

    @JsonProperty("financial_status")
    private String financialStatus;

    @JsonProperty("admin_graphql_api_id")
    private String adminGraphqlApiId;

    @JsonProperty("gateway")
    private String gateway;

    @JsonProperty("customer")
    private Customer customer;

    public void setCancelledAt(Object cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Object getCancelledAt() {
        return cancelledAt;
    }

    public void setFulfillmentStatus(Object fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public Object getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setTotalPriceUsd(String totalPriceUsd) {
        this.totalPriceUsd = totalPriceUsd;
    }

    public String getTotalPriceUsd() {
        return totalPriceUsd;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setLineItems(List<LineItemsItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItemsItem> getLineItems() {
        return lineItems;
    }

    public void setLocationId(Object locationId) {
        this.locationId = locationId;
    }

    public Object getLocationId() {
        return locationId;
    }

    public void setSourceUrl(Object sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Object getSourceUrl() {
        return sourceUrl;
    }

    public void setLandingSite(Object landingSite) {
        this.landingSite = landingSite;
    }

    public Object getLandingSite() {
        return landingSite;
    }

    public void setSourceIdentifier(Object sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public Object getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }

    public Object getReference() {
        return reference;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setCheckoutId(Object checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Object getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutToken(Object checkoutToken) {
        this.checkoutToken = checkoutToken;
    }

    public Object getCheckoutToken() {
        return checkoutToken;
    }

    public void setTaxLines(List<Object> taxLines) {
        this.taxLines = taxLines;
    }

    public List<Object> getTaxLines() {
        return taxLines;
    }

    public void setCustomerLocale(Object customerLocale) {
        this.customerLocale = customerLocale;
    }

    public Object getCustomerLocale() {
        return customerLocale;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getAppId() {
        return appId;
    }

    public void setSubtotalPrice(String subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public String getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setClosedAt(Object closedAt) {
        this.closedAt = closedAt;
    }

    public Object getClosedAt() {
        return closedAt;
    }

    public void setOrderStatusUrl(String orderStatusUrl) {
        this.orderStatusUrl = orderStatusUrl;
    }

    public String getOrderStatusUrl() {
        return orderStatusUrl;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean isTest() {
        return test;
    }

    public void setDeviceId(Object deviceId) {
        this.deviceId = deviceId;
    }

    public Object getDeviceId() {
        return deviceId;
    }

    public void setPaymentGatewayNames(List<String> paymentGatewayNames) {
        this.paymentGatewayNames = paymentGatewayNames;
    }

    public List<String> getPaymentGatewayNames() {
        return paymentGatewayNames;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }

    public String getProcessingMethod() {
        return processingMethod;
    }

    public void setShippingLines(List<Object> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public List<Object> getShippingLines() {
        return shippingLines;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getPhone() {
        return phone;
    }

    public void setNoteAttributes(List<Object> noteAttributes) {
        this.noteAttributes = noteAttributes;
    }

    public List<Object> getNoteAttributes() {
        return noteAttributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCartToken(Object cartToken) {
        this.cartToken = cartToken;
    }

    public Object getCartToken() {
        return cartToken;
    }

    public void setLandingSiteRef(Object landingSiteRef) {
        this.landingSiteRef = landingSiteRef;
    }

    public Object getLandingSiteRef() {
        return landingSiteRef;
    }

    public void setDiscountCodes(List<Object> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public List<Object> getDiscountCodes() {
        return discountCodes;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Object getNote() {
        return note;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTaxesIncluded(boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    public boolean isTaxesIncluded() {
        return taxesIncluded;
    }

    public void setBuyerAcceptsMarketing(boolean buyerAcceptsMarketing) {
        this.buyerAcceptsMarketing = buyerAcceptsMarketing;
    }

    public boolean isBuyerAcceptsMarketing() {
        return buyerAcceptsMarketing;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setRefunds(List<Object> refunds) {
        this.refunds = refunds;
    }

    public List<Object> getRefunds() {
        return refunds;
    }

    public void setTotalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public String getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setFulfillments(List<Object> fulfillments) {
        this.fulfillments = fulfillments;
    }

    public List<Object> getFulfillments() {
        return fulfillments;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setReferringSite(Object referringSite) {
        this.referringSite = referringSite;
    }

    public Object getReferringSite() {
        return referringSite;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setBrowserIp(Object browserIp) {
        this.browserIp = browserIp;
    }

    public Object getBrowserIp() {
        return browserIp;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalLineItemsPrice(String totalLineItemsPrice) {
        this.totalLineItemsPrice = totalLineItemsPrice;
    }

    public String getTotalLineItemsPrice() {
        return totalLineItemsPrice;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setCancelReason(Object cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Object getCancelReason() {
        return cancelReason;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public String getAdminGraphqlApiId() {
        return adminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        this.adminGraphqlApiId = adminGraphqlApiId;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getGateway() {
        return gateway;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return
                "Order{" +
                        "cancelled_at = '" + cancelledAt + '\'' +
                        ",fulfillment_status = '" + fulfillmentStatus + '\'' +
                        ",total_price_usd = '" + totalPriceUsd + '\'' +
                        ",billing_address = '" + billingAddress + '\'' +
                        ",line_items = '" + lineItems + '\'' +
                        ",location_id = '" + locationId + '\'' +
                        ",source_url = '" + sourceUrl + '\'' +
                        ",landing_site = '" + landingSite + '\'' +
                        ",source_identifier = '" + sourceIdentifier + '\'' +
                        ",reference = '" + reference + '\'' +
                        ",number = '" + number + '\'' +
                        ",checkout_id = '" + checkoutId + '\'' +
                        ",checkout_token = '" + checkoutToken + '\'' +
                        ",tax_lines = '" + taxLines + '\'' +
                        ",customer_locale = '" + customerLocale + '\'' +
                        ",id = '" + id + '\'' +
                        ",app_id = '" + appId + '\'' +
                        ",subtotal_price = '" + subtotalPrice + '\'' +
                        ",closed_at = '" + closedAt + '\'' +
                        ",order_status_url = '" + orderStatusUrl + '\'' +
                        ",test = '" + test + '\'' +
                        ",device_id = '" + deviceId + '\'' +
                        ",payment_gateway_names = '" + paymentGatewayNames + '\'' +
                        ",total_tax = '" + totalTax + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",processing_method = '" + processingMethod + '\'' +
                        ",shipping_lines = '" + shippingLines + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",note_attributes = '" + noteAttributes + '\'' +
                        ",name = '" + name + '\'' +
                        ",cart_token = '" + cartToken + '\'' +
                        ",landing_site_ref = '" + landingSiteRef + '\'' +
                        ",discount_codes = '" + discountCodes + '\'' +
                        ",note = '" + note + '\'' +
                        ",order_number = '" + orderNumber + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",taxes_included = '" + taxesIncluded + '\'' +
                        ",buyer_accepts_marketing = '" + buyerAcceptsMarketing + '\'' +
                        ",confirmed = '" + confirmed + '\'' +
                        ",total_weight = '" + totalWeight + '\'' +
                        ",contact_email = '" + contactEmail + '\'' +
                        ",refunds = '" + refunds + '\'' +
                        ",total_discounts = '" + totalDiscounts + '\'' +
                        ",fulfillments = '" + fulfillments + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",referring_site = '" + referringSite + '\'' +
                        ",processed_at = '" + processedAt + '\'' +
                        ",currency = '" + currency + '\'' +
                        ",shipping_address = '" + shippingAddress + '\'' +
                        ",email = '" + email + '\'' +
                        ",browser_ip = '" + browserIp + '\'' +
                        ",source_name = '" + sourceName + '\'' +
                        ",total_price = '" + totalPrice + '\'' +
                        ",total_line_items_price = '" + totalLineItemsPrice + '\'' +
                        ",token = '" + token + '\'' +
                        ",cancel_reason = '" + cancelReason + '\'' +
                        ",financial_status = '" + financialStatus + '\'' +
                        ",admin_graphql_api_id = '" + adminGraphqlApiId + '\'' +
                        ",gateway = '" + gateway + '\'' +
                        ",customer = '" + customer + '\'' +
                        "}";
    }
}