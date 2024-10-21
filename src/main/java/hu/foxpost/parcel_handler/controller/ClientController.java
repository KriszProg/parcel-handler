package hu.foxpost.parcel_handler.controller;

import hu.foxpost.parcel_handler.dto.ClientDto;
import hu.foxpost.parcel_handler.exception.ApiError;
import hu.foxpost.parcel_handler.service.ClientService;
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
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * ## Get all Clients
     * Returns a list which contains data of all Clients - without any filtering </br>
     * - If there is not any Client in the DB: returns an empty list
     */
    @GetMapping
    @Operation(summary = "Get all Clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))})
    })
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * ## Get Client by id
     * Returns data of Client specified by id </br>
     * - If no match: returns 404 (Client not found)
     *
     * @param id client.id
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get Client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))}),
            @ApiResponse(responseCode = "404", description = "Client not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))})
    })
    public ClientDto getClientById(@PathVariable("id") Integer id) {
        return clientService.getClientById(id);
    }

    /**
     * ## Search Clients by optional params
     * Returns a list which contains data of Clients matching with the filter condition(s) </br>
     * - If there is not any filter param: returns all the Clients
     * - If not any match with filter condition(s): returns an empty list
     *
     * @param clientName filtering for partial match (like)
     * @param address filtering for partial match (like)
     * @param zipCode filtering for exact match
     * @param city filtering for exact match
     * @param phone filtering for exact match
     * @param email filtering for partial match (like)
     */
    @GetMapping("/search")
    @Operation(summary = "Search Clients by optional params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))})
    })
    public List<ClientDto> searchClients(
            @RequestParam(required = false, value = "clientName") String clientName,
            @RequestParam(required = false, value = "address") String address,
            @RequestParam(required = false, value = "zipCode") String zipCode,
            @RequestParam(required = false, value = "city") String city,
            @RequestParam(required = false, value = "phone") String phone,
            @RequestParam(required = false, value = "email") String email) {
        return clientService.getClientsByParams(clientName, address, zipCode, city, phone, email);
    }

}
