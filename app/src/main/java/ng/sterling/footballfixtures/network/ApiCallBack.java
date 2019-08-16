package ng.sterling.footballfixtures.network;

/**
Author - Oluwatobi Adenekan
Date   - 12/08/2019
**/




import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ng.sterling.footballfixtures.dto.response.ApiResponse;
import ng.sterling.footballfixtures.model.ApiSuccessResponse;


public class ApiCallBack<T extends ApiResponse>  implements Observer<T> {


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

        e.printStackTrace();
        Log.e(TAG, "onError:  "+e.getMessage() );
    }

    @Override
    public void onComplete() {

        Log.e(TAG, "onComplete: " + "Already done with the on complete" );
    }
}
