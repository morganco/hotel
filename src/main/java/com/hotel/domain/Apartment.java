package com.hotel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Entity
public class Apartment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = true)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "apartment_type_id")
    private ApartmentType type;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "isOrdered", nullable = false)
    @ColumnDefault("false")
    private Boolean isOrdered;

}
