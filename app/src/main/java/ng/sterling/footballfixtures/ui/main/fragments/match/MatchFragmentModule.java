package ng.sterling.footballfixtures.ui.main.fragments.match;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

@Module
public class MatchFragmentModule {


    @Provides
    MatchFragmentView providesMatchFragmentView(MatchFragment matchFragment) {
        return matchFragment;
    }


    @Provides
    MatchFragmentPresenter providesMatchFragmentPresenter(Context context, MatchFragment matchFragment) {
        return new MatchFragmentPresenterImpl(context, matchFragment);
    }

}
