package ng.sterling.footballfixtures.ui.main.adapters.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.sterling.footballfixtures.R;

/**
 * Author: Oluwatobi Adenekan
 * date:    13/08/2019
 **/

public class MatchFixtureViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textView_match_status)
    public TextView textViewMatchStatus;
    @BindView(R.id.textView_match_end_time)
    public TextView textViewMatchEndTime;
    @BindView(R.id.textView_home_team)
    public TextView textViewHomeTeam;
    @BindView(R.id.textView_home_team_score)
    public TextView textViewHomeTeamScore;
    @BindView(R.id.textView_away_team)
    public TextView textViewAwayTeam;
    @BindView(R.id.textView_away_team_score)
    public TextView textViewAwayTeamScore;

    public MatchFixtureViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
