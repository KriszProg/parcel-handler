package hu.foxpost.parcel_handler.exception;

import lombok.Getter;

@Getter
public class ParcelHandlerException extends RuntimeException {

    private final MessageCode messageCode;

    public ParcelHandlerException(MessageCode messageCode) {
        super(messageCode.getMessage());
        this.messageCode = messageCode;
    }

}
