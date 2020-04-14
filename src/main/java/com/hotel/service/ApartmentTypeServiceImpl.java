package com.hotel.service;

import com.hotel.domain.ApartmentType;
import com.hotel.repository.ApartmentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApartmentTypeServiceImpl extends CRUDService<ApartmentType, Long, ApartmentTypeRepository> implements ApartmentTypeService {

    private ApartmentTypeRepository apartmentTypeRepository;

    @Override
    ApartmentTypeRepository getApartmentTypeRepository() {
        return apartmentTypeRepository;
    }

}
