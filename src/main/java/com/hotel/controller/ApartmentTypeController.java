package com.hotel.controller;

import com.hotel.controller.dto.ApartmentTypeDTO;
import com.hotel.controller.mapper.ApartmentTypeMapper;
import com.hotel.domain.ApartmentType;
import com.hotel.service.ApartmentTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment-types")
@AllArgsConstructor
public class ApartmentTypeController {

    private ApartmentTypeService service;

    private ApartmentTypeMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ApartmentTypeDTO> createApartmentType(
            @RequestBody String name) {

        return ResponseEntity.ok(mapper.toDTO(service
                .save(ApartmentType.builder().name(name).build())));
    }

    @GetMapping("/")
    public ResponseEntity<List<ApartmentTypeDTO>> getAllApartmentTypes() {
        return ResponseEntity.ok(mapper.toListDTO(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentTypeDTO> getApartmentTypeById(
            @PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ApartmentTypeDTO>> getApartmentTypeByName(
            @PathVariable String name) {
        return ResponseEntity.ok(mapper.toListDTO(service.getByName(name)));
    }

    @PutMapping("/")
    public ResponseEntity<ApartmentTypeDTO> updateApartmentType(@RequestBody ApartmentType type) {
        return ResponseEntity.ok(mapper.toDTO(service.save(type)));
    }

    @DeleteMapping("/{id}")
    public void deleteApartmentType(@PathVariable Long id) {
        service.deleteById(id);
    }

}
