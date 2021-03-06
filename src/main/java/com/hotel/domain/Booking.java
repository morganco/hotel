package com.hotel.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking  extends BaseEntity {

    @OneToMany(mappedBy = "id")
    private List<Apartment> apartments;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "finishDate", nullable = false)
    private LocalDateTime finishDate;

    @Column(name = "clientId", nullable = false)
    private Long clientId;

}
