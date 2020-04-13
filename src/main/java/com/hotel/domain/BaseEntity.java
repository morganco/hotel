package com.hotel.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class BaseEntity {

    @Id
    protected Long id;

}
