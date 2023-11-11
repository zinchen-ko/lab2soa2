package com.soa.lab2soa2.model;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudyGroupPage {
    private List<StudyGroup> studyGroups;
    private int page;
    private int pageSize;
    private int totalPages;
    private long totalCount;
}
