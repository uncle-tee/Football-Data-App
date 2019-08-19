package ng.sterling.footballfixtures.ui.competitionDetail.fragments.competitionfixtures;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.sterling.footballfixtures.R;

public class CompetitionFixtureFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";



    public CompetitionFixtureFragment() {
        // Required empty public constructor
    }
    public static CompetitionFixtureFragment newInstance(String param1) {
        CompetitionFixtureFragment fragment = new CompetitionFixtureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fixture, container, false);
    }

}
