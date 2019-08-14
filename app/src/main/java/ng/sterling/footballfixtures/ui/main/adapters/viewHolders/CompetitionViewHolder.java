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

public class CompetitionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textView_competition_name)
    public TextView textViewCompetitionName;


    public CompetitionViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
