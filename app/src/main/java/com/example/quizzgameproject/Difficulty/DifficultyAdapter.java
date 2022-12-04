package com.example.quizzgameproject.Difficulty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzgameproject.QuizzActivity;
import com.example.quizzgameproject.R;
import com.example.quizzgameproject.my_interface.IClickItemDiffListener;

import java.util.List;

public class DifficultyAdapter extends RecyclerView.Adapter<DifficultyAdapter.DifficultyViewHolder> {
    private Context mContext;
    private List<Difficulty> mListDifficulty;
    private IClickItemDiffListener iClickItemDiffListener;

    public DifficultyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Difficulty> list, IClickItemDiffListener listener) {
        this.mListDifficulty = list;
        this.iClickItemDiffListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DifficultyAdapter.DifficultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_difficulty, parent, false);
        return new DifficultyAdapter.DifficultyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DifficultyViewHolder holder, int position) {
        Difficulty difficulty = mListDifficulty.get(position);
        if (difficulty == null) {
            return;
        }
        holder.imgDifficulty.setImageResource(difficulty.getResourceID());
        holder.tvDifficultyName.setText(difficulty.getName());

        holder.layoutItemDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemDiffListener.onClickItemDiff(difficulty);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (mListDifficulty != null){
            return mListDifficulty.size();
        }
        return 0;
    }

    public class DifficultyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutItemDiff;
        private ImageView imgDifficulty;
        private TextView tvDifficultyName;

        public DifficultyViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutItemDiff = itemView.findViewById(R.id.layout_item_diff);
            imgDifficulty = itemView.findViewById(R.id.difficulty_image);
            tvDifficultyName = itemView.findViewById(R.id.tv_difficulty);
        }
    }
}
