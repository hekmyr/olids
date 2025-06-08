package dev.hekmyr.holidays.api.model;

public class DataResponseModel<T> extends BaseResponseModel {

    private T data;

    public DataResponseModel() {}

    public DataResponseModel(String message, ErrorCodes errorCode) {
        super(message, errorCode);
    }

    public DataResponseModel(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
