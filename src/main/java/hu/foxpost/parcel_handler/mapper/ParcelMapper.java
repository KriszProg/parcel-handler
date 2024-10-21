package hu.foxpost.parcel_handler.mapper;

import hu.foxpost.parcel_handler.dto.ParcelBaseDto;
import hu.foxpost.parcel_handler.dto.ParcelDto;
import hu.foxpost.parcel_handler.entity.Parcel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface ParcelMapper {

    ParcelDto entityToDto(Parcel parcel);

    ParcelBaseDto dtoToBaseDto(ParcelDto parcel);

    List<ParcelDto> entityListToDtoList(List<Parcel> parcelList);

    List<ParcelBaseDto> dtoListToBaseDtoList(List<ParcelDto> parcelList);

}
