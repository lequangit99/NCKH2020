package com.nckh.nckh2020.ta;

/**
 * Created by canbay on 24.12.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.nckh.nckh2020.R;

import java.util.ArrayList;

public class QuizResultActivity extends AppCompatActivity {

    ArrayList<String> myAnsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_result);


        //get rating bar object
        RatingBar bar = findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        //get text view
        TextView tvAnsweredInfo = findViewById(R.id.tvAnsweredInfo);
        TextView t = findViewById(R.id.textResult);

        //get score with the bundle
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        int totalQs = b.getInt("totalQs");
        myAnsList = b.getStringArrayList("myAnsList");

        //display score
        bar.setRating(score);

        tvAnsweredInfo.setText(score + " câu trả lời đúng/" + totalQs + " câu hỏi");

        float percentage = (score * 100) / totalQs;

        if (percentage >= 80 && percentage <= 100) {
            t.setText("Hoàn hảo!");
        } else if (percentage >= 70 && percentage <= 79) {
            t.setText("Thành công!");
        } else if (percentage >= 60 && percentage <= 69) {
            t.setText("Tốt!");
        } else if (percentage >= 50 && percentage <= 59) {
            t.setText("Khá!");
        } else if (percentage >= 33 && percentage <= 49) {
            t.setText("Bình thường!");
        } else {
            t.setText("Điểm của bạn khá thấp! Bạn nên chăm chỉ hơn");
        }

        final Intent intent = new Intent(this, MainTaActivity.class);
        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });

        Button btnViewAnswer = findViewById(R.id.btnViewAnswer);
        btnViewAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent = new Intent(QuizResultActivity.this, QuizViewAnswerActivity.class);
                vIntent.putStringArrayListExtra("myAnsList", myAnsList);
                startActivity(vIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}