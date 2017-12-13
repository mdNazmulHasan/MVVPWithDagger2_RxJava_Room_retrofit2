package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application;

import android.app.Application;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.ApplicationComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.DaggerApplicationComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.module.ApplicationModule;


/**
 * Created by Lenovo on 11/6/2017.
 */

public class AppController extends Application {

    public static final String TAG = AppController.class.getName();
    public static ApplicationComponent mApplicationComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);


        Log.e(TAG, "onCreate: ");





    }

    public  static ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
