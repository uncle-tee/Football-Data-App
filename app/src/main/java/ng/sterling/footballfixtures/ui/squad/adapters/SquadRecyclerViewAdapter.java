package ng.sterling.footballfixtures.ui.squad.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.SquadDto;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.squad.adapters.viewHolder.SquadViewHolder;

/**
 * Author: Oluwatobi Adenekan
 * date:    17/08/2019
 **/

public class SquadRecyclerViewAdapter extends RecyclerView.Adapter<SquadViewHolder> {

    Context context;
    List<SquadDto> squad;

    public SquadRecyclerViewAdapter(Context context, List<SquadDto> squad) {
        this.context = context;
        this.squad = squad;
    }

    @NonNull
    @Override
    public SquadViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.squad_list, viewGroup, false);

        return new SquadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SquadViewHolder squadViewHolder, int position) {

        SquadDto teamDto = squad.get(position);
        int index = position + 1;
        squadViewHolder.textViewIndex.setText(String.valueOf(index));
        squadViewHolder.textViewName.setText(teamDto.getName());
        if(!TextUtils.isEmpty(teamDto.getPosition())){
            squadViewHolder.textViewPosition.setText(teamDto.getPosition());
        }else {
            squadViewHolder.textViewPosition.setText(teamDto.getRole().replace("_", " "));
        }

    }

    @Override
    public int getItemCount() {
        return squad.size();
    }
}
