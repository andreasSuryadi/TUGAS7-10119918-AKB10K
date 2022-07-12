package com.example.a10119918latihan7publicapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a10119918latihan7publicapi.Adapter.AnimeAdapter;
import com.example.a10119918latihan7publicapi.Api.ApiEndPoint;
import com.example.a10119918latihan7publicapi.Api.ApiService;
import com.example.a10119918latihan7publicapi.Model.AnimeModel;
import com.example.a10119918latihan7publicapi.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 10 Juli 2022
 *
 */

public class MainActivity extends AppCompatActivity {
    private AnimeAdapter viewAdapter;
    private List<AnimeModel> mItems = new ArrayList<>();
    private static final int successCode = 200;

    @BindView(R.id.recyclerHospital)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List Anime");

        viewAdapter = new AnimeAdapter(this, mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataHospital();
    }

    private void loadDataHospital() {
        //Declare Retrofit
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> call = api.getAnime();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String statusCode = response.body().getStatus();
                progressBar.setVisibility(View.GONE);

                if (statusCode.equals("success")) {
                    mItems = response.body().animeList;
                    System.out.println("STATUS data " + mItems);
                    viewAdapter = new AnimeAdapter(MainActivity.this, mItems);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("Error", "Error msg: ", t);
                Toast.makeText(MainActivity.this, "Oops, your connection is Bad!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}