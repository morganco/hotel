package com.hotel.service;

import com.hotel.domain.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllByCityId(Long cityId);

}
