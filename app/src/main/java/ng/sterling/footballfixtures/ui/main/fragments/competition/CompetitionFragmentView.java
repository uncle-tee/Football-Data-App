package ng.sterling.footballfixtures.ui.main.fragments.competition;

import android.support.v7.widget.LinearLayoutManager;

import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.ui.main.adapters.CompetitionListRecyclerViewAdapter;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface CompetitionFragmentView {

    void setAdapterAndLayoutManager(CompetitionListRecyclerViewAdapter adapter, LinearLayoutManager layoutManager);

    void navigateToCompetitionDetail(NameAndId competition);
}
