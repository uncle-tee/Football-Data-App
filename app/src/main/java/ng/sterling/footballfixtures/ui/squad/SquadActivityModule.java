package ng.sterling.footballfixtures.ui.squad;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import ng.sterling.footballfixtures.network.ApiClient;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

@Module
public class SquadActivityModule {

    @Provides
    SquadActivityView providesSquadActivity(SquadActivity squadActivity) {
        return squadActivity;
    }

    @Provides
    SquadActivityPresenter providesSquadActivityPresenter(Context context,
                                                          ApiClient apiClient,
                                                          EventBus eventBus,
                                                          SquadActivityView squadActivityView) {

        return new SquadActivityPresenterImpl(context, apiClient, squadActivityView,eventBus);
    }
}
