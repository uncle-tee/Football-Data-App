package ng.sterling.footballfixtures.ui.main;

import javax.inject.Inject;

import ng.sterling.footballfixtures.network.ApiService;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

public interface MainPresenter {



    void getMatchesAndCompetitions();

    void onDestroy();

    void onPause();

    void onResume();
}
