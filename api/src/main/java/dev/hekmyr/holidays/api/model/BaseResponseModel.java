package dev.hekmyr.holidays.api.model;

abstract class BaseResponseModel {

    private String message;
    private String error;

    public BaseResponseModel() {}

    public BaseResponseModel(String message) {
        setMessage(message);
    }

    public BaseResponseModel(String message, ErrorCodes errorCode) {
        setMessage(message);
        if (errorCode != null) this.error = errorCode.toString();
        else this.error = ErrorCodes.UNKNOWN.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
