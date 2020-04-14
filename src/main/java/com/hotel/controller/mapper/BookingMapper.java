package com.hotel.controller.mapper;

import com.hotel.controller.dto.BookingDTO;
import com.hotel.domain.Booking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ApartmentMapper.class})
public interface BookingMapper {

    @Mappings({})
    BookingDTO toDTO(Booking booking);

    @Mappings({})
    List<BookingDTO> toListDTO(List<Booking> bookings);

    @InheritInverseConfiguration
    Booking fromDTO(BookingDTO bookingDTO);

    @InheritInverseConfiguration
    List<Booking> fromListDTO(List<BookingDTO> bookingDTOS);

}
