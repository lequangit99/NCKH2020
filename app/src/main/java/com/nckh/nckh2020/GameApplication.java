package com.nckh.nckh2020;

import android.app.Application;

import com.nckh.nckh2020.utils.FontLoader;

public class GameApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FontLoader.loadFonts(this);

    }
}
