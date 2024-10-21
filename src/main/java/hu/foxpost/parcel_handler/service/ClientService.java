package hu.foxpost.parcel_handler.service;


import hu.foxpost.parcel_handler.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients();

    ClientDto getClientById(Integer id);

    List<ClientDto> getClientsByParams(String clientName, String address, String zipCode, String city,
                                       String phone, String email);

}
