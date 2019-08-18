package ng.sterling.footballfixtures.network;

/**
 * Author - Oluwatobi Adenekan
 * Date   - 12/08/2019
 **/


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ng.sterling.footballfixtures.FootBallFixture;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.ApiResponse;
import ng.sterling.footballfixtures.model.ApiErorMessageEvent;
import ng.sterling.footballfixtures.model.ApiSubcriptionEvent;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;
import retrofit2.HttpException;


public class ApiCallBack<T extends ApiResponse> implements Observer<T> {


    public static String TAG = ApiCallBack.class.getSimpleName();


    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T t) {
        ApiSuccessResponse<T> tApiSuccessResponse = new ApiSuccessResponse<T>().setData(t);
        Log.e(TAG, "onNext: ");
        EventBus.getDefault().post(tApiSuccessResponse);
    }

    @Override
    public void onError(Throwable e) {
        ApiErorMessageEvent event = null;
        if (e instanceof HttpException) {
            if (((HttpException) e).code() == 403) {
                Log.e(TAG, "onError: " + ((HttpException) e).code() );
                EventBus.getDefault().post(new ApiSubcriptionEvent());
            }
        } else {
            EventBus.getDefault().post(new ApiErorMessageEvent(e.getMessage()));
        }

    }

    @Override
    public void onComplete() {

        Log.e(TAG, "onComplete: " + "Already done with the on complete");
    }
}
