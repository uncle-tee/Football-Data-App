package ng.sterling.footballfixtures.ui.competionDetail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding.CompetitionStandingFragment;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding.CompetitionStandingFragmentModule;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam.CompetitionTeamFragment;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam.CompetitionTeamFragmentModule;


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
