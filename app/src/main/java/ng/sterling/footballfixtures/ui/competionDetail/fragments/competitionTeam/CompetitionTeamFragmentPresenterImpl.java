package ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionStandingRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionTeamRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionTeamFragmentPresenterImpl implements CompetitionTeamFragmentPresenter {
    Context context;
    CompetitionTeamView competitionTeamView;
    List<TeamDto> teams;


    @Inject
    public CompetitionTeamFragmentPresenterImpl(Context context, CompetitionTeamView competitionTeamView) {
        this.context = context;
        this.competitionTeamView = competitionTeamView;
    }


    @Override
    public void setCompetitionTeam(List<TeamDto> teams) {
        this.teams = teams;

        provideAdapters();
    }

    private void provideAdapters() {

        CompetitionTeamRecyclerViewAdapter adapter = new CompetitionTeamRecyclerViewAdapter(this.context, this.teams);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this.context, 3);
        competitionTeamView.setAdapterAndManager(linearLayoutManager, adapter);

    }
}
