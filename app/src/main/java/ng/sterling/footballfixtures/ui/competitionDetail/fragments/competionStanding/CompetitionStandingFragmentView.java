package ng.sterling.footballfixtures.ui.competitionDetail.fragments.competionStanding;

import android.support.v7.widget.LinearLayoutManager;

import ng.sterling.footballfixtures.ui.competitionDetail.adapters.CompetitionStandingRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionStandingFragmentView {

    void setAdapterAndManager(LinearLayoutManager layoutManager, CompetitionStandingRecyclerViewAdapter adapter);



}
