package ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam;
/**
 * Author - Oluwatobi Adenekan
 * Date   - 16/08/2019
 **/


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionTeamRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;
import ng.sterling.footballfixtures.ui.squad.SquadActivity;


public class CompetitionTeamFragment extends DaggerFragment implements CompetitionTeamView {

    public static final String TEAM_ID = "TEAM_ID";
    private static final String COMPETITION_TEAM = "COMPETITION_TEAM";


    // TODO: Rename and change types of parameters
    List<TeamDto> teams;
    @BindView(R.id.recycler_view_team_list)
    RecyclerView recyclerViewTeamList;

    private OnFragmentInteractionListener mListener;

    @Inject
    CompetitionTeamFragmentPresenter competitionTeamFragmentPresenter;

    public static CompetitionTeamFragment newInstance(ArrayList<TeamDto> teams) {
        CompetitionTeamFragment fragment = new CompetitionTeamFragment();
        Bundle args = new Bundle();
        args.putSerializable(COMPETITION_TEAM, teams);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            teams = (ArrayList<TeamDto>) getArguments().getSerializable(COMPETITION_TEAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_competition_team, container, false);
        ButterKnife.bind(this, view);
        competitionTeamFragmentPresenter.setCompetitionTeam(this.teams);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void setAdapterAndManager(GridLayoutManager layoutManager, CompetitionTeamRecyclerViewAdapter adapter) {
        recyclerViewTeamList.setAdapter(adapter);
        recyclerViewTeamList.setLayoutManager(layoutManager);

    }

    @Override
    public void navigateToSquad(String teamId) {

        Intent intent = new Intent(CompetitionTeamFragment.this.getActivity(), SquadActivity.class);
        intent.putExtra(TEAM_ID, teamId);
        startActivity(intent);
    }


}
