package com.example.smartwakala.utils;

import android.content.Context;

import com.example.smartwakala.models.Wakala;
import com.example.smartwakala.tigo.TigoPesaAgentInfoConfirmationActivity;

import io.realm.Realm;
import io.realm.RealmResults;

import static io.realm.Realm.getDefaultInstance;

public class BasicJobs {

    String namba;

    public void saveData(Wakala wakala, Context context) {

            Realm realm = getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.insertOrUpdate(wakala);

            });

    }


    public String getNumber(Context context){

        Realm.init(context);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Wakala> results = realm.where(Wakala.class).findAll();

        if (results != null) {
            for (Wakala wakala : results) {

                namba =  wakala.getSIM_No();
            }
        }

        return  namba;
    }

}
