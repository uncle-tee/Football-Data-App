package ng.sterling.footballfixtures.ui.main.fragments.match;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.ui.main.adapters.CompetitionListRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.main.adapters.MatchFixtureRecylerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class MatchFragmentPresenterImpl implements MatchFragmentPresenter {


    Context context;
    MatchFragmentView matchFragmentView;

    List<Match> matches;

    @Inject
    public MatchFragmentPresenterImpl(Context context, MatchFragmentView matchFragmentView) {
        this.context = context;
        this.matchFragmentView = matchFragmentView;
    }

    @Override
    public void setMatches(List<Match> matches) {
        this.matches = matches;
        populateData();
    }

    private void populateData() {
        MatchFixtureRecylerViewAdapter adapter
                = new MatchFixtureRecylerViewAdapter(context, this.matches);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);

        matchFragmentView.setAdapterAndLayoutManager(adapter, layoutManager);
    }


}
