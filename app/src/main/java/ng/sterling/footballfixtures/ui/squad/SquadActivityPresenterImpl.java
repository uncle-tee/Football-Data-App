package ng.sterling.footballfixtures.ui.squad;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;
import ng.sterling.footballfixtures.network.ApiCallBack;
import ng.sterling.footballfixtures.network.ApiClient;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class SquadActivityPresenterImpl implements SquadActivityPresenter {

    Context context;
    ApiClient apiClient;
    SquadActivityView squadActivityView;
    EventBus eventBus;

    @Inject
    public SquadActivityPresenterImpl(Context context,
                                      ApiClient apiClient,
                                      SquadActivityView squadActivityView,
                                      EventBus eventBus) {
        this.context = context;
        this.apiClient = apiClient;
        this.squadActivityView = squadActivityView;
        this.eventBus = eventBus;
    }

    @Override
    public void getSquad(String squadId) {
        apiClient.getApiService()
                .getTeam(squadId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new ApiCallBack<TeamDto>());
    }


    @Subscribe
    public void onGetSquad(ApiSuccessResponse<TeamDto> teamResponse) {
        squadActivityView.disPlaySquad(teamResponse.getData());
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
