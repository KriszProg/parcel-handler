package hu.foxpost.parcel_handler.service;


import hu.foxpost.parcel_handler.dto.*;

import java.util.List;

public interface ParcelService {

    List<ParcelDto> getParcelsByParams(Integer senderId, Integer receiverId);

    List<ParcelDto> getAllParcels();

    ParcelDto getParcelByParcelNo(String parcelNo);

    List<ParcelDto> getParcelsBySenderId(Integer senderId);

    List<ParcelDto> getParcelsByReceiverId(Integer receiverId);

    ParcelBaseDto getParcelBaseByParcelNo(String parcelNo);

    List<ParcelsBySenderDto> getListOfParcelsBySender();

    List<ParcelsByReceiverDto> getListOfParcelsByReceiver();

}
