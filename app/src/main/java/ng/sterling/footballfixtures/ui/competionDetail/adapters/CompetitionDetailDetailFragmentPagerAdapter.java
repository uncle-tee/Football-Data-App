package ng.sterling.footballfixtures.ui.competionDetail.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ng.sterling.footballfixtures.dto.response.CompetitionDetailResponse;
import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding.CompetitionStandingFragment;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam.CompetitionTeamFragment;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionfixtures.CompetitionFixtureFragment;


/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionDetailDetailFragmentPagerAdapter extends FragmentPagerAdapter {


    Context context;
    CompetitionDetailResponse data;


    public CompetitionDetailDetailFragmentPagerAdapter(FragmentManager fm, Context context, CompetitionDetailResponse data) {
        super(fm);
        this.context = context;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return CompetitionStandingFragment.newInstance((ArrayList<CompetitionStandingsTableItemDto>) data.getCompetitionStanding().getStandings().get(0).getTable());

        } else if (position == 1) {
            return CompetitionFixtureFragment.newInstance(null);
        } else if (position == 2) {
            return CompetitionTeamFragment.newInstance((ArrayList<TeamDto>) data.getTeams().getTeams());
        }
        return CompetitionStandingFragment.newInstance((ArrayList<CompetitionStandingsTableItemDto>) data.getCompetitionStanding().getStandings().get(0).getTable());


    }

    @Override
    public int getCount() {
        return 3;
    }
}
