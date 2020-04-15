package com.hotel.controller;

import com.hotel.controller.dto.ApartmentDTO;
import com.hotel.controller.mapper.ApartmentMapper;
import com.hotel.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/apartments")
@AllArgsConstructor
public class ApartmentController {

    private ApartmentService service;

    private ApartmentMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ApartmentDTO> createApartment(
            @RequestBody ApartmentDTO apartmentDTO) {

        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(apartmentDTO))));
    }

    @GetMapping("/")
    public ResponseEntity<List<ApartmentDTO>> getAllApartments() {
        return ResponseEntity.ok(mapper.toListDTO(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentDTO> getApartmentById(
            @PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<ApartmentDTO>> getApartmentsByHotelId(
            @PathVariable Long hotelId) {
        return ResponseEntity
                .ok(mapper.toListDTO(service.getAllByHotelId(hotelId)));
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<List<ApartmentDTO>> getApartmentsByTypeId(
            @PathVariable Long typeId) {
        return ResponseEntity
                .ok(mapper.toListDTO(service.getAllByTypeId(typeId)));
    }

    @GetMapping("/not-ordered")
    public ResponseEntity<List<ApartmentDTO>> getNotOrderedApartments() {
        return ResponseEntity
                .ok(mapper.toListDTO(service.getNotOrderedApartments()));
    }

    @GetMapping("/not-ordered-for-period")
    public ResponseEntity<List<ApartmentDTO>> getNotOrderedApartmentsForPeriod(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(mapper.toListDTO(
                service.getNotOrderedApartmentsForPeriod(startDate, endDate)));
    }

    @PutMapping("/")
    public ResponseEntity<ApartmentDTO> updateApartment(
            @RequestBody ApartmentDTO apartmentDTO) {
        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(apartmentDTO))));
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable Long id) {
        service.deleteById(id);
    }

}
