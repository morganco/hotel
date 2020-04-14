package com.hotel.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingDTO {

    private String id;

    private List<ApartmentDTO> apartments;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private Long clientId;

}
