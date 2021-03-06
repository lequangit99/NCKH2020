package com.nckh.nckh2020.ta;

/**
 * Created by canbay on 24.12.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.nckh.nckh2020.R;

import java.util.ArrayList;
import java.util.List;

public class QuizConceptActivity extends AppCompatActivity {

    private List<Question> questionsList;
    private Question currentQuestion;

    private TextView txtQuestion, tvNoOfQs;
    private RadioButton rbtnA, rbtnB, rbtnC, rbtnD;
    private Button btnNext;
    private ImageView questionImage;

    private int obtainedScore = 0;
    private int questionId = 0;

    private int answeredQsNo = 0;

    ArrayList<String> myAnsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_concept);


        //Initialize the view
        init();

        //Initialize the database
        final DBAdapter dbAdapter = new DBAdapter(this);
        questionsList = dbAdapter.getRandomQuestions();
        currentQuestion = questionsList.get(questionId);

        //Set question
        setQuestionsView();

        //Check and Next
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = findViewById(R.id.radioGroup1);
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

                Log.e("Answer ID", "Selected Positioned  value - " + grp.getCheckedRadioButtonId());

                if (answer != null) {
                    Log.e("Answer", currentQuestion.getANSWER() + " -- " + answer.getText());
                    //Add answer to the list
                    myAnsList.add("" + answer.getText());

                    if (currentQuestion.getANSWER().equals(answer.getText())) {
                        obtainedScore++;
                        Log.e("comments", "Doğru Cevap");
                        Log.d("score", "Skorun " + obtainedScore);
                    } else {
                        Log.e("comments", "Yanlış Cevap");
                    }
                    if (questionId < 10) {
                        currentQuestion = questionsList.get(questionId);
                        setQuestionsView();
                    } else {
                        Intent intent = new Intent(QuizConceptActivity.this, QuizResultActivity.class);

                        Bundle b = new Bundle();
                        b.putInt("score", obtainedScore);
                        b.putInt("totalQs", questionsList.size());
                        b.putStringArrayList("myAnsList", myAnsList);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();

                    }

                } else {
                    Log.e("comments", "No Answer");
                }

                //Need to clear the checked item id
                grp.clearCheck();


            }//end onClick Method
        });


    }

    public void init() {
        tvNoOfQs = findViewById(R.id.tvNumberOfQuestions);
        txtQuestion = findViewById(R.id.tvQuestion);
        questionImage = findViewById(R.id.questionImage);


        rbtnA = findViewById(R.id.radio0);
        rbtnB = findViewById(R.id.radio1);
        rbtnC = findViewById(R.id.radio2);
        rbtnD = findViewById(R.id.radio3);

        btnNext = findViewById(R.id.btnNext);

        myAnsList = new ArrayList<String>();
    }


    private void setQuestionsView() {
        rbtnA.setChecked(false);
        rbtnB.setChecked(false);
        rbtnC.setChecked(false);
        rbtnD.setChecked(false);

        answeredQsNo = questionId + 1;
        tvNoOfQs.setText(" câu hỏi thứ " + answeredQsNo + " /" + questionsList.size() + " câu hỏi");

        questionImage.setImageResource(currentQuestion.getQUESTIONImageId());
        txtQuestion.setText(currentQuestion.getQUESTION());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());

        questionId++;
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
