package com.cinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@NoArgsConstructor
@Data
public class Location extends BaseEntity{
    private String name;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

}
