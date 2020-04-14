package com.hotel.service;

import com.hotel.domain.Apartment;
import com.hotel.domain.Booking;
import com.hotel.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService extends CRUDService<Booking, Long, BookingRepository> {

    private BookingRepository bookingRepository;

    private ApartmentService apartmentService;

    @Override
    BookingRepository getApartmentTypeRepository() {
        return bookingRepository;
    }

    public List<Booking> getAllForClient(Long clientId) {
        return bookingRepository.findAllByClientId(clientId);
    }

    public Double bookApartments(Booking booking) {
        booking.getApartments()
                .forEach(apartment -> apartment.setIsOrdered(true));
        return booking.getApartments().stream().map(Apartment::getPrice)
                .mapToDouble(Double::doubleValue).sum() * Math
                .abs(ChronoUnit.DAYS.between(booking.getStartDate(),
                        booking.getFinishDate()));
    }

    public void updateApartmentsAvailability() {
        LocalDateTime curDateTime = LocalDateTime.now();
        bookingRepository.findAll().stream()
                .filter(booking -> curDateTime.isAfter(booking.getFinishDate()))
                .map(Booking::getApartments)
                .forEach(apartments -> apartments.forEach(apartment -> {
                    apartment.setIsOrdered(false);
                    apartmentService.save(apartment);
                }));

    }

    public List<Booking> getBookingsInPeriod(LocalDateTime startDate,
                                             LocalDateTime endDate) {
        return bookingRepository.findAll().stream().filter(booking -> (startDate
                .isAfter(booking.getStartDate()) && startDate
                .isBefore(booking.getFinishDate()) || (endDate
                .isAfter(booking.getStartDate()) && endDate
                .isBefore(booking.getFinishDate()))))
                .collect(Collectors.toList());
    }

}
