package com.example.smartwakala.utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmHelper extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(config);
    }
}


