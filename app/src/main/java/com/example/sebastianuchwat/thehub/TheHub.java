package com.example.sebastianuchwat.thehub;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by sebastianuchwat on 11/02/2018.
 */

public class TheHub extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
