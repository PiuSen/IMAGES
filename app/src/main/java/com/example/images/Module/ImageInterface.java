package com.example.images.Module;

import androidx.room.Database;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImageInterface {

    @Headers({"Authorization: fpeHL7EyTvpo0YeeG7BBlgPHrNym55jG5mx1EHhyDxGn7yKPIJROvPbe"})
    @GET("curated")
    Call<Model>getModel(@Query("per_page")int perpage);
    @Headers({"Authorization:fpeHL7EyTvpo0YeeG7BBlgPHrNym55jG5mx1EHhyDxGn7yKPIJROvPbe"})
    @GET("search")
    Call<Model>getApiReaspons(@Query("query")String natureName ,@Query("per_page")int perpage);
}
