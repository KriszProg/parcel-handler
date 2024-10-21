package hu.foxpost.parcel_handler.mapper;

import hu.foxpost.parcel_handler.dto.ClientDto;
import hu.foxpost.parcel_handler.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto entityToDto(Client client);

    List<ClientDto> entityListToDtoList(List<Client> clientList);

}
