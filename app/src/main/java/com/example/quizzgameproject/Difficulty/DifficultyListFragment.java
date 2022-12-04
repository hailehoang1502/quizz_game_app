package com.example.quizzgameproject.Difficulty;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizzgameproject.QuizzActivity;
import com.example.quizzgameproject.R;
import com.example.quizzgameproject.my_interface.IClickItemDiffListener;

import java.util.ArrayList;
import java.util.List;

public class DifficultyListFragment extends Fragment {

    public String topicId = "";

    private RecyclerView rcvDifficulty;
    private DifficultyAdapter difficultyAdapter;
    private View mView;

    public DifficultyListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            topicId = bundle.getString("topic_id");
        } else{
            topicId = "null";
        }
    }

    private List<Difficulty> getListDifficulty() {
        List<Difficulty> list = new ArrayList<>();
        list.add(new Difficulty("easy","Dễ", R.drawable.ic_baseline_easy));
        list.add(new Difficulty("normal","Trung bình", R.drawable.ic_baseline_normal));
        list.add(new Difficulty("hard","Khó", R.drawable.ic_baseline_hard));

        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_difficulty_list, container, false);

        rcvDifficulty = mView.findViewById(R.id.rcv_listDifficulty);
        difficultyAdapter = new DifficultyAdapter(requireContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvDifficulty.setLayoutManager(linearLayoutManager);

        difficultyAdapter.setData(getListDifficulty(), new IClickItemDiffListener() {
            @Override
            public void onClickItemDiff(Difficulty difficulty) {
                if (topicId != "null") {
                    Intent intent = new Intent(requireActivity(), QuizzActivity.class);
                    intent.putExtra("topic_id", topicId);
                    intent.putExtra("diff_id", difficulty.getId());
                    startActivity(intent);
                }
            }
        });
        rcvDifficulty.setAdapter(difficultyAdapter);

        return mView;
    }
}