package com.hotel.service;

import com.hotel.domain.Apartment;
import com.hotel.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApartmentServiceImpl extends CRUDService<Apartment, Long, ApartmentRepository> implements ApartmentService {

    private ApartmentRepository apartmentRepository;

    @Override
    ApartmentRepository getApartmentTypeRepository() {
        return apartmentRepository;
    }

    @Override
    public List<Apartment> getNotOrderedApartments() {
        return super.getAll().stream()
                .filter(apartment -> apartment.getIsOrdered().equals(false))
                .collect(Collectors.toList());
    }

    @Override
    public List<Apartment> getAllByHotelId(Long hotelId) {
        return apartmentRepository.findAllByHotel(hotelId);
    }

    @Override
    public List<Apartment> getAllByTypeId(Long typeId) {
        return apartmentRepository.findAllByType(typeId);
    }

}
