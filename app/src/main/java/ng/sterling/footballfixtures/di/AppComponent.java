package ng.sterling.footballfixtures.di;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import ng.sterling.footballfixtures.FootBallFixture;
import ng.sterling.footballfixtures.ui.competionDetail.CompetitionDetailActivity;
import ng.sterling.footballfixtures.ui.main.MainPresenter;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
       }
)
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(FootBallFixture footBallFixture);

    void inject(MainPresenter mainPresenter);




}
