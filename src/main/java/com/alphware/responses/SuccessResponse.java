package com.alphware.responses;

public class SuccessResponse {

    private Integer status;
    private String message;
    private Object data;

    public SuccessResponse() {
        super();
    }

    public SuccessResponse(Integer status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "SuccessResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
    }
}
