package com.hotel.repository;

import com.hotel.domain.ApartmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentTypeRepository extends JpaRepository<ApartmentType, Long> {

    List<ApartmentType> findByName(String name);

}
