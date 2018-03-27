package com.shucong.mall.utils;

public class DataResponse {
    
    private int error;
    private String message;
    private Object data;

    public DataResponse(int error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public DataResponse(int error, String message) {
        this.error = error;
        this.message = message;
        this.data = null;
    }

    public DataResponse(Object data) {
        this.error = 0;
        this.message = "成功";
        this.data = data;
    }

    public DataResponse(Exception ex) {
        this.error = 1000;
        this.message = ex.getMessage();
        this.data = null;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
