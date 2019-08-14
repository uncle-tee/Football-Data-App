package ng.sterling.footballfixtures.ui.main;


/**
 * Author - Oluwatobi Adenekan
 * Date   - 12/08/2019
 **/


import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import dagger.Subcomponent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import ng.sterling.footballfixtures.dto.response.CompetitionResponse;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;
import ng.sterling.footballfixtures.dto.response.MatchResponse;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;
import ng.sterling.footballfixtures.network.ApiCallBack;
import ng.sterling.footballfixtures.network.ApiClient;


/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

public class MainPresenterImpl implements MainPresenter {

    private final String TAG = MainPresenterImpl.class.getSimpleName();
    public ApiClient apiClient;

    private MainView mainView;
    EventBus eventBus;


    @Inject
    public MainPresenterImpl(MainView mainView, ApiClient apiClient) {
        this.apiClient = apiClient;
        this.mainView = mainView;
    }

    private Observable<MatchResponse> fetchMatches() {
        return apiClient.getApiService()
                .getMatches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<CompetitionResponse> fetchCompetitions() {
        return apiClient.getApiService().getCompetions().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<MainResponseDto> fetchMatchesAndCompetitions() {
        return Observable.zip(fetchMatches(), fetchCompetitions(), new BiFunction<MatchResponse, CompetitionResponse, MainResponseDto>() {
            @Override
            public MainResponseDto apply(MatchResponse matchResponse, CompetitionResponse competitionResponse) throws Exception {
                return new MainResponseDto(matchResponse, competitionResponse);
            }
        });
    }

    public void getMatchesAndCompetitions() {
        fetchMatchesAndCompetitions().subscribe(new ApiCallBack<MainResponseDto>());
    }


    /**
     * This method is currently subcribing to the event bus, and will only be called when there is a positive network call.
     * @param response
     */
    @Subscribe
    public void onGetMatchAndCompetion(ApiSuccessResponse<MainResponseDto> response) {
        mainView.showMatchAndCompetitions(response.getData());

    }


    @Override
    public void onPause() {

        unRegisterFromEventBus();

    }

    @Override
    public void onResume() {

        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onDestroy() {

        unRegisterFromEventBus();

    }

    private void unRegisterFromEventBus() {
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }
}
