package com.soa.lab2soa2.dto;

import com.soa.lab2soa2.model.Coordinates;
import com.soa.lab2soa2.model.Person;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupView {
    private String name;
    private Coordinates coordinates;
    private Long studentsCount;
    private Long transferredStudents;
    private Integer averageMark;
    private String semester;
    private Person groupAdmin;
}
