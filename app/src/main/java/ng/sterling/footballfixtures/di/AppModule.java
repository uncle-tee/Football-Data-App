package ng.sterling.footballfixtures.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


}
