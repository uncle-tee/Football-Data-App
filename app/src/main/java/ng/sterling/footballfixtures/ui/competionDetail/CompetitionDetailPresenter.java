package ng.sterling.footballfixtures.ui.competionDetail;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface CompetitionDetailPresenter {
    void setCompetitionId(Long competitionDetail);

    void onDestroy();

    void onPause();

    void onResume();
}
