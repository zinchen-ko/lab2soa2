package com.soa.lab2soa2.service;

import com.soa.lab2soa2.dto.GroupRequest;
import com.soa.lab2soa2.model.StudyGroup;
import com.soa.lab2soa2.retrofit.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
            List<StudyGroup> groupList = groupService.getGroups();
            System.out.println(groupList);
            if (groupList == null) return Optional.of(0L);
            for (StudyGroup group : groupList) {
                sum += group.getTransferredStudents();
            }
            return Optional.of(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveStudents(long from, long to) {
        try {
            StudyGroup groupFrom = groupService.getGroupById(from);
            StudyGroup groupTo = groupService.getGroupById(to);

            GroupRequest groupRequestFrom = new GroupRequest(
                    groupFrom.getName(),
                    groupFrom.getCoordinates(),
                    0L,
                    0L,
                    groupFrom.getAverageMark(),
                    groupFrom.getSemesterEnum(),
                    groupFrom.getGroupAdmin()
            );
            GroupRequest groupRequestTo = new GroupRequest(
                    groupTo.getName(),
                    groupTo.getCoordinates(),
                    groupTo.getStudentsCount() + groupFrom.getStudentsCount(),
                    groupTo.getTransferredStudents() + groupFrom.getTransferredStudents(),
                    groupTo.getAverageMark(),
                    groupTo.getSemesterEnum(),
                    groupTo.getGroupAdmin()
            );

            groupFrom = groupService.updateGroup(from, groupRequestFrom);
            groupTo = groupService.updateGroup(to, groupRequestTo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
