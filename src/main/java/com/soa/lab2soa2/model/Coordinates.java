package com.soa.lab2soa2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Coordinates {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("x")
    private Long x; //Поле не может быть null
    @JsonProperty("y")
    private Float y; //Поле не может быть null

    public Coordinates(Long x, Float y) {
        this.x = x;
        this.y = y;
    }
}