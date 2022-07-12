package com.example.a10119918latihan7publicapi.Api;

import com.example.a10119918latihan7publicapi.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 11 Juli 2022
 *
 */

public interface ApiService {
    @GET("api/complete/page/2")
    Call<ResponseModel> getAnime();
}
