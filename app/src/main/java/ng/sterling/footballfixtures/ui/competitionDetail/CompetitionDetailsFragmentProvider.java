package ng.sterling.footballfixtures.ui.competitionDetail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.sterling.footballfixtures.ui.competitionDetail.fragments.competionStanding.CompetitionStandingFragment;
import ng.sterling.footballfixtures.ui.competitionDetail.fragments.competionStanding.CompetitionStandingFragmentModule;
import ng.sterling.footballfixtures.ui.competitionDetail.fragments.competitionTeam.CompetitionTeamFragment;
import ng.sterling.footballfixtures.ui.competitionDetail.fragments.competitionTeam.CompetitionTeamFragmentModule;


/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

@Module
public abstract class CompetitionDetailsFragmentProvider {


    @ContributesAndroidInjector(modules = {
            CompetitionStandingFragmentModule.class
    })
    abstract CompetitionStandingFragment competionFragmentProvider();


    @ContributesAndroidInjector(modules = {
            CompetitionTeamFragmentModule.class
    })
    abstract CompetitionTeamFragment competitionTeamProvider();
}
