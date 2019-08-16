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

public class CompetitionTeamViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView_club_logo)
    public ImageView imageViewClubLogo;
    @BindView(R.id.textView_club_name)
    public TextView textViewClubName;

    public CompetitionTeamViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
