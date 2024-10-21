package hu.foxpost.parcel_handler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private LocalDateTime timestamp;
    private String error;
    private Integer status;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ApiError apiError = (ApiError) object;
        return Objects.equals(timestamp, apiError.timestamp)
                && Objects.equals(error, apiError.error)
                && Objects.equals(status, apiError.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, error, status);
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "timestamp=" + timestamp +
                ", error='" + error + '\'' +
                ", status=" + status +
                '}';
    }

}
