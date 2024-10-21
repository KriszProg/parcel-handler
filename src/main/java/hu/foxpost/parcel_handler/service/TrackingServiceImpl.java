package hu.foxpost.parcel_handler.service;

import hu.foxpost.parcel_handler.dto.TrackingEventDto;
import hu.foxpost.parcel_handler.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    TrackingRepository trackingRepository;

    @Override
    public List<TrackingEventDto> getAllTrackingEventsByParcelId(Integer parcelId) {
        return trackingRepository.findAllTrackingEventsByParcelId(parcelId);
    }

}
