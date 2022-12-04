package com.example.quizzgameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView tv_ans_count;
    private Button btn_finish, btn_share;

    private String topicId = "",
            diffId = "",
            topic = "",
            difficulty = "";
    private int answerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_ans_count = findViewById(R.id.tv_ans_count);
        btn_finish = findViewById(R.id.btn_finish);
        btn_share = findViewById(R.id.btn_share);

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

        Intent intent = getIntent();
        answerCount = intent.getIntExtra("answer_count", 0);
        topicId = intent.getStringExtra("topic_id");
        diffId = intent.getStringExtra("diff_id");

        if (topicId.equals("geo")) {
            topic = "Địa lý";
        } else if (topicId.equals("his")) {
            topic = "Lịch sử";
        } else if (topicId.equals("sci")) {
            topic = "Khoa học";
        } else if (topicId.equals("art")) {
            topic = "Nghệ thuật";
        } else if (topicId.equals("math")) {
            topic = "Toán học";
        } else {
            topic = "Ngoại ngữ";
        }

        if (diffId.equals("easy")) {
            difficulty = "dễ";
        } else if (diffId.equals("normal")) {
            difficulty = "trung bình";
        } else {
            difficulty = "khó";
        }

        tv_ans_count.setText(answerCount + "/5");

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToMain();
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShareSheet();
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

    private void onClickShareSheet(){
        String message = "Tôi đã trả lời đúng " + answerCount +
                        " câu hỏi cấp độ " + difficulty +
                        " thuộc chủ đề " + topic;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    private void onClickGoToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}