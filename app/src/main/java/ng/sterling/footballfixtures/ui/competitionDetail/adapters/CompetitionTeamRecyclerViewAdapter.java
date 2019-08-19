package ng.sterling.footballfixtures.ui.competitionDetail.adapters;

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
import ng.sterling.footballfixtures.ui.competitionDetail.adapters.viewHolders.CompetitionTeamViewHolder;
import ng.sterling.footballfixtures.utils.glide.GlideSvgUtil;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionTeamRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionTeamViewHolder> {

    Context context;
    List<TeamDto> teams;
    SetOnClickListener onClickListener;

    public CompetitionTeamRecyclerViewAdapter(Context context, List<TeamDto> teams, SetOnClickListener clickListener) {
        this.context = context;
        this.teams = teams;
        this.onClickListener = clickListener;
    }

    @NonNull
    @Override
    public CompetitionTeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.team_layout, viewGroup, false);

        return new CompetitionTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionTeamViewHolder competitionTeamViewHolder, final int position) {
        final TeamDto teamDto = teams.get(position);
        String crestUrl = teamDto.getCrestUrl();
        if (!TextUtils.isEmpty(crestUrl)) {
            new GlideSvgUtil.Builder(competitionTeamViewHolder.imageViewClubLogo, crestUrl, this.context).build();
        } else {
            competitionTeamViewHolder.imageViewClubLogo.setImageDrawable(context.getDrawable(R.drawable.ic_place));
        }
        competitionTeamViewHolder.textViewClubName.setText(teamDto.getName());

        competitionTeamViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(teamDto.getId().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public interface SetOnClickListener {
        void onClick(String teamId);
    }
}
