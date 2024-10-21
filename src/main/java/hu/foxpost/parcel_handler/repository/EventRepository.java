package hu.foxpost.parcel_handler.repository;

import hu.foxpost.parcel_handler.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
