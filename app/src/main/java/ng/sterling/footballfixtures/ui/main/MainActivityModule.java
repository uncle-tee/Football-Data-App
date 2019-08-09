package ng.sterling.footballfixtures.ui.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

@Singleton
@Module
public class MainActivityModule {


    @Provides
    MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }



    @Provides
    MainPresenter providesMainPresenter(MainView mainView) {
        return new MainPresenterImpl(mainView);
    }
}
