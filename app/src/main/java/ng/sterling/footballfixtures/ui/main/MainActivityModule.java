package ng.sterling.footballfixtures.ui.main;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;
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
public class MainActivityModule {


    @Provides
    MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    ApiClient provideApiClient(Application  context) {
        return new ApiClient(context);
    }

    @Provides
    MainPresenter providesMainPresenter(MainView mainView, ApiClient apiclient) {
        return new MainPresenterImpl(mainView, apiclient);
    }








}
