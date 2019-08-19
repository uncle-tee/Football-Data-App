package ng.sterling.footballfixtures.ui.competitionDetail.fragments.competitionTeam;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.competitionDetail.adapters.CompetitionTeamRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionTeamFragmentPresenterImpl implements CompetitionTeamFragmentPresenter, CompetitionTeamRecyclerViewAdapter.SetOnClickListener {
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

        CompetitionTeamRecyclerViewAdapter adapter = new CompetitionTeamRecyclerViewAdapter(this.context, this.teams, this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this.context, 3);
        competitionTeamView.setAdapterAndManager(linearLayoutManager, adapter);

    }

    @Override
    public void onClick(String squadId) {
        competitionTeamView.navigateToSquad(squadId);
    }


}
