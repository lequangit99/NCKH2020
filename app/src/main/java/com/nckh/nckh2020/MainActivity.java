package com.nckh.nckh2020;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.nckh.nckh2020.common.Shared;
import com.nckh.nckh2020.engine.Engine;
import com.nckh.nckh2020.engine.ScreenController;
import com.nckh.nckh2020.engine.ScreenController.Screen;
import com.nckh.nckh2020.events.EventBus;
import com.nckh.nckh2020.events.ui.BackGameEvent;
import com.nckh.nckh2020.ui.PopupManager;
import com.nckh.nckh2020.utils.Utils;

public class MainActivity extends FragmentActivity {

    private ImageView mBackgroundImage;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Shared.context = getApplicationContext();
        Shared.engine = Engine.getInstance();
        Shared.eventBus = EventBus.getInstance();

        setContentView(R.layout.activity_main);
        mBackgroundImage = findViewById(R.id.background_image);

        Shared.activity = this;
        Shared.engine.start();
        Shared.engine.setBackgroundImageView(mBackgroundImage);

        // set background
        setBackgroundImage();

        // set menu
        ScreenController.getInstance().openScreen(Screen.MENU);

        Intent intent1 = getIntent();
        check = intent1.getBooleanExtra("code", true);

        if (check) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            check = false;
        }

    }

    @Override
    protected void onDestroy() {
        Shared.engine.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (PopupManager.isShown()) {
            PopupManager.closePopup();
            if (ScreenController.getLastScreen() == Screen.GAME) {
                Shared.eventBus.notify(new BackGameEvent());
            }
        } else if (ScreenController.getInstance().onBack()) {
            super.onBackPressed();
        }
    }

    private void setBackgroundImage() {
        Bitmap bitmap = Utils.scaleDown(R.drawable.background, Utils.screenWidth(), Utils.screenHeight());
        bitmap = Utils.crop(bitmap, Utils.screenHeight(), Utils.screenWidth());
        bitmap = Utils.downscaleBitmap(bitmap, 2);
        mBackgroundImage.setImageBitmap(bitmap);
    }

}
