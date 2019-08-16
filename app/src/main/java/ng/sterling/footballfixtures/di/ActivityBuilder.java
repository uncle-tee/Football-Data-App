package ng.sterling.footballfixtures.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.sterling.footballfixtures.ui.competionDetail.CompetitionDetailActivity;
import ng.sterling.footballfixtures.ui.competionDetail.CompetitionDetailActivityModule;
import ng.sterling.footballfixtures.ui.competionDetail.CompetitionDetailsFragmentProvider;
import ng.sterling.footballfixtures.ui.main.CompetitionAndMatchFragmentProvider;
import ng.sterling.footballfixtures.ui.main.MainActivity;
import ng.sterling.footballfixtures.ui.main.MainActivityModule;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, CompetitionAndMatchFragmentProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            CompetitionDetailActivityModule.class, CompetitionDetailsFragmentProvider.class
    })
    abstract CompetitionDetailActivity bindCompetionDetailActivity();



}
