package ng.sterling.footballfixtures.ui.main.fragments.competition;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

@Module
public class CompetitionFragmentModule {

    @Provides
    CompetitionFragmentView providesCompetionFragmentView(CompetitionFragment competitionFragment) {
        return competitionFragment;
    }

    @Provides
    CompetitionFragmentPresenter providesCompetionFragmentPresenter(CompetitionFragment competitionFragment) {
        return new CompetitionFragmentPresenterImpl(competitionFragment.getContext(), competitionFragment);
    }

    @Provides
    Context provideContext(CompetitionFragment competitionFragment){
        return competitionFragment.getActivity();
    }


}
