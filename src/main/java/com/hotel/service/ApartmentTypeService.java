package com.hotel.service;

import com.hotel.domain.ApartmentType;
import com.hotel.repository.ApartmentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApartmentTypeService extends CRUDService<ApartmentType, Long, ApartmentTypeRepository> {

    private ApartmentTypeRepository apartmentTypeRepository;

    @Override
    ApartmentTypeRepository getApartmentTypeRepository() {
        return apartmentTypeRepository;
    }

    public List<ApartmentType> getByName(String name) {
        return apartmentTypeRepository.findByName(name);
    }

}
