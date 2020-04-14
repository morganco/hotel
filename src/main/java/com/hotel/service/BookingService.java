package com.hotel.service;

import com.hotel.domain.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllForClient(Long clientId);

    Double bookApartments(Booking booking);

    void updateApartmentsAvailability();

}
