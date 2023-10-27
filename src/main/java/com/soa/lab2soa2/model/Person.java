package com.soa.lab2soa2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Date birthday;
    private Float weight;
    private Float height;
    private String passportID;
}

