package ng.sterling.footballfixtures.di;

import android.app.Application;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ng.sterling.footballfixtures.network.ApiClient;
import ng.sterling.footballfixtures.network.ApiService;


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

    @Provides
    ApiClient provideApiClient(Application context) {
        return new ApiClient(context);
    }

    @Provides
    EventBus provideEventBus(){
        return EventBus.getDefault();
    }

}
