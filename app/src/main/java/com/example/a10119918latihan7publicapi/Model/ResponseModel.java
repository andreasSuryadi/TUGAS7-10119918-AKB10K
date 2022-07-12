package com.example.a10119918latihan7publicapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 11 Juli 2022
 *
 */

public class ResponseModel {
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String message;
    @SerializedName("animeList")
    public List<AnimeModel> animeList = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public List<AnimeModel> getData() {
        return animeList;
    }

    public void setData(List<AnimeModel> animeList) {
        this.animeList = animeList;
    }
}
