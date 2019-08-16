package ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding;

import android.support.v7.widget.LinearLayoutManager;

import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionStandingRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionStandingFragmentView {

    void setAdapterAndManager(LinearLayoutManager layoutManager, CompetitionStandingRecyclerViewAdapter adapter);



}
