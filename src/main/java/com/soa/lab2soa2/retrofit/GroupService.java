package com.soa.lab2soa2.retrofit;

import com.soa.lab2soa2.dto.GroupRequest;
import com.soa.lab2soa2.model.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Service
public class  GroupService {

    private final GroupAPI groupAPI;

    public GroupService(Retrofit retrofit) {
        this.groupAPI = retrofit.create(GroupAPI.class);
    }


    public StudyGroup getGroupById(long id) throws IOException {
        return groupAPI.getGroupById(id).execute().body();
    }

    public List<StudyGroup> getGroups() throws IOException {
        return groupAPI.getGroups().execute().body();
    }
    
    public StudyGroup updateGroup(long id, GroupRequest groupRequest) throws IOException {
        return groupAPI.updateGroup(id, groupRequest).execute().body();
    }

}
