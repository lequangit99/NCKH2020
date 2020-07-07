package com.nckh.nckh2020.ta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nckh.nckh2020.MainActivity2;
import com.nckh.nckh2020.R;

public class MainTaActivity extends AppCompatActivity {

    ImageView daysandmonths;
    ImageView numbers;
    ImageView animals;
    ImageView fruits;
    ImageView goods;
    ImageView colors;
    Button quizyap, homeTA;
    MediaPlayer number;
    MediaPlayer animal;
    MediaPlayer fruit;
    MediaPlayer day;
    MediaPlayer object;
    MediaPlayer color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ta);
        daysandmonths = findViewById(R.id.daysandmonths);
        numbers = findViewById(R.id.numbers);
        animals = findViewById(R.id.animals);
        fruits = findViewById(R.id.fruits);
        goods = findViewById(R.id.goods);
        colors = findViewById(R.id.colors);
        quizyap = findViewById(R.id.quizyap);
        homeTA = findViewById(R.id.home_ta);

        number = MediaPlayer.create(this, R.raw.numbers);
        day = MediaPlayer.create(this, R.raw.days);
        animal = MediaPlayer.create(this, R.raw.animals);
        fruit = MediaPlayer.create(this, R.raw.fruits);
        object = MediaPlayer.create(this, R.raw.objects);
        color = MediaPlayer.create(this, R.raw.colors);


        final Intent intentdays = new Intent(this, TabbedActivityDays.class);
        final Intent intentnumbers = new Intent(this, TabbedActivityNumbers.class);
        final Intent intentanimals = new Intent(this, TabbedActivityAnimals.class);
        final Intent intentfruits = new Intent(this, TabbedActivityFruits.class);
        final Intent intentobjects = new Intent(this, TabbedActivityGoods.class);
        final Intent intentcolors = new Intent(this, TabbedActivityColors.class);
        final Intent quizsayfasi = new Intent(this, QuizMainActivity.class);


        daysandmonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                day.start();
                startActivity(intentdays);

            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.start();
                startActivity(intentnumbers);

            }
        });

        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.start();
                startActivity(intentanimals);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruit.start();
                startActivity(intentfruits);
            }
        });

        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.start();
                startActivity(intentobjects);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color.start();
                startActivity(intentcolors);
            }
        });

        quizyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(quizsayfasi);
            }
        });

        homeTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainTaActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        day.release();
        number.release();
        animal.release();
        fruit.release();
        object.release();
        color.release();

    }
}