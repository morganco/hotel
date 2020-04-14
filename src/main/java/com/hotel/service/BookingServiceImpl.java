package com.hotel.service;

import com.hotel.domain.Apartment;
import com.hotel.domain.Booking;
import com.hotel.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl extends CRUDService<Booking, Long, BookingRepository> implements BookingService {

    private BookingRepository bookingRepository;

    @Override
    BookingRepository getApartmentTypeRepository() {
        return bookingRepository;
    }

    @Override
    public List<Booking> getAllForClient(Long clientId) {
        return bookingRepository.findAllByClientId(clientId);
    }

    @Override
    public Double bookApartments(Booking booking) {
        booking.getApartments()
                .forEach(apartment -> apartment.setIsOrdered(true));
        return booking.getApartments().stream().map(Apartment::getPrice)
                .mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public void updateApartmentsAvailability() {
        LocalDateTime curDateTime = LocalDateTime.now();
        bookingRepository.findAll().stream().filter(booking -> !(curDateTime
                .isAfter(booking.getStartDate()) && curDateTime
                .isBefore(booking.getFinishDate()))).map(Booking::getApartments)
                .forEach(apartments -> apartments
                        .forEach(apartment -> apartment.setIsOrdered(false)));
    }

}
