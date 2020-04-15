package com.hotel.controller;

import com.hotel.controller.dto.BookingDTO;
import com.hotel.controller.mapper.BookingMapper;
import com.hotel.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private BookingService service;

    private BookingMapper mapper;

    @PostMapping("/")
    public ResponseEntity<BookingDTO> createBooking(
            @RequestBody BookingDTO bookingDTO) {

        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(bookingDTO))));
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(mapper.toListDTO(service.getAll()));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByClientId(
            @PathVariable Long clientId) {
        return ResponseEntity
                .ok(mapper.toListDTO(service.getAllForClient(clientId)));
    }

    @PostMapping("/order")
    public ResponseEntity<Double> bookApartments(
            @RequestBody BookingDTO bookingDTO) {

        return ResponseEntity
                .ok(service.bookApartments(mapper.fromDTO(bookingDTO)));
    }

    @PutMapping("/")
    public ResponseEntity<BookingDTO> updateBooking(
            @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity
                .ok(mapper.toDTO(service.save(mapper.fromDTO(bookingDTO))));
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        service.deleteById(id);
    }

}
