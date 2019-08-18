package ng.sterling.footballfixtures.ui.main.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.ui.main.adapters.viewHolders.MatchFixtureViewHolder;
import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.utils.DateTimeUtil;

/**
 * Author: Oluwatobi Adenekan
 * date:    13/08/2019
 **/

public class MatchFixtureRecylerViewAdapter extends RecyclerView.Adapter<MatchFixtureViewHolder> {

    Context context;

    List<Match> matches;


    public MatchFixtureRecylerViewAdapter(Context context, List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    @NonNull
    @Override
    public MatchFixtureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.match_fixture_fragment, viewGroup, false);
        return new MatchFixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchFixtureViewHolder matchFixtureViewHolder, int position) {
        Match match = matches.get(position);
        matchFixtureViewHolder.textViewAwayTeam.setText(match.getAwayTeam().getName());
        matchFixtureViewHolder.textViewHomeTeam.setText(match.getHomeTeam().getName());
        matchFixtureViewHolder.textViewMatchStatus.setText(match.getStatus().replace("_","-"));
        matchFixtureViewHolder.textViewHomeTeamScore.setText(match.getScore().getFullTime().getHomeTeam());
        matchFixtureViewHolder.textViewAwayTeamScore.setText(match.getScore().getFullTime().getAwayTeam());
        matchFixtureViewHolder.textViewMatchEndTime
                .setText(DateTimeUtil.format(match.getUtcDate(), "yyyy-MM-dd'T'HH:mm:ss'Z'", "HH:mm"));

    }

    @Override
    public int getItemCount() {
        return matches.size();
    }
}
