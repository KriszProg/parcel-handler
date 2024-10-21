package hu.foxpost.parcel_handler.repository;

import hu.foxpost.parcel_handler.dto.TrackingEventDto;
import hu.foxpost.parcel_handler.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {

    @Query("""
            SELECT new hu.foxpost.parcel_handler.dto.TrackingEventDto(
            t.id, t.eventDate, t.event.eventName)
            FROM Tracking t
            WHERE t.parcel.id = :parcelId
            """)
    List<TrackingEventDto> findAllTrackingEventsByParcelId(@Param("parcelId") Integer parcelId);

}
