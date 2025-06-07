package dev.hekmyr.holidays.api.exception;

import dev.hekmyr.holidays.api.model.ErrorCodes;

public class BadRequestException extends APIException {

	public BadRequestException(ErrorCodes code) {
	    super(code);
    }

    public BadRequestException(ErrorCodes code, String message) {
        super(code, message);
    }
}
