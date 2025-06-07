package dev.hekmyr.holidays.api.model;

public class DataResponseModel<T> {

    private String message;
    private String code;
    private T data;

    public DataResponseModel(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
