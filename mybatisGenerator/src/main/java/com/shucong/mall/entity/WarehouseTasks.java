package com.shucong.mall.entity;

public class WarehouseTasks {
    private Integer id;

    private Integer warehouseId;

    private Integer orderId;

    private Integer orderPackageId;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderPackageId() {
        return orderPackageId;
    }

    public void setOrderPackageId(Integer orderPackageId) {
        this.orderPackageId = orderPackageId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}