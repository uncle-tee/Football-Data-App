package ng.sterling.footballfixtures.network;


import android.content.Context;

import java.io.IOException;

import ng.sterling.footballfixtures.BuildConfig;
import ng.sterling.footballfixtures.R;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthParamInterceptor {


    static Interceptor getAuthParamInterceptor(final Context context) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                Headers headerCopy = original.headers();
                Headers.Builder headerBuilder = headerCopy.newBuilder();
                headerBuilder.add(context.getString(R.string.football_data_header_key), BuildConfig.footbal_auth_key);
                Headers headers = headerBuilder.build();
                Request.Builder copyRequestBuilder = original.newBuilder();
                copyRequestBuilder.headers(headers);

                Request newRequest = copyRequestBuilder.build();

                return chain.proceed(newRequest);
            }
        };
    }
}
