package com.soa.lab2soa2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Coordinates {
    private Integer id;
    private Long x; //Поле не может быть null
    private Float y; //Поле не может быть null

}