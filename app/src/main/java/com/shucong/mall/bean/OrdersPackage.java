package com.shucong.mall.bean;

public class OrdersPackage{
    private int id;
    private int orderId;
    private int warehouseId;
    private String express;
    private String expressNo;

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

    public int getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getExpress() {
        return this.express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getExpressNo() {
        return this.expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    @Override
    public String toString() {
        return "OrdersPackage{" +
                " id=" + id +
                ", orderId=" + orderId +
                ", warehouseId=" + warehouseId +
                ", express='" + express + '\'' +
                ", expressNo='" + expressNo + '\'' +
                '}';
    }
}