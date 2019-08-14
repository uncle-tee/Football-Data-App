package ng.sterling.footballfixtures.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import ng.sterling.footballfixtures.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Oluwatobi Adenekan
 * date:    10/08/2019
 **/

public class ApiClient {

    Context context;
    ApiService apiService;

    public ApiClient(Context context) {
        this.context = context;
        initialiseRetrofit();
    }

    private void initialiseRetrofit() {

        System.out.println("W e are testing here");
        Log.e(this.getClass().getSimpleName(), "initialiseRetrofit: " + "we are here" );
        String baseUrl = null;
        String url = context.getResources().getString(R.string.football_data_base_url);
        if (!url.endsWith("/")) {
            baseUrl = url.concat("/");
        }else {
            baseUrl = url;
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(AuthParamInterceptor.getAuthParamInterceptor(context))
                .addInterceptor(httpLoggingInterceptor)
                .build();


        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()));
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofitBuilder.baseUrl(baseUrl);
        retrofitBuilder.client(okHttpClient);
        apiService = retrofitBuilder.build().create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
