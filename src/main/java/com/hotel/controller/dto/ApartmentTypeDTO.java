package com.hotel.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApartmentTypeDTO {

    private String id;

    private String name;

    private List<ApartmentDTO> apartments;

}
