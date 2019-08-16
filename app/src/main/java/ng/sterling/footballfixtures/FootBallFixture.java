package ng.sterling.footballfixtures;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ng.sterling.footballfixtures.di.AppComponent;
import ng.sterling.footballfixtures.di.DaggerAppComponent;
//import ng.sterling.footballfixtures.di.AppModule;
//import ng.sterling.footballfixtures.di.DaggerAppComponent;


public class FootBallFixture extends Application implements HasActivityInjector {


    private static AppComponent appComponent;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;


    public static AppComponent getAppComponent() {
        return appComponent;

    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();

        appComponent.inject(this);


    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }


}
