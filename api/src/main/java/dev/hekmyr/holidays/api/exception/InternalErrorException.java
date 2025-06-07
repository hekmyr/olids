package dev.hekmyr.holidays.api.exception;

import dev.hekmyr.holidays.api.model.ErrorCodes;

public class InternalErrorException extends APIException {
	public InternalErrorException(ErrorCodes code) {
	    super(code);
    }

    public InternalErrorException(ErrorCodes code, String message) {
        super(code, message);
    }
}
