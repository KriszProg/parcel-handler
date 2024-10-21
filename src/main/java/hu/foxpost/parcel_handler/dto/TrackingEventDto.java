package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrackingEventDto {

    private int trackingId;
    private LocalDateTime eventDate;
    private String eventName;

    public TrackingEventDto trackingId(int trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public TrackingEventDto eventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public TrackingEventDto eventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TrackingEventDto that = (TrackingEventDto) object;
        return trackingId == that.trackingId
                && Objects.equals(eventDate, that.eventDate)
                && Objects.equals(eventName, that.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackingId, eventDate, eventName);
    }

    @Override
    public String toString() {
        return "TrackingEventDto{" +
                "trackingId=" + trackingId +
                ", eventDate=" + eventDate +
                ", eventName='" + eventName + '\'' +
                '}';
    }

}
