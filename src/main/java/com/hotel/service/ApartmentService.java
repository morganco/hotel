package com.hotel.service;

import com.hotel.domain.Apartment;
import com.hotel.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApartmentService extends CRUDService<Apartment, Long, ApartmentRepository> {

    private ApartmentRepository apartmentRepository;

    private BookingService bookingService;

    @Override
    ApartmentRepository getApartmentTypeRepository() {
        return apartmentRepository;
    }

    public List<Apartment> getNotOrderedApartments() {
        return apartmentRepository.findAll().stream()
                .filter(apartment -> apartment.getIsOrdered().equals(false))
                .collect(Collectors.toList());
    }

    public List<Apartment> getAllByHotelId(Long hotelId) {
        return apartmentRepository.findAllByHotel(hotelId);
    }

    public List<Apartment> getAllByTypeId(Long typeId) {
        return apartmentRepository.findAllByType(typeId);
    }

    public List<Apartment> getNotOrderedApartmentsForPeriod(
            LocalDateTime startDate, LocalDateTime finishDate) {
        return getAll().stream().filter(apartment -> !bookingService
                .getBookingsInPeriod(startDate, finishDate)
                .contains(apartment.getId())).collect(Collectors.toList());

    }

}
