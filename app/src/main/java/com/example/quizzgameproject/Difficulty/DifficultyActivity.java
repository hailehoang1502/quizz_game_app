package com.example.quizzgameproject.Difficulty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quizzgameproject.InformationActivity;
import com.example.quizzgameproject.R;
import com.example.quizzgameproject.Topic.Topic;


public class DifficultyActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    FragmentManager mFragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rcv_listDifficultyMain, new DifficultyListFragment());
        fragmentTransaction.commit();

        Intent intent = getIntent();
        String topicId = intent.getStringExtra("topic_id");

        sendToDiffFrag(topicId);

        Button btn_his, btn_play;
        btn_his = findViewById(R.id.btn_his);
        btn_play = findViewById(R.id.btn_play);

        btn_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButtonHistory();
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButtonPlay();
            }
        });

        ImageButton btn_popup_menu;
        btn_popup_menu = findViewById(R.id.btn_popup_menu);
        btn_popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
    }

    void onClickButtonHistory(){
        Toast.makeText(this, "Tính năng này chưa được phát triển", Toast.LENGTH_SHORT).show();
    }

    void onClickButtonPlay(){
        Toast.makeText(this, "Bạn đang ở màn hình chơi", Toast.LENGTH_SHORT).show();
    }

    void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedback:
                Toast.makeText(this, "Tính năng này chưa được phát triển", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.information:
                Intent intent = new Intent(this, InformationActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    public void sendToDiffFrag(String topicId) {
        DifficultyListFragment difficultyListFragment = new DifficultyListFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rcv_listDifficultyMain, difficultyListFragment);
        Bundle bundle = new Bundle();
        bundle.putString("topic_id", topicId);
        difficultyListFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

}