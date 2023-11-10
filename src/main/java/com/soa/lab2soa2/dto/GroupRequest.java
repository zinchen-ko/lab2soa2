package com.soa.lab2soa2.dto;

import com.soa.lab2soa2.model.Coordinates;
import com.soa.lab2soa2.model.Person;
import com.soa.lab2soa2.model.Semester;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupRequest {
    private String name;
    private Coordinates coordinates;
    private Long studentsCount;
    private Long transferredStudents;
    private Integer averageMark;
    private String semester;
    private Person groupAdmin;
}
