package ng.sterling.footballfixtures.ui.squad;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.BaseActivity;
import ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam.CompetitionTeamFragment;
import ng.sterling.footballfixtures.ui.squad.adapters.SquadRecyclerViewAdapter;
import ng.sterling.footballfixtures.utils.glide.GlideSvgUtil;

public class SquadActivity extends BaseActivity implements SquadActivityView {


    @Inject
    SquadActivityPresenter squadActivityPresenter;
    @Inject
    RecyclerView.ItemDecoration dividerItemDecorator;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView_team_image)
    ImageView imageViewTeamImage;
    @BindView(R.id.recyclerview_squad_list)
    RecyclerView recyclerviewSquadList;
    @BindView(R.id.toolbar_title)
    TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad);
        ButterKnife.bind(this);
        toolBarTitle.setText("Loading...");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String squadId = getIntent().getStringExtra(CompetitionTeamFragment.TEAM_ID);
        squadActivityPresenter.getSquad(squadId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        squadActivityPresenter.onResume();
    }

    @Override
    protected void onPause() {
        squadActivityPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        squadActivityPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void disPlaySquad(TeamDto team) {

        toolBarTitle.setText(team.getName());
        if (!TextUtils.isEmpty(team.getCrestUrl())) {
            new GlideSvgUtil.Builder(imageViewTeamImage, team.getCrestUrl(), this).build();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerviewSquadList.setLayoutManager(linearLayoutManager);
        recyclerviewSquadList.setAdapter(new SquadRecyclerViewAdapter(this, team.getSquad()));
        recyclerviewSquadList.addItemDecoration(dividerItemDecorator);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
