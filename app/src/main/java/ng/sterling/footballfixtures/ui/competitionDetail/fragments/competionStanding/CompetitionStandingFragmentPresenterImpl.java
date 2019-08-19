package ng.sterling.footballfixtures.ui.competitionDetail.fragments.competionStanding;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;
import ng.sterling.footballfixtures.ui.competitionDetail.adapters.CompetitionStandingRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionStandingFragmentPresenterImpl implements CompetitionStandingFragmentPresenter {

    Context context;
    CompetitionStandingFragmentView competitionStandingFragmentView;
    List<CompetitionStandingsTableItemDto> competitionStanding;

    public static final String TAG = CompetitionStandingFragmentPresenterImpl.class.getSimpleName();

    @Inject
    public CompetitionStandingFragmentPresenterImpl(Context context, CompetitionStandingFragmentView competitionStandingFragmentView) {
        this.context = context;
        this.competitionStandingFragmentView = competitionStandingFragmentView;
    }

    @Override
    public void setCompetitionStanding(List<CompetitionStandingsTableItemDto> competitionStanding) {
        this.competitionStanding = competitionStanding;

        provideAdapters();
    }


    private void provideAdapters() {

        CompetitionStandingRecyclerViewAdapter adapter = new CompetitionStandingRecyclerViewAdapter(this.context, this.competitionStanding);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        competitionStandingFragmentView.setAdapterAndManager(linearLayoutManager, adapter);

    }
}
