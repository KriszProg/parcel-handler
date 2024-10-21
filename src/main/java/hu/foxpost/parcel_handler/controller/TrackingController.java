package hu.foxpost.parcel_handler.controller;

import hu.foxpost.parcel_handler.dto.TrackingEventDto;
import hu.foxpost.parcel_handler.service.TrackingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired
    TrackingService trackingService;

    /**
     * ## Get TrackingEvents filtered by Parcel id
     * Returns a list which contains data of TrackingEvents - filtered by Parcel id </br>
     * - If Parcel not exists by id: returns an empty list
     *
     * @param parcelId filtering for exact match by tracking.parcel.id
     */
    @GetMapping("/events/{parcelId}")
    @Operation(summary = "Get TrackingEvents filtered by Parcel id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TrackingEventDto.class)))})
    })
    public List<TrackingEventDto> getAllTrackingEventsByParcelId(@PathVariable("parcelId") Integer parcelId) {
        return trackingService.getAllTrackingEventsByParcelId(parcelId);
    }

}
