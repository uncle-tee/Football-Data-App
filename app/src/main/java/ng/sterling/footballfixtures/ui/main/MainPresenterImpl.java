package ng.sterling.footballfixtures.ui.main;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

public class MainPresenterImpl implements MainPresenter {
    public String test = "working code";
    MainView mainView;

    public MainPresenterImpl(MainView mainView) {

        this.mainView = mainView;
    }

    @Override
    public void showTestString() {
        mainView.showWorkingToast(test);
    }
}
