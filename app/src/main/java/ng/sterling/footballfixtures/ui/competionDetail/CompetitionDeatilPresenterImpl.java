package ng.sterling.footballfixtures.ui.competionDetail;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.dto.response.CompetitionDetailResponse;
import ng.sterling.footballfixtures.dto.response.CompetitionStandingResponse;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;
import ng.sterling.footballfixtures.dto.response.TeamsResponse;
import ng.sterling.footballfixtures.model.ApiErorMessageEvent;
import ng.sterling.footballfixtures.model.ApiSubcriptionEvent;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;
import ng.sterling.footballfixtures.network.ApiCallBack;
import ng.sterling.footballfixtures.network.ApiClient;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class CompetitionDeatilPresenterImpl implements CompetitionDetailPresenter {


    public static final String TAG = CompetitionDeatilPresenterImpl.class.getSimpleName();
    ApiClient apiClient;
    Context context;
    CompetitionDetailView competitionDetailView;
    EventBus eventBus;


    @Inject
    public CompetitionDeatilPresenterImpl(ApiClient apiClient,
                                          Context context,
                                          CompetitionDetailView competitionDetailView,
                                          EventBus eventBus) {
        this.apiClient = apiClient;
        this.context = context;
        this.competitionDetailView = competitionDetailView;
        this.eventBus = eventBus;
    }


    private Observable<CompetitionStandingResponse> getCompetitionStanding(Long competitionId) {
        return apiClient.getApiService().getCompetitionStandings(competitionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    private Observable<TeamsResponse> getTeams(Long competitionId) {
        return apiClient
                .getApiService()
                .getTeams(competitionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    private Observable<CompetitionDetailResponse> getCompetitionStandingAndTeams(Long competitionId) {
        return Observable.zip(getCompetitionStanding(competitionId), getTeams(competitionId), new BiFunction<CompetitionStandingResponse, TeamsResponse, CompetitionDetailResponse>() {
            @Override
            public CompetitionDetailResponse apply(CompetitionStandingResponse competitionStandingResponse, TeamsResponse teamsResponse) throws Exception {
                return new CompetitionDetailResponse(teamsResponse, competitionStandingResponse);
            }
        });
    }


    @Override
    public void setCompetition(NameAndId competition) {
        getCompetitionStandingAndTeams(competition.getId()).subscribe(new ApiCallBack<CompetitionDetailResponse>());
    }

    @Subscribe
    public void onGetCompetionStandingAndTeamSuccess(ApiSuccessResponse<CompetitionDetailResponse> response) {
        competitionDetailView.data(response.getData());

    }

    @Subscribe
    public void onEventSubcriptionErrorResponse(ApiSubcriptionEvent event){
        competitionDetailView.showViewDistroyMessage(context.getResources().getString(R.string.subcription_paln_error_messsage));
    }

    @Subscribe
    public void OnErrorNetworkResponse(ApiErorMessageEvent response){
        competitionDetailView.showNetworkErrorMessage(response.getMessage());
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
