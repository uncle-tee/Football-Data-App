package ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionTeamRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionTeamView {
    void setAdapterAndManager(GridLayoutManager layoutManager, CompetitionTeamRecyclerViewAdapter adapter);

    void navigateToSquad(String teamId);
}
