package ng.sterling.footballfixtures.ui.squad.adapters.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.sterling.footballfixtures.R;

/**
 * Author: Oluwatobi Adenekan
 * date:    17/08/2019
 **/

public class SquadViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textView_index)
    public TextView textViewIndex;
    @BindView(R.id.textView_name)
    public TextView textViewName;
    @BindView(R.id.textView_position)
    public TextView textViewPosition;


    public SquadViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
