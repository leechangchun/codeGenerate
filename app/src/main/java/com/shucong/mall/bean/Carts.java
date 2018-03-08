package com.shucong.mall.bean;

public class Carts{
    private int id;
    private int userId;
    private int skuId;
    private int productId;
    private String productName;
    private String productAttribute;
    private String thumb;
    private double price;
    private int quantity;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkuId() {
        return this.skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAttribute() {
        return this.productAttribute;
    }

    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Carts{" +
                " id=" + id +
                ", userId=" + userId +
                ", skuId=" + skuId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productAttribute='" + productAttribute + '\'' +
                ", thumb='" + thumb + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}