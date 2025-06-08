package dev.hekmyr.holidays.api.model;

public class MessageResponseModel extends BaseResponseModel {

    public MessageResponseModel(String message) {
        super(message);
    }

    public MessageResponseModel(String message, ErrorCodes errorCode) {
        super(message, errorCode);
    }
}
