package com.nckh.nckh2020.ui;

import java.util.Locale;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nckh.nckh2020.R;
import com.nckh.nckh2020.common.Shared;

public class DifficultyView extends LinearLayout {

    private ImageView mTitle;

    public DifficultyView(Context context) {
        this(context, null);
    }

    public DifficultyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.difficult_view, this, true);
        setOrientation(LinearLayout.VERTICAL);
        mTitle = findViewById(R.id.title);
    }

    public void setDifficulty(int difficulty, int stars) {
        String titleResource = String.format(Locale.US, "button_difficulty_%d_star_%d", difficulty, stars);
        int drawableResourceId = Shared.context.getResources().getIdentifier(titleResource, "drawable", Shared.context.getPackageName());
        mTitle.setImageResource(drawableResourceId);
    }

}
