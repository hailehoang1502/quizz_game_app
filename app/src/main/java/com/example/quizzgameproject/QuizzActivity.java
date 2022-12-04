package com.example.quizzgameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizzgameproject.Difficulty.Difficulty;

public class QuizzActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView tv_question, tv_progress;
    Button btn_true, btn_false;
    ProgressBar progressBar;

    int mCountCorrectAns = 0;
    int mCurrentIndex = 1;

    private String topicId = "";
    private String diffId = "";

    private boolean answer;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        btn_true = findViewById(R.id.btn_true);
        btn_false = findViewById(R.id.btn_false);
        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);
        tv_question = findViewById(R.id.tv_question);

        Intent intent = getIntent();
        topicId = intent.getStringExtra("topic_id");
        diffId = intent.getStringExtra("diff_id");

        setQaA();

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

        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == true) {
                    mCountCorrectAns++;
                }
                if (questionNumber == 4){
                    onClickGoToResult();
                }
                else {
                    questionNumber++;
                    mCurrentIndex++;
                    setQaA();
                }
            }
        });

        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == false) {
                    mCountCorrectAns++;
                }
                if (questionNumber == 4){
                    onClickGoToResult();
                }
                else {
                    questionNumber++;
                    mCurrentIndex++;
                    setQaA();
                }
            }
        });
    }

    void onClickButtonHistory(){
        Toast.makeText(this, "Tính năng này chưa được phát triển", Toast.LENGTH_SHORT).show();
    }

    void onClickButtonPlay(){
        Toast.makeText(this, "Bạn đang ở màn hình chơi", Toast.LENGTH_SHORT).show();
    }

    private void onClickGoToResult() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("answer_count", mCountCorrectAns);
        intent.putExtra("topic_id", topicId);
        intent.putExtra("diff_id", diffId);
        startActivity(intent);

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

    private void setQaA() {
        if (topicId.equals("geo")) {
            if (diffId.equals("easy")) {
                tv_question.setText(Question.geoEasyQuestion[questionNumber]);
                answer = Question.geoEasyAnswer[questionNumber];
            }
            else if (diffId.equals("normal")) {
                tv_question.setText(Question.geoNormalQuestion[questionNumber]);
                answer = Question.geoNormalAnswer[questionNumber];
            }
            else {
                tv_question.setText(Question.geoHardQuestion[questionNumber]);
                answer = Question.geoHardAnswer[questionNumber];
            }
        }
        else if (topicId.equals("his")) {
            if (diffId.equals("easy")) {
                tv_question.setText(Question.hisEasyQuestion[questionNumber]);
                answer = Question.hisEasyAnswer[questionNumber];
            }
            else if (diffId.equals("normal")) {
                tv_question.setText(Question.hisNormalQuestion[questionNumber]);
                answer = Question.hisNormalAnswer[questionNumber];
            }
            else {
                tv_question.setText(Question.hisHardQuestion[questionNumber]);
                answer = Question.hisHardAnswer[questionNumber];
            }
        }
        else if (topicId.equals("sci")) {
            if (diffId.equals("easy")) {
                tv_question.setText(Question.sciEasyQuestion[questionNumber]);
                answer = Question.sciEasyAnswer[questionNumber];
            }
            else if (diffId.equals("normal")) {
                tv_question.setText(Question.sciNormalQuestion[questionNumber]);
                answer = Question.sciNormalAnswer[questionNumber];
            }
            else {
                tv_question.setText(Question.sciHardQuestion[questionNumber]);
                answer = Question.sciHardAnswer[questionNumber];
            }
        }
        else if (topicId.equals("art")) {
            if (diffId.equals("easy")) {
                tv_question.setText(Question.artEasyQuestion[questionNumber]);
                answer = Question.artEasyAnswer[questionNumber];
            }
            else if (diffId.equals("normal")) {
                tv_question.setText(Question.artNormalQuestion[questionNumber]);
                answer = Question.artNormalAnswer[questionNumber];
            }
            else {
                tv_question.setText(Question.artHardQuestion[questionNumber]);
                answer = Question.artHardAnswer[questionNumber];
            }
        }
        else if (topicId.equals("math")) {
            if (diffId.equals("easy")) {
                tv_question.setText(Question.mathEasyQuestion[questionNumber]);
                answer = Question.mathEasyAnswer[questionNumber];
            }
            else if (diffId.equals("normal")) {
                tv_question.setText(Question.mathNormalQuestion[questionNumber]);
                answer = Question.mathNormalAnswer[questionNumber];
            }
            else {
                tv_question.setText(Question.mathHardQuestion[questionNumber]);
                answer = Question.mathHardAnswer[questionNumber];
            }
        }
        progressBar.setProgress(mCurrentIndex);
        tv_progress.setText(mCurrentIndex + "/5");
    }
}