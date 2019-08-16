package ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

@Module
public class CompetitionStandingFragmentModule {


    @Provides
    CompetitionStandingFragmentView provideCompetionStandingView(CompetitionStandingFragment competitionStandingFragment) {
        return competitionStandingFragment;
    }


    @Provides
    CompetitionStandingFragmentPresenter providesCompetionStandingPresenter(Context context, CompetitionStandingFragmentView competitionStandingFragmentView) {
        return new CompetitionStandingFragmentPresenterImpl(context, competitionStandingFragmentView);
    }

}
