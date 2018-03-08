package com.shucong.mall.bean;

public class ProductAttributeValues{
    private int id;
    private int productId;
    private int productAttributeId;
    private String value;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductAttributeId() {
        return this.productAttributeId;
    }

    public void setProductAttributeId(int productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductAttributeValues{" +
                " id=" + id +
                ", productId=" + productId +
                ", productAttributeId=" + productAttributeId +
                ", value='" + value + '\'' +
                '}';
    }
}