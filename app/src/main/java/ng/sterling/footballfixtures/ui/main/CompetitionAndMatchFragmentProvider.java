package ng.sterling.footballfixtures.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.sterling.footballfixtures.ui.main.fragments.competition.CompetitionFragment;
import ng.sterling.footballfixtures.ui.main.fragments.competition.CompetitionFragmentModule;
import ng.sterling.footballfixtures.ui.main.fragments.match.MatchFragment;
import ng.sterling.footballfixtures.ui.main.fragments.match.MatchFragmentModule;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

@Module
public abstract class CompetitionAndMatchFragmentProvider {


    @ContributesAndroidInjector(modules = {
            CompetitionFragmentModule.class
    })
    abstract CompetitionFragment competionFragmentProvider();

    @ContributesAndroidInjector(modules = {
            MatchFragmentModule.class
    })
    abstract MatchFragment matchFragmentrovider();


}
