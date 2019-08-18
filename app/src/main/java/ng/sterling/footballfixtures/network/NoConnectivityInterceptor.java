package ng.sterling.footballfixtures.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import ng.sterling.footballfixtures.exceptions.NoConnectivityException;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Author: Oluwatobi Adenekan
 * date:    18/08/2019
 **/

/**
 * For every request the interceptor will check if internet is available else if it is not.
 * will throw a NoConnectivityException.
 */
public class NoConnectivityInterceptor implements Interceptor {

    public static String TAG = NoConnectivityInterceptor.class.getSimpleName();
    Context context;

    public NoConnectivityInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {


        if(!isInternetActive()){
            throw new NoConnectivityException();
        }else {
            return chain.proceed(chain.request());
        }

    }

    /**
     * Check for active internet connection
     *
     *
     * @return Boolean
     */
    private boolean isInternetActive() {
        ConnectivityManager conMgr = (ConnectivityManager) this.context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conMgr.getActiveNetworkInfo();

        return info != null && info.isConnected() && info.isAvailable();
    }
}
