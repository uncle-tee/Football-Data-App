package ng.sterling.footballfixtures.ui.competitionDetail.fragments.competitionTeam;

import android.support.v7.widget.GridLayoutManager;

import ng.sterling.footballfixtures.ui.competitionDetail.adapters.CompetitionTeamRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionTeamView {
    void setAdapterAndManager(GridLayoutManager layoutManager, CompetitionTeamRecyclerViewAdapter adapter);

    void navigateToSquad(String teamId);
}
