package ng.sterling.footballfixtures.ui.competionDetail.adapters.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.sterling.footballfixtures.R;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionStandingViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.textView_position)
    public TextView textViewPosition;
    @BindView(R.id.imageView_crest)
    public ImageView imageViewCrest;
    @BindView(R.id.textView_club_name)
    public TextView textViewClubName;
    @BindView(R.id.textView_points)
    public TextView textViewPoints;
    @BindView(R.id.textView_goal_against)
    public TextView textViewGoalAgainst;
    @BindView(R.id.textView_goal_for)
    public TextView textViewGoalFor;

    public CompetitionStandingViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
