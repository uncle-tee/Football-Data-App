package ng.sterling.footballfixtures.ui.main.fragments.match;

import android.content.Context;
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
import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.ui.main.adapters.MatchFixtureRecylerViewAdapter;
import ng.sterling.footballfixtures.ui.main.listeners.OnFragmentInteractionListener;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class MatchFragment extends DaggerFragment implements MatchFragmentView {

    private static final String MATCH_ARG = "MATCH_ARG";
    @BindView(R.id.match_recyler_view)
    RecyclerView matchFixtureRecyclerView;

    @Inject
    MatchFragmentPresenter matchFragmentPresenter;
    @Inject
    RecyclerView.ItemDecoration lineDivider;

    private List<Match> matches;

    private OnFragmentInteractionListener mListener;

    public MatchFragment() {
        // Required empty public constructor
    }

    public static MatchFragment newInstance(ArrayList<Match> matches) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putSerializable(MATCH_ARG, matches);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            matches = (List<Match>) getArguments().getSerializable(MATCH_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_match_fixture, container, false);
        ButterKnife.bind(this, view);
        matchFragmentPresenter.setMatches(this.matches);

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
    public void setAdapterAndLayoutManager(MatchFixtureRecylerViewAdapter adapter,
                                           LinearLayoutManager layoutManager) {
        matchFixtureRecyclerView.setLayoutManager(layoutManager);
        matchFixtureRecyclerView.setAdapter(adapter);
        matchFixtureRecyclerView.getAdapter().notifyDataSetChanged();
        matchFixtureRecyclerView.addItemDecoration(lineDivider);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
