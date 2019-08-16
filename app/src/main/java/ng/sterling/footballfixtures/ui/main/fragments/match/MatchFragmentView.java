package ng.sterling.footballfixtures.ui.main.fragments.match;

import android.support.v7.widget.LinearLayoutManager;

import ng.sterling.footballfixtures.ui.main.adapters.CompetitionListRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.main.adapters.MatchFixtureRecylerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface MatchFragmentView {


    void setAdapterAndLayoutManager(MatchFixtureRecylerViewAdapter adapter, LinearLayoutManager layoutManager);
}
