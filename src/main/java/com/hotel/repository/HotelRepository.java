package com.hotel.repository;

import com.hotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByCityId(Long cityId);

}
