package ie.nanorstudios.fsof.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ie.nanorstudios.fsof.R;

/**
 * Created by Ronan on 28/04/2016.
 */
public class RoundFragment extends Fragment {

    @BindView(R.id.tv_round_title) TextView mTextViewRoundTitle;

    public static RoundFragment newInstance(int gameType) {
        RoundFragment roundFragment = new RoundFragment();
        Bundle arguements = new Bundle();
        arguements.putInt("GameType", gameType);
        roundFragment.setArguments(arguements);
        return roundFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_round, container, false);
        ButterKnife.bind(this, view);
        populateTitle(savedInstanceState);
        return view;
    }

    private void populateTitle(Bundle savedInstanceState) {
        if (savedInstanceState != null  && mTextViewRoundTitle != null) {
            if (savedInstanceState.containsKey("GameType")) {
                mTextViewRoundTitle.setText(savedInstanceState.getInt("GameType"));
            }
        }
    }
}