package hu.foxpost.parcel_handler.service;

import hu.foxpost.parcel_handler.dto.*;
import hu.foxpost.parcel_handler.entity.Parcel;
import hu.foxpost.parcel_handler.exception.ParcelHandlerException;
import hu.foxpost.parcel_handler.exception.MessageCode;
import hu.foxpost.parcel_handler.mapper.ParcelMapper;
import hu.foxpost.parcel_handler.repository.ParcelRepository;
import hu.foxpost.parcel_handler.specification.ParcelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    ParcelMapper parcelMapper;

    @Override
    public List<ParcelDto> getParcelsByParams(Integer senderId, Integer receiverId) {
        Specification<Parcel> spec = Specification
                .where(ParcelSpecification.hasSenderId(senderId))
                .and(ParcelSpecification.hasReceiverId(receiverId));

        List<Parcel> entityList = parcelRepository.findAll(spec);
        return parcelMapper.entityListToDtoList(entityList);
    }

    @Override
    public List<ParcelDto> getAllParcels() {
        List<Parcel> entityList = parcelRepository.findAll();
        return parcelMapper.entityListToDtoList(entityList);
    }

    @Override
    public ParcelDto getParcelByParcelNo(String parcelNo) {
        Parcel parcel = parcelRepository.findByParcelNo(parcelNo)
                .orElseThrow(() -> new ParcelHandlerException(MessageCode.PARCEL_NOT_FOUND));

        return parcelMapper.entityToDto(parcel);
    }

    @Override
    public List<ParcelDto> getParcelsBySenderId(Integer senderId) {
        List<Parcel> entityList = parcelRepository.findAllParcelsBySenderId(senderId);
        return parcelMapper.entityListToDtoList(entityList);
    }

    @Override
    public List<ParcelDto> getParcelsByReceiverId(Integer receiverId) {
        List<Parcel> entityList = parcelRepository.findAllParcelsByReceiverId(receiverId);
        return parcelMapper.entityListToDtoList(entityList);
    }

    @Override
    public ParcelBaseDto getParcelBaseByParcelNo(String parcelNo) {
        return parcelRepository.findParcelBaseByParcelNo(parcelNo)
                .orElseThrow(() -> new ParcelHandlerException(MessageCode.PARCEL_NOT_FOUND));
    }

    @Override
    public List<ParcelsBySenderDto> getListOfParcelsBySender() {
        Map<ClientDto, List<ParcelDto>> parcelBySender = getParcelListGroupBy(ParcelDto::getSender);

        return parcelBySender.entrySet().stream()
                .map(entry -> {
                    ClientDto sender = entry.getKey();
                    List<ParcelBaseDto> parcels = parcelMapper.dtoListToBaseDtoList(entry.getValue());
                    return new ParcelsBySenderDto(sender, parcels);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ParcelsByReceiverDto> getListOfParcelsByReceiver() {
        Map<ClientDto, List<ParcelDto>> parcelByReceiver = getParcelListGroupBy(ParcelDto::getReceiver);

        return parcelByReceiver.entrySet().stream()
                .map(entry -> {
                    ClientDto receiver = entry.getKey();
                    List<ParcelBaseDto> parcels = parcelMapper.dtoListToBaseDtoList(entry.getValue());
                    return new ParcelsByReceiverDto(receiver, parcels);
                })
                .collect(Collectors.toList());
    }

    private Map<ClientDto, List<ParcelDto>> getParcelListGroupBy(Function<ParcelDto, ClientDto> classifier) {
        List<ParcelDto> parcelList = parcelMapper.entityListToDtoList(parcelRepository.findAll());

        return parcelList.stream()
                .collect(Collectors.groupingBy(classifier));
    }

}
