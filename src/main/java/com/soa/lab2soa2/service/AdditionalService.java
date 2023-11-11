package com.soa.lab2soa2.service;

import com.soa.lab2soa2.dto.GroupView;
import com.soa.lab2soa2.model.StudyGroup;
import com.soa.lab2soa2.model.StudyGroupPage;
import com.soa.lab2soa2.retrofit.GroupService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdditionalService {

    private final GroupService groupService;

    public AdditionalService(GroupService groupService) {
        this.groupService = groupService;
    }

    public Optional<Long> countTransferred() {
        try {
            long sum = 0;
            StudyGroupPage groupPage = groupService.getGroups();
            List<StudyGroup> groupList = groupPage.getStudyGroups();
            if (groupList == null) return Optional.of(0L);
            for (StudyGroup group : groupList) {
                sum += group.getTransferredStudents();
            }
            return Optional.of(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudyGroup> moveStudents(long from, long to) {
        try {
            StudyGroup groupFrom = groupService.getGroupById(from);
            StudyGroup groupTo = groupService.getGroupById(to);

            GroupView groupViewFrom = new GroupView(
                    groupFrom.getName(),
                    groupFrom.getCoordinates(),
                    0L,
                    0L,
                    groupFrom.getAverageMark(),
                    groupFrom.getSemesterEnum().getValue(),
                    groupFrom.getGroupAdmin()
            );
            GroupView groupViewTo = new GroupView(
                    groupTo.getName(),
                    groupTo.getCoordinates(),
                    groupTo.getStudentsCount() + groupFrom.getStudentsCount(),
                    groupTo.getTransferredStudents() + groupFrom.getTransferredStudents(),
                    groupTo.getAverageMark(),
                    groupTo.getSemesterEnum().getValue(),
                    groupTo.getGroupAdmin()
            );

            groupFrom = groupService.updateGroup(from, groupViewFrom);
            groupTo = groupService.updateGroup(to, groupViewTo);

            List<StudyGroup> resultList = new ArrayList<StudyGroup>();
            resultList.add(groupFrom);
            resultList.add(groupTo);

            return resultList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
