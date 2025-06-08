package dev.hekmyr.holidays.api.exception;

import dev.hekmyr.holidays.api.model.ErrorCodes;

public class NotFoundException extends APIException {

	public NotFoundException(ErrorCodes code) {
	    super(code);
    }

    public NotFoundException(ErrorCodes code, String message) {
        super(code, message);
    }
}
