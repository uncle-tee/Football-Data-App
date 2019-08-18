package ng.sterling.footballfixtures.di;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ng.sterling.footballfixtures.network.ApiClient;
import ng.sterling.footballfixtures.network.ApiService;
import ng.sterling.footballfixtures.network.NoConnectivityInterceptor;
import ng.sterling.footballfixtures.utils.DividerItemDecoration;
import okhttp3.Interceptor;


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
    @Singleton
    Interceptor providesNoConnectivityInterceptor(Context context){
        return new NoConnectivityInterceptor(context);
    }


    @Provides
    ApiClient provideApiClient(Application context, Interceptor noConnectivityInterceptor) {
        return new ApiClient(context, noConnectivityInterceptor);
    }

    @Provides
    EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Provides
    RecyclerView.ItemDecoration  providesDividerItemDecorator(Context context){
        return new DividerItemDecoration(context);
    }

}
