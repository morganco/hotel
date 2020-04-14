package com.hotel.controller.dto;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ApartmentDTO {

    private String id;
    private HotelDTO hotel;
    private ApartmentTypeDTO type;
    private String number;
    private Double price;
    private Boolean isOrdered;

}
