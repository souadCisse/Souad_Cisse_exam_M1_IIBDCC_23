package com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_network;

import com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_model.IPResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface IPApi {
    String BASE_URL = "https://ipinfo.io/";
    
    @GET("{ipAddress}/geo")
    Call<IPResponseModel> getIPInfo(@Path("ipAddress") String ipAddress);
}
