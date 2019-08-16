package ng.sterling.footballfixtures.ui.main.fragments.competition;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface CompetitionFragmentPresenter {

    void setCompetitions(List<NameAndId> competitions);

}
