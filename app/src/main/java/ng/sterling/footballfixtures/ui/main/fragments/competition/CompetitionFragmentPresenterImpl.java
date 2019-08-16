package ng.sterling.footballfixtures.ui.main.fragments.competition;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.ui.main.adapters.CompetitionListRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class CompetitionFragmentPresenterImpl implements
        CompetitionFragmentPresenter,
        CompetitionListRecyclerViewAdapter.ClickListener {

    private static final String TAG = CompetitionFragmentPresenterImpl.class.getSimpleName();
    private List<NameAndId> competitions;


    Context context;


    CompetitionFragmentView competitionFragmentView;


    @Inject
    public CompetitionFragmentPresenterImpl(Context context,
                                            CompetitionFragmentView competitionFragmentView) {
        this.context = context;
        this.competitionFragmentView = competitionFragmentView;
    }

    @Override
    public void setCompetitions(List<NameAndId> competitions) {
        this.competitions = competitions;
        populateData();
    }


    private void populateData() {
        CompetitionListRecyclerViewAdapter adapter
                = new CompetitionListRecyclerViewAdapter(context, this.competitions, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);

        competitionFragmentView.setAdapterAndLayoutManager(adapter, layoutManager);
    }

    @Override
    public void onItemClicked(Long competitionId) {
        competitionFragmentView.navigateToCompetitionDetail(competitionId);
    }
}
