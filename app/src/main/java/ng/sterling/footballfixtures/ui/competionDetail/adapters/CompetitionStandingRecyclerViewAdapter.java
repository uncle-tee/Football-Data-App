package ng.sterling.footballfixtures.ui.competionDetail.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.viewHolders.CompetitionStandingViewHolder;
import ng.sterling.footballfixtures.utils.glide.GlideSvgUtil;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionStandingRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionStandingViewHolder> {


    public static final String TAG = CompetitionStandingRecyclerViewAdapter.class.getSimpleName();

    Context context;

    List<CompetitionStandingsTableItemDto> standings;

    public CompetitionStandingRecyclerViewAdapter(Context context, List<CompetitionStandingsTableItemDto> tables) {
        this.context = context;
        this.standings = tables;
    }


    @NonNull
    @Override
    public CompetitionStandingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.competition_standing_fragment, viewGroup, false);

        return new CompetitionStandingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionStandingViewHolder competitionStandingViewHolder, int position) {
        CompetitionStandingsTableItemDto competitionStandingsTableItemDto = standings.get(position);


        String clubCrestUrl = competitionStandingsTableItemDto.getTeam().getCrestUrl();

        if (!TextUtils.isEmpty(clubCrestUrl)) {
            new GlideSvgUtil
                    .Builder(competitionStandingViewHolder.imageViewCrest, clubCrestUrl, this.context).build();
        }


        competitionStandingViewHolder.textViewPosition.setText(competitionStandingsTableItemDto.getPosition());
        competitionStandingViewHolder.textViewClubName.setText(competitionStandingsTableItemDto.getTeam().getName());
        competitionStandingViewHolder.textViewPoints.setText(competitionStandingsTableItemDto.getPoints());
        competitionStandingViewHolder.textViewGoalAgainst.setText(competitionStandingsTableItemDto.getGoalsAgainst());
        competitionStandingViewHolder.textViewGoalFor.setText(competitionStandingsTableItemDto.getGoalsFor());

    }

    @Override
    public int getItemCount() {
        return standings.size();
    }
}
