package hu.foxpost.parcel_handler.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trackings")
@Getter
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "parcel_id", nullable = false)
    private Parcel parcel;

    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Override
    public String toString() {
        return "Tracking{" +
                "id=" + id +
                ", parcel=" + parcel +
                ", eventDate=" + eventDate +
                ", event=" + event +
                '}';
    }

}
