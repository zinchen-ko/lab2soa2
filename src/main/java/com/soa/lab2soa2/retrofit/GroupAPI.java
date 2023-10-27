package com.soa.lab2soa2.retrofit;

import com.soa.lab2soa2.dto.GroupRequest;
import com.soa.lab2soa2.model.StudyGroup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface  GroupAPI {

    @GET("{id}")
    Call<StudyGroup> getGroupById(@Path("id") long id);

    @GET("study-groups")
    Call<List<StudyGroup>> getGroups();

    @PUT("{id}")
    Call<StudyGroup> updateGroup(@Path("id") long id, @Body GroupRequest groupRequest);
}
