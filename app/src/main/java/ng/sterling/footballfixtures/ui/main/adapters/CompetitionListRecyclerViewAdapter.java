package ng.sterling.footballfixtures.ui.main.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.ui.main.adapters.viewHolders.CompetitionViewHolder;
import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    13/08/2019
 **/

public class CompetitionListRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionViewHolder> {

    public static final String TAG = CompetitionListRecyclerViewAdapter.class.getSimpleName();
    List<NameAndId> competitions;
    Context context;

    ClickListener clickListener;

    public CompetitionListRecyclerViewAdapter(Context context, List<NameAndId> competitions, ClickListener clickListener) {
        Log.e(TAG, "CompetitionListRecyclerViewAdapter: " + new Gson().toJson(competitions));
        this.competitions = competitions;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CompetitionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.competitions, viewGroup, false);
        return new CompetitionViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionViewHolder competitionViewHolder, final int position) {

        NameAndId competition = competitions.get(position);

        competitionViewHolder.textViewCompetitionName
                .setText(competition.getName());

        competitionViewHolder.textViewCompetitionName
                .setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_right_grey, 0);

        competitionViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClicked(competitions.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }


    public interface ClickListener {
        void onItemClicked(Long competitionId);
    }
}
