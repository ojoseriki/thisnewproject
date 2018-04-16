package com.example.st.genesys;

import android.app.Application;

import com.example.st.genesys.dataLayer.DatabaseHelper;

/**
 * Created by codethunder on 2018/04/13.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseHelper.getInstance(this);
    }
}
