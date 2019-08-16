package ng.sterling.footballfixtures.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;
import ng.sterling.footballfixtures.ui.BaseActivity;
import ng.sterling.footballfixtures.ui.main.adapters.MainFragmentAdapter;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;

public class MainActivity extends BaseActivity implements
        MainView,
        OnFragmentInteractionListener,
        TabLayout.OnTabSelectedListener{

    private final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mainPresenter.getMatchesAndCompetitions();


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
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void setResponse(MainResponseDto responseData) {
        viewpager.setAdapter(new MainFragmentAdapter(this, getSupportFragmentManager(), responseData));
        tabLayout.setupWithViewPager(viewpager);
        this.tabLayout.getTabAt(0).setIcon(R.drawable.soccer_24);
        this.tabLayout.getTabAt(1).setIcon(R.drawable.soccer_field);
        this.tabLayout.addOnTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                toolbar.setTitle("Today's Fixture");

                break;
            case 1:
                toolbar.setTitle("Competition");
                break;

        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
