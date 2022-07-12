package com.example.a10119918latihan7publicapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a10119918latihan7publicapi.Model.AnimeModel;
import com.example.a10119918latihan7publicapi.R;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyHolder> {
    List<AnimeModel> mList;
    Context ctx;

    public AnimeAdapter(Context ctx, List<AnimeModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @Override
    public AnimeAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        AnimeAdapter.MyHolder holder = new AnimeAdapter.MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(AnimeAdapter.MyHolder holder, final int position) {
        AnimeModel animeModel = mList.get(position);
//        holder.count.setText(String.valueOf(position+1));
        holder.title.setText(animeModel.getTitle());
        holder.episode.setText(animeModel.getEpisode());
        holder.score.setText(animeModel.getScore());

        Glide.with(ctx)
                .load(animeModel.getThumb())
                .placeholder(R.drawable.anime)
                .error(R.drawable.anime)
                .into(holder.animePoster);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title, episode, score, count;
        ImageView animePoster;
        AnimeModel animeListModelData;

        public MyHolder(View v) {
            super(v);
//            count = (TextView) v.findViewById(R.id.txtCount);
            title = (TextView) v.findViewById(R.id.activity_title);
            episode = (TextView) v.findViewById(R.id.activity_episode);
            score = (TextView) v.findViewById(R.id.activity_score);
            animePoster = (ImageView) v.findViewById(R.id.activity_poster);
        }
    }
}