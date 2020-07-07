package com.nckh.nckh2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nckh.nckh2020.ta.MainTaActivity;
import com.nckh.nckh2020.toan.MainMenu;

public class MainActivity2 extends AppCompatActivity {
    Button btnToan, btnTA, btnGT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnGT = findViewById(R.id.btn_GT);
        btnToan = findViewById(R.id.btn_toan);
        btnTA = findViewById(R.id.btn_TA);


        btnGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("code", false);
                startActivity(intent);
            }
        });


        btnToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainMenu.class);
                startActivity(intent);
            }
        });

        btnTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainTaActivity.class);
                startActivity(intent);
            }
        });


    }
}