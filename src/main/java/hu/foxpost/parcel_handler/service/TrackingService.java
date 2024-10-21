package hu.foxpost.parcel_handler.service;

import hu.foxpost.parcel_handler.dto.TrackingEventDto;

import java.util.List;

public interface TrackingService {

    List<TrackingEventDto> getAllTrackingEventsByParcelId(Integer parcelId);

}
