package ng.sterling.footballfixtures.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger.android.support.DaggerAppCompatActivity;
import ng.sterling.footballfixtures.di.DaggerAppComponent;


/**
 * Author: Oluwatobi Adenekan
 * date:    13/08/2019
 **/

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
