package com.hotel.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApartmentType  extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Apartment> apartments;

}
