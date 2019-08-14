package ng.sterling.footballfixtures.di;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ng.sterling.footballfixtures.FootBallFixture;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
       }
)
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder appModule(AppModule appModule);


        AppComponent build();
    }

    void inject(FootBallFixture footBallFixture);


}
