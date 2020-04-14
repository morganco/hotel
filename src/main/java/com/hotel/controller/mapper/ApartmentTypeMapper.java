package com.hotel.controller.mapper;

import com.hotel.controller.dto.ApartmentTypeDTO;
import com.hotel.domain.ApartmentType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ApartmentMapper.class})
public interface ApartmentTypeMapper {

    @Mappings({})
    ApartmentTypeDTO toDTO(ApartmentType apartmentType);

    @Mappings({})
    List<ApartmentTypeDTO> toListDTO(List<ApartmentType> apartmentTypes);

    @InheritInverseConfiguration
    ApartmentType fromDTO(ApartmentTypeDTO apartmentTypeDTO);

    @InheritInverseConfiguration
    List<ApartmentType> fromListDTO(List<ApartmentTypeDTO> apartmentTypeDTOS);

}
