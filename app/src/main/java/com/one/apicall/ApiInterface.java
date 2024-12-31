package com.one.apicall;
import com.one.apicall.model.ApiModel;
import com.one.apicall.room.Quote;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

//    @GET("/v1/quotes/500")
//    Call<ArrayList<ApiModel>> getdata();

    @GET("/v1/quotes/500")
    Call<ArrayList<Quote>> getquote();
}
