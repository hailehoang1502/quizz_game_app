package com.example.quizzgameproject.Topic;

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

import com.example.quizzgameproject.Difficulty.DifficultyActivity;
import com.example.quizzgameproject.R;
import com.example.quizzgameproject.my_interface.IClickItemTopicListener;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder>{

    private List<Topic> mListTopic;
    private IClickItemTopicListener iClickItemTopicListener;

    public void setData(List<Topic> list, IClickItemTopicListener listener) {
        this.mListTopic = list;
        this.iClickItemTopicListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        final Topic topic = mListTopic.get(position);
        if (topic == null) {
            return;
        }
        holder.imgTopic.setImageResource(topic.getResourceID());
        holder.tvTopicName.setText(topic.getName());

        holder.layoutItemTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemTopicListener.onClickItemTopic(topic);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListTopic != null){
            return mListTopic.size();
        }
        return 0;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutItemTopic;
        private ImageView imgTopic;
        private TextView tvTopicName;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutItemTopic = itemView.findViewById(R.id.layout_item_topic);
            imgTopic = itemView.findViewById(R.id.topic_image);
            tvTopicName = itemView.findViewById(R.id.tv_topic_name);
        }
    }
}

