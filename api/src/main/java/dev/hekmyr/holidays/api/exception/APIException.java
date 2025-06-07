package dev.hekmyr.holidays.api.exception;

import dev.hekmyr.holidays.api.model.ErrorCodes;

abstract class APIException extends Exception {

    private ErrorCodes code;

	public APIException(ErrorCodes code) {
        this.code = code;
    }

    public APIException(ErrorCodes code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCodes getCode() {
		return code;
	}

	public void setCode(ErrorCodes code) {
		this.code = code;
	}

}
