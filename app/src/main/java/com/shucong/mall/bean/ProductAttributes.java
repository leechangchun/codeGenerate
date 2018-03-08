package com.shucong.mall.bean;

public class ProductAttributes{
    private int id;
    private int productId;
    private int parentId;
    private String name;

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

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductAttributes{" +
                " id=" + id +
                ", productId=" + productId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }
}