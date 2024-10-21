package hu.foxpost.parcel_handler.exception;

import org.springframework.http.HttpStatus;

public enum MessageCode {
    CLIENT_NOT_FOUND("Ügyfél nem található!", HttpStatus.NOT_FOUND),
    PARCEL_NOT_FOUND("Csomag nem található!", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

    MessageCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public int getRawHttpStatus() {
        return  httpStatus.value();
    }

}
