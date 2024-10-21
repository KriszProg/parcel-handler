package hu.foxpost.parcel_handler.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "events")
@Getter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private short id;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                '}';
    }

}
