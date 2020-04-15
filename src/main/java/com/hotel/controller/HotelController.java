package com.hotel.controller;

import com.hotel.controller.dto.HotelDTO;
import com.hotel.controller.mapper.HotelMapper;
import com.hotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {

    private HotelService service;

    private HotelMapper mapper;

    @PostMapping("/")
    public ResponseEntity<HotelDTO> createHotel(
            @RequestBody HotelDTO hotelDTO) {

        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(hotelDTO))));
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(mapper.toListDTO(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<List<HotelDTO>> getHotelsByCity(
            @PathVariable Long cityId) {
        return ResponseEntity
                .ok(mapper.toListDTO(service.getAllByCityId(cityId)));
    }

    @PutMapping("/")
    public ResponseEntity<HotelDTO> updateHotel(
            @RequestBody HotelDTO hotelDTO) {
        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(hotelDTO))));
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        service.deleteById(id);
    }

}
