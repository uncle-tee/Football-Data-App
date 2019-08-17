package ng.sterling.footballfixtures.ui.squad;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface SquadActivityPresenter {

    void getSquad(String squadId);


    void onDestroy();

    void onPause();

    void onResume();
}

