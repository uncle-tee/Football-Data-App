package ng.sterling.footballfixtures.ui.competionDetail;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.CompetitionDetailResponse;
import ng.sterling.footballfixtures.ui.BaseActivity;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionDetailDetailFragmentPagerAdapter;
import ng.sterling.footballfixtures.ui.main.fragments.competition.CompetitionFragment;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;

/**
 * Author - Oluwatobi Adenekan
 * Date   - 15/08/2019
 **/


public class CompetitionDetailActivity extends BaseActivity implements CompetitionDetailView, OnFragmentInteractionListener {

    public static final String TAG = CompetitionDetailActivity.class.getSimpleName();
    @Inject
    CompetitionDetailPresenter competitionDetailPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout_competion_details)
    TabLayout tabLayout2;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competion_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        final long competitionId = getIntent().getLongExtra(CompetitionFragment.COMPETITION_ARG, -1);
        competitionDetailPresenter.setCompetitionId(competitionId);


    }


    @Override
    protected void onResume() {
        super.onResume();
        competitionDetailPresenter.onResume();
    }


    @Override
    protected void onPause() {
        competitionDetailPresenter.onPause();
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        competitionDetailPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void data(CompetitionDetailResponse data) {
        Log.e(TAG, "data: " + "Settings the data");
        viewPager.setAdapter(new CompetitionDetailDetailFragmentPagerAdapter(getSupportFragmentManager(), this, data));
        tabLayout2.setupWithViewPager(viewPager);
        tabLayout2.getTabAt(0).setText("Table");
        tabLayout2.getTabAt(1).setText("Fixtures");
        tabLayout2.getTabAt(2).setText("Teams");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
