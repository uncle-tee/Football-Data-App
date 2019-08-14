package ng.sterling.footballfixtures.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;
import ng.sterling.footballfixtures.network.ApiClient;
import ng.sterling.footballfixtures.ui.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    private final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.getMatchesAndCompetitions();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        mainPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }


    @Override
    public void showMatchAndCompetitions(MainResponseDto matchAndCompetition) {
        Log.e(TAG, "showMatchAndCompetitions: " + new Gson().toJson(matchAndCompetition));
    }
}
