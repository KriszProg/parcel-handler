package hu.foxpost.parcel_handler.controller;

import hu.foxpost.parcel_handler.dto.*;
import hu.foxpost.parcel_handler.exception.ApiError;
import hu.foxpost.parcel_handler.service.ParcelService;
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
@RequestMapping("/parcels")
public class ParcelController {

    @Autowired
    ParcelService parcelService;

    /**
     * ## Get Parcels filtered by optional params
     * Returns a list which contains detailed data of Parcels - matching with filter condition(s) </br>
     * - If there is not any filter param: returns all the Parcels
     * - If not any match with filter condition(s): returns an empty list
     * - If there is not any Parcel in the DB: returns an empty list
     *
     * @param senderId filtering for exact match by parcels.sender.id
     * @param receiverId filtering for exact match parcels.receiver.id

     */
    @GetMapping("/detailed")
    @Operation(summary = "Get Parcels filtered by optional params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelDto.class)))})
    })
    public List<ParcelDto> getParcelsByParams(
            @RequestParam(required = false, value = "senderId") Integer senderId,
            @RequestParam(required = false, value = "receiverId") Integer receiverId) {
        return parcelService.getParcelsByParams(senderId, receiverId);
    }

    /**
     * ## Get all Parcels
     * Returns a list which contains detailed data of all Parcels - without any filtering </br>
     * - If there is not any Parcel in the DB: returns an empty list
     */
    @GetMapping("/detailed/all")
    @Operation(summary = "Get all Parcels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelDto.class)))})
    })
    public List<ParcelDto> getAllParcels() {
        return parcelService.getAllParcels();
    }

    /**
     * ## Get Parcel filtered by Parcel no
     * Returns data of Parcel specified by Parcel no </br>
     * - If no match: returns 404 (Parcel not found)
     *
     * @param parcelNo filtering for exact match by parcels.parcelNo

     */
    @GetMapping("/detailed/by-parcel-no/{parcelNo}")
    @Operation(summary = "Get Parcel filtered by Parcel no")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelDto.class))}),
            @ApiResponse(responseCode = "404", description = "Parcel not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))})
    })
    public ParcelDto getParcelByParcelNo(@PathVariable("parcelNo") String parcelNo) {
        return parcelService.getParcelByParcelNo(parcelNo);
    }

    /**
     * ## Get Parcels filtered by Sender
     * Returns a list which contains detailed data of Parcels - filtered by Sender id </br>
     * - If Sender not exists by id: returns an empty list
     * - If there is no Parcel belongs to existing Sender: returns an empty list
     *
     *  @param senderId filtering for exact match by parcels.sender.id
     */
    @GetMapping("/detailed/by-sender/{senderId}")
    @Operation(summary = "Get Parcels filtered by Sender")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelDto.class)))})
    })
    public List<ParcelDto> getParcelsBySenderId(@PathVariable("senderId") Integer senderId) {
        return parcelService.getParcelsBySenderId(senderId);
    }

    /**
     * ## Get Parcels filtered by Receiver
     * Returns a list which contains detailed data of Parcels - filtered by Receiver id </br>
     * - If Receiver not exists by id: returns an empty list
     * - If there is no Parcel belongs to existing Receiver: returns an empty list
     *
     *  @param receiverId filtering for exact match by parcels.receiver.id
     */
    @GetMapping("/detailed/by-receiver/{receiverId}")
    @Operation(summary = "Get Parcels filtered by Receiver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelDto.class)))})
    })
    public List<ParcelDto> getParcelsByReceiverId(@PathVariable("receiverId") Integer receiverId) {
        return parcelService.getParcelsByReceiverId(receiverId);
    }

    /**
     * ## Get ParcelBase filtered by Parcel no
     * Returns a ParcelBase object (id, parcelNo) specified by Parcel no </br>
     * - If no match: returns 404 (Parcel not found)
     *
     *  @param parcelNo filtering for exact match by parcels.parcelNo
     */
    @GetMapping("/base-data/{parcelNo}")
    @Operation(summary = "Get ParcelBase filtered by Parcel no")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelBaseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Parcel not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))})
    })
    public ParcelBaseDto getParcelBaseByParcelNo(@PathVariable("parcelNo") String parcelNo) {
        return parcelService.getParcelBaseByParcelNo(parcelNo);
    }

    /**
     * ## Get List of 'Sender and its parcels' - grouped by Sender
     * Returns a list which contains data of all Senders and base data of Parcels (id, parcelNo) belongs to the Sender </br>
     * The Parcels data in the list are grouped by Sender </br>
     * - If there is not any Parcel in the DB: return an empty list
     */
    @GetMapping("/base-data/grouped-by-sender")
    @Operation(summary = "Get List of 'Sender and its parcels' - grouped by Sender")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelsBySenderDto.class)))})
    })
    public List<ParcelsBySenderDto> getListOfParcelsBySender() {
        return parcelService.getListOfParcelsBySender();
    }

    /**
     * ## Get List of 'Receiver and its parcels' - grouped by Receiver
     * Returns a list which contains data of all Receivers and base data of Parcels (id, parcelNo) belongs to the Receiver </br>
     * The Parcels data in the list are grouped by Receiver </br>
     * - If there is not any Parcel in the DB: return an empty list
     */
    @GetMapping("/base-data/grouped-by-receiver")
    @Operation(summary = "Get List of 'Receiver and its parcels' - grouped by Receiver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ParcelsByReceiverDto.class)))})
    })
    public List<ParcelsByReceiverDto> getListOfParcelsByReceiver() {
        return parcelService.getListOfParcelsByReceiver();
    }

}
