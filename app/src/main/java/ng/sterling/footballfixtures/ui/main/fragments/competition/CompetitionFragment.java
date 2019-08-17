package ng.sterling.footballfixtures.ui.main.fragments.competition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.ui.competionDetail.CompetitionDetailActivity;
import ng.sterling.footballfixtures.ui.main.adapters.CompetitionListRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;

public class CompetitionFragment extends DaggerFragment implements CompetitionFragmentView {

    public static final String COMPETITION_ARG = "COMPETITION_ARG";
    @Inject
    CompetitionFragmentPresenter competitionFragmentPresenter;

    @Inject
    RecyclerView.ItemDecoration recyclerViewItemDivider;

    List<NameAndId> competions;


    private static final String ARG_COMPETITIONS = "COMPETITIONS";

    @BindView(R.id.recycler_view_competion_list)
    RecyclerView recyclerViewCompetionList;



    private OnFragmentInteractionListener mListener;


    public static CompetitionFragment newInstance(ArrayList<NameAndId> competitions) {
        CompetitionFragment fragment = new CompetitionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_COMPETITIONS, competitions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ArrayList<NameAndId> competitions = (ArrayList<NameAndId>) getArguments().getSerializable(ARG_COMPETITIONS);
            this.competions = competitions;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competion, container, false);
        ButterKnife.bind(this, view);
        competitionFragmentPresenter.setCompetitions(this.competions);
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
    public void setAdapterAndLayoutManager(CompetitionListRecyclerViewAdapter adapter, LinearLayoutManager layoutManager) {
        recyclerViewCompetionList.setLayoutManager(layoutManager);
        recyclerViewCompetionList.setAdapter(adapter);
        recyclerViewCompetionList.addItemDecoration(recyclerViewItemDivider);

    }

    @Override
    public void navigateToCompetitionDetail(Long competitionId) {
        CompetitionFragment competitionFragment = CompetitionFragment.this;
        Intent intent = new Intent(competitionFragment.getActivity(), CompetitionDetailActivity.class);
        intent.putExtra(COMPETITION_ARG, competitionId);
        startActivity(intent);
        competitionFragment.getActivity().overridePendingTransition(0, 0);


    }
}
