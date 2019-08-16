package ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/


@Module
public class CompetitionTeamFragmentModule {

    @Provides
    CompetitionTeamView providesCompetionTeamView(CompetitionTeamFragment competitionTeamFragment) {
        return competitionTeamFragment;
    }

    @Provides
    CompetitionTeamFragmentPresenter providesCompetitionTeamPresenter(Context context, CompetitionTeamView competitionTeamView){
        return new CompetitionTeamFragmentPresenterImpl(context, competitionTeamView);
    }
}
