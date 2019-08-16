package ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import ng.sterling.footballfixtures.R;
import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;
import ng.sterling.footballfixtures.ui.competionDetail.adapters.CompetitionStandingRecyclerViewAdapter;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;


public class CompetitionStandingFragment extends DaggerFragment implements CompetitionStandingFragmentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String COMPETITION_STANDING = "COMPETITION_STANDING";
    public static final String TAG = CompetitionStandingFragment.class.getSimpleName();


    List<CompetitionStandingsTableItemDto> competitionStanding;
    @BindView(R.id.recylerview_competition_standing)
    RecyclerView recylerviewCompetitionStanding;
    private OnFragmentInteractionListener mListener;

    @Inject
    CompetitionStandingFragmentPresenter competitionStandingFragmentPresenter;


    public static CompetitionStandingFragment newInstance(ArrayList<CompetitionStandingsTableItemDto> competitionStanding) {
        CompetitionStandingFragment fragment = new CompetitionStandingFragment();
        Bundle args = new Bundle();
        args.putSerializable(COMPETITION_STANDING, competitionStanding);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.competitionStanding = (List<CompetitionStandingsTableItemDto>) getArguments().getSerializable(COMPETITION_STANDING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competition_standing, container, false);
        ButterKnife.bind(this, view);
        competitionStandingFragmentPresenter.setCompetitionStanding(this.competitionStanding);
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
    public void setAdapterAndManager(LinearLayoutManager layoutManager, CompetitionStandingRecyclerViewAdapter adapter) {
        Log.e(TAG, "setAdapterAndManager: "+ "Adding adapters" );
        recylerviewCompetitionStanding.setAdapter(adapter);
        recylerviewCompetitionStanding.setLayoutManager(layoutManager);

        Log.e(TAG, "setAdapterAndManager: Item count" + recylerviewCompetitionStanding.getAdapter().getItemCount() ); ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
