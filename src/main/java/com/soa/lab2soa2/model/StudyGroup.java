package com.soa.lab2soa2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
public class StudyGroup {
    @JsonProperty("id")
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @JsonProperty("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonProperty("coordinates")
    private Coordinates coordinates; //Поле не может быть null
    @JsonProperty("creationDate")
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @JsonProperty("studentsCount")
    private long studentsCount; //Значение поля должно быть больше 0
    @JsonProperty("transferredStudents")
    private long transferredStudents; //Значение поля должно быть больше 0
    @JsonProperty("averageMark")
    private int averageMark; //Значение поля должно быть больше 0
    @JsonProperty("semesterEnum")
    private Semester semesterEnum; //Поле может быть null
    @JsonProperty("groupAdmin")
    private Person groupAdmin; //Поле не может быть null

}

