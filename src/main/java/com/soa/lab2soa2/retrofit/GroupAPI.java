package com.soa.lab2soa2.retrofit;

import com.soa.lab2soa2.dto.GroupView;
import com.soa.lab2soa2.model.StudyGroup;
import com.soa.lab2soa2.model.StudyGroupPage;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface  GroupAPI {

    @GET("{id}")
    Call<StudyGroup> getGroupById(@Path("id") long id);

    @GET("study-groups")
    Call<StudyGroupPage> getGroups();

    @PUT("{id}")
    Call<StudyGroup> updateGroup(@Path("id") long id, @Body GroupView groupView);
}
