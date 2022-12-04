package com.example.quizzgameproject.Topic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzgameproject.Difficulty.DifficultyActivity;
import com.example.quizzgameproject.R;
import com.example.quizzgameproject.my_interface.IClickItemTopicListener;

import java.util.ArrayList;
import java.util.List;

public class TopicListFragment extends Fragment {

    private RecyclerView rcvTopic;
    private TopicAdapter topicAdapter;
    private View mView;

    public TopicListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<Topic> getListTopic() {
        List<Topic> list = new ArrayList<>();
        list.add(new Topic("geo","Địa lý", R.drawable.geo));
        list.add(new Topic("his","Lịch sử", R.drawable.his));
        list.add(new Topic("sci","Khoa học", R.drawable.sci));
        list.add(new Topic("art","Nghệ thuật", R.drawable.art));
        list.add(new Topic("math","Toán học", R.drawable.math));

        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_topic_list, container, false);

        rcvTopic = mView.findViewById(R.id.rcv_listTopic);
        topicAdapter = new TopicAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvTopic.setLayoutManager(linearLayoutManager);

        topicAdapter.setData(getListTopic(), new IClickItemTopicListener() {
            @Override
            public void onClickItemTopic(Topic topic) {
                Intent intent = new Intent(requireActivity(), DifficultyActivity.class);
                intent.putExtra("topic_id", topic.getId());
                startActivity(intent);

            }
        });
        rcvTopic.setAdapter(topicAdapter);

        return mView;
    }

}