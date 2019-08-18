package ng.sterling.footballfixtures.ui.competionDetail;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ng.sterling.footballfixtures.network.ApiClient;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

@Module
public abstract class CompetitionDetailActivityModule {


    @Binds
    abstract CompetitionDetailView provideCompetitionDetailView(CompetitionDetailActivity competitionDetailActivity) ;

    @Provides
   static CompetitionDetailPresenter providesCompetitionDetailPresenter(Context context,
                                                                  CompetitionDetailView competitionDetailView,
                                                                  ApiClient apiClient, EventBus eventBus) {


        return new CompetitionDetailPresenterImpl(apiClient, context, competitionDetailView, eventBus);
    }

}
