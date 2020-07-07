package com.nckh.nckh2020.toan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nckh.nckh2020.R;

import java.util.Random;

public class GameOverPage extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Double screenInches = MainMenu.screenInches;

    Button forwardFromGameOver;
    TextView titleLbl;
    TextView messageLbl;
    TextView scoreLbl;
    TextView correctLbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        populateFields();
        calculateValues();
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        forwardFromGameOver = findViewById(R.id.fowardFromGameOver);
        messageLbl = findViewById(R.id.gameOverMsg);
        titleLbl = findViewById(R.id.gameOverTitle);
        scoreLbl = findViewById(R.id.gameOverScore);
        correctLbl = findViewById(R.id.gameOverCorrect);

        forwardFromGameOver.setScaleX((float) (forwardFromGameOver.getScaleX() * 0.75));

        if (screenInches <= 3.95) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(45);
            messageLbl.setTextSize(20);
            scoreLbl.setTextSize(28);
            correctLbl.setTextSize(25);
        } else if (screenInches <= 4.75) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(48);
            messageLbl.setTextSize(25);
            scoreLbl.setTextSize(30);
            correctLbl.setTextSize(27);
        } else if (screenInches <= 5.85) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(49);
            messageLbl.setTextSize(23);
            scoreLbl.setTextSize(29);
            correctLbl.setTextSize(27);
        } else if (screenInches <= 7.55) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(55);
            messageLbl.setTextSize(32);
            scoreLbl.setTextSize(33);
            correctLbl.setTextSize(31);
        } else if (screenInches <= 10.5) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.7f);
            forwardFromGameOver.setScaleY(1.5f);
            titleLbl.setTextSize(75);
            messageLbl.setTextSize(40);
            scoreLbl.setTextSize(40);
            correctLbl.setTextSize(40);
        } else {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(25);
            messageLbl.setTextSize(25);
            scoreLbl.setTextSize(22);
            correctLbl.setTextSize(22);
        }
    }

    public void populateFields() {

        int lastScore = pref.getInt("tempscore", 0);

        if (lastScore > pref.getInt("hs", 0)) {
            messageLbl.setText("ĐIỂM CAO MỚI");
        } else {
            if (lastScore == 0) {
                if (pref.getBoolean("practice", false)) {
                    editor.putBoolean("practice", false);
                    messageLbl.setText("CHƠI MÀN MỚI");
                } else {
                    messageLbl.setText("BẠN ĐÃ HOÀN THÀNH");
                }
            } else {
                String tempMsg = "";
                Random random = new Random();
                switch (random.nextInt(3)) {
                    case 0:
                        tempMsg = "RẤT TỐT, HÃY PHÁT HUY";
                        break;
                    case 1:
                        tempMsg = "TỐT, NHƯNG BẠN CÓ THỂ LÀM TỐT HƠN";
                        break;
                    case 2:
                        tempMsg = "KHÁ TỐT, HÃY CHĂM CHỈ HƠN NỮA";
                        break;
                }
                messageLbl.setText(tempMsg);
            }
        }

        scoreLbl.setText("ĐIỂM SỐ:  " + lastScore);
        correctLbl.setText("SỐ CÂU TRẢ LỜI ĐÚNG  " + pref.getInt("correct", 0));
    }

    public void calculateValues() {
        int temp = pref.getInt("tempscore", 0);

        if (pref.getInt("hs", 0) < temp) {
            editor.putInt("hs", temp);
        }

        temp = pref.getInt("totalcorrect", 0);
        temp += pref.getInt("correct", 0);
        editor.putInt("totalcorrect", temp);

        temp = pref.getInt("totalscore", 0);
        temp += pref.getInt("tempscore", 0);
        editor.putInt("totalscore", temp);

        temp = pref.getInt("games", 0);
        temp += 1;
        editor.putInt("games", temp);

        /// calc XP and level

        temp = pref.getInt("xp", 0);
        temp += pref.getInt("tempscore", 0);

        int level = 0;
        while (temp > 100) {
            level += 1;
            temp -= 100;
        }
        editor.putInt("xp", temp);

        if (level > 0) {
            temp = pref.getInt("level", 1);
            temp += level;
            editor.putInt("level", temp);
        }

        editor.putInt("tempscore", 0);
        editor.putInt("correct", 0);

        editor.apply();
    }

    public void returnToMain(View v) {
        if (MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameOverPage.this, MainMenu.class));
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
        if (MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameOverPage.this, MainMenu.class));
    }

}
