package com.hotel.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "guestsCount", nullable = false)
    private Integer guestsCount;

    @OneToMany(mappedBy = "id")
    private List<Apartment> apartments;

    @Column(name = "organisation_id", nullable = true)
    private Long organisationId;

    @Column(name = "city_id", nullable = true)
    private Long cityId;

}
