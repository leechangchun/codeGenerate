package com.shucong.mall.bean;

public class OrdersPackageDetail{
    private int id;
    private int orderId;
    private int packageId;
    private String productName;
    private String productThumb;
    private int productSkuId;
    private String productAttribute;
    private int quantity;
    private double price;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumb() {
        return this.productThumb;
    }

    public void setProductThumb(String productThumb) {
        this.productThumb = productThumb;
    }

    public int getProductSkuId() {
        return this.productSkuId;
    }

    public void setProductSkuId(int productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductAttribute() {
        return this.productAttribute;
    }

    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrdersPackageDetail{" +
                " id=" + id +
                ", orderId=" + orderId +
                ", packageId=" + packageId +
                ", productName='" + productName + '\'' +
                ", productThumb='" + productThumb + '\'' +
                ", productSkuId=" + productSkuId +
                ", productAttribute='" + productAttribute + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}