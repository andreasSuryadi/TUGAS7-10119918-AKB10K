package com.example.a10119918latihan7publicapi.Model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 11 Juli 2022
 *
 */

public class AnimeModel {
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("thumb")
    public String thumb;
    @SerializedName("episode")
    public String episode;
    @SerializedName("score")
    public String score;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumb() {
        return thumb;
    }

    public String getEpisode() {
        return episode;
    }

    public String getScore() {
        return score;
    }
}
