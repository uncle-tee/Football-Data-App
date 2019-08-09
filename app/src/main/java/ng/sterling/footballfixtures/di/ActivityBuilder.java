package ng.sterling.footballfixtures.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import ng.sterling.footballfixtures.ui.main.MainActivity;
import ng.sterling.footballfixtures.ui.main.MainActivityModule;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
