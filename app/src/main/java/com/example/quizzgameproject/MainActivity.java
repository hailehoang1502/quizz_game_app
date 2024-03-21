package com.example.quizzgameproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.quizzgameproject.Difficulty.DifficultyActivity;
import com.example.quizzgameproject.Topic.Topic;
import com.example.quizzgameproject.Topic.TopicListFragment;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rcv_listTopic_main, new TopicListFragment());
        fragmentTransaction.commit();

        ImageButton btn_popup_menu;
        btn_popup_menu = findViewById(R.id.btn_popup_menu);
        btn_popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });

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
}