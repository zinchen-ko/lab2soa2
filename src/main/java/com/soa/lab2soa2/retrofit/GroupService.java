package com.soa.lab2soa2.retrofit;

import com.soa.lab2soa2.dto.GroupView;
import com.soa.lab2soa2.model.StudyGroup;
import com.soa.lab2soa2.model.StudyGroupPage;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import java.io.IOException;

@Service
public class  GroupService {

    private final GroupAPI groupAPI;

    public GroupService(Retrofit retrofit) {
        this.groupAPI = retrofit.create(GroupAPI.class);
    }


    public StudyGroup getGroupById(long id) throws IOException {
        return groupAPI.getGroupById(id).execute().body();
    }

    public StudyGroupPage getGroups() throws IOException {
        return groupAPI.getGroups().execute().body();
    }
    
    public StudyGroup updateGroup(long id, GroupView groupView) throws IOException {
        return groupAPI.updateGroup(id, groupView).execute().body();
    }

}
