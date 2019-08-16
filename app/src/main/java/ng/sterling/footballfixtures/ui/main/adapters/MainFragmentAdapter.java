package ng.sterling.footballfixtures.ui.main.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;
import ng.sterling.footballfixtures.ui.main.fragments.competition.CompetitionFragment;
import ng.sterling.footballfixtures.ui.main.fragments.MatchFixtureFragment;
import ng.sterling.footballfixtures.ui.main.fragments.match.MatchFragment;

/**
 * Author: Oluwatobi Adenekan
 * date:    14/08/2019
 **/

public class MainFragmentAdapter extends FragmentPagerAdapter {
    Context context;
    private MainResponseDto data;


    public MainFragmentAdapter(Context context,
                               FragmentManager fm,
                               MainResponseDto data) {
        super(fm);
        this.context = context;
        this.data = data;

    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        return tabTitles[position];
//    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MatchFragment.newInstance((ArrayList<Match>) this.data.getMatches().getMatches());
            case 1:
                return CompetitionFragment.newInstance((ArrayList<NameAndId>) this.data.getCompetitions().getCompetitions());
        }

        return new MatchFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }


    public interface Listener {
        void onItemClick();
    }
}
