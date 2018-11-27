package com.uraliev.anyshop;

import android.app.Application;

import io.realm.Realm;

public class AnyShopWay extends Application {
    @Override
    public void onCreate(){ super.onCreate();
        Realm.init(this);
    }
}
