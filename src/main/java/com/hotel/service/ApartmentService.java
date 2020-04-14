package com.hotel.service;

import com.hotel.domain.Apartment;

import java.util.List;

public interface ApartmentService {

    List<Apartment> getNotOrderedApartments();

    List<Apartment> getAllByHotelId(Long hotelId);

    List<Apartment> getAllByTypeId(Long typeId);

}
