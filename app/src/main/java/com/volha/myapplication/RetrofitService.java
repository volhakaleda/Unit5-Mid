package com.volha.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

  @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
  Call<Response> getPeople();

}
