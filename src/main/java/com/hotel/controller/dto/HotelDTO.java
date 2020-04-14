package com.hotel.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {

    private String id;

    private String name;

    private Integer guestsCount;

    private List<ApartmentDTO> apartments;

    private Long organisationId;

    private Long cityId;

}
