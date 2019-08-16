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
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.viewHolders.CompetitionStandingViewHolder;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.viewHolders.CompetitionTeamViewHolder;
import ng.sterling.footballfixtures.utils.glide.GlideSvgUtil;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionTeamRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionTeamViewHolder> {

    Context context;
    List<TeamDto> teams;

    public CompetitionTeamRecyclerViewAdapter(Context context, List<TeamDto> teams) {
        this.context = context;
        this.teams = teams;
    }

    @NonNull
    @Override
    public CompetitionTeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.team_layout, viewGroup, false);

        return new CompetitionTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionTeamViewHolder competitionStandingViewHolder, int position) {
        TeamDto teamDto = teams.get(position);
        String crestUrl = teamDto.getCrestUrl();
        if (!TextUtils.isEmpty(crestUrl)) {
            new GlideSvgUtil.Builder(competitionStandingViewHolder.imageViewClubLogo,crestUrl, this.context).build();
        }
        competitionStandingViewHolder.textViewClubName.setText(teamDto.getName());

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}