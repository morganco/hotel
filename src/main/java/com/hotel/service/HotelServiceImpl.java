package com.hotel.service;

import com.hotel.domain.Hotel;
import com.hotel.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl extends CRUDService<Hotel, Long, HotelRepository> implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    HotelRepository getApartmentTypeRepository() {
        return hotelRepository;
    }

    @Override
    public List<Hotel> getAllByCityId(Long cityId) {
        return hotelRepository.findAllByCityId(cityId);
    }

}
