package com.hotel.repository;

import com.hotel.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findAllByHotel(Long hotelId);

    List<Apartment> findAllByType(Long typeId);
}
