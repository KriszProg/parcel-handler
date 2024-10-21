package hu.foxpost.parcel_handler.service;

import hu.foxpost.parcel_handler.dto.ClientDto;
import hu.foxpost.parcel_handler.entity.Client;
import hu.foxpost.parcel_handler.exception.MessageCode;
import hu.foxpost.parcel_handler.exception.ParcelHandlerException;
import hu.foxpost.parcel_handler.mapper.ClientMapper;
import hu.foxpost.parcel_handler.repository.ClientRepository;
import hu.foxpost.parcel_handler.specification.ClientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> entityList = clientRepository.findAll();
        return clientMapper.entityListToDtoList(entityList);
    }

    @Override
    public ClientDto getClientById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ParcelHandlerException(MessageCode.CLIENT_NOT_FOUND));

        return clientMapper.entityToDto(client);
    }

    @Override
    public List<ClientDto> getClientsByParams(String clientName, String address, String zipCode, String city,
                                              String phone, String email) {
        Specification<Client> spec = Specification
                .where(ClientSpecification.hasNameLike(clientName))
                .and(ClientSpecification.hasAddressLike(address))
                .and(ClientSpecification.hasZipCode(zipCode))
                .and(ClientSpecification.hasCity(city))
                .and(ClientSpecification.hasPhone(phone))
                .and(ClientSpecification.hasEmailLike(email));

        List<Client> clientList = clientRepository.findAll(spec);
        return clientMapper.entityListToDtoList(clientList);
    }

}
