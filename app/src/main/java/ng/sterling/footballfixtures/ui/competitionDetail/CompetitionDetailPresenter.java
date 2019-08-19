package ng.sterling.footballfixtures.ui.competitionDetail;

import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface CompetitionDetailPresenter {
    void setCompetition(NameAndId competitionDetail);

    void onDestroy();

    void onPause();

    void onResume();
}
