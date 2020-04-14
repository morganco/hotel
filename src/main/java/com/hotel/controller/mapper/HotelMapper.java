package com.hotel.controller.mapper;

import com.hotel.controller.dto.HotelDTO;
import com.hotel.domain.Hotel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ApartmentMapper.class})
public interface HotelMapper {

    @Mappings({})
    HotelDTO toDTO(Hotel group);

    @Mappings({})
    List<HotelDTO> toListDTO(List<Hotel> groups);

    @InheritInverseConfiguration
    Hotel fromDTO(HotelDTO groupDTO);

    @InheritInverseConfiguration
    List<Hotel> fromListDTO(List<HotelDTO> groupDTOS);

}
