package hu.foxpost.parcel_handler.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ParcelHandlerException.class})
    public ResponseEntity<Object> handleParcelHandlerException(Exception ex, WebRequest request) {
        ParcelHandlerException parcelHandlerException = (ParcelHandlerException) ex;

        MessageCode messageCode = parcelHandlerException.getMessageCode();
        int rawStatus = messageCode.getRawHttpStatus();

        ApiError body = new ApiError(LocalDateTime.now(), messageCode.getMessage(), rawStatus);

        return new ResponseEntity<>(body, null, rawStatus);
    }

}
