package com.hotel.controller.mapper;

import com.hotel.controller.dto.ApartmentDTO;
import com.hotel.domain.Apartment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ApartmentTypeMapper.class})
public interface ApartmentMapper {

    @Mappings({})
    ApartmentDTO toDTO(Apartment apartment);

    @Mappings({})
    List<ApartmentDTO> toListDTO(List<Apartment> apartments);

    @InheritInverseConfiguration
    Apartment fromDTO(ApartmentDTO apartmentDTO);

    @InheritInverseConfiguration
    List<Apartment> fromListDTO(List<ApartmentDTO> apartmentDTOS);

}