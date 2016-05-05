package ie.nanorstudios.fsof.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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

    private static final String GAME_TYPE = "GameType";
    private static final String ROUND_COUNT = "RoundCount";
    private static final String LIVES = "Lives";
    public static String TAG = "RoundFragment";
    @BindView(R.id.tv_round_title) TextView mTextViewRoundTitle;
    private int mGameType = -1;

    public static RoundFragment newInstance(int lives, int roundCount, int gameType) {
        RoundFragment roundFragment = new RoundFragment();
        Bundle arguements = new Bundle();
        arguements.putInt(LIVES, lives);
        arguements.putInt(ROUND_COUNT, roundCount);
        arguements.putInt(GAME_TYPE, gameType);
        roundFragment.setArguments(arguements);
        return roundFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_round, container, false);
        ButterKnife.bind(this, view);
        extractGameType(getArguments());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        populateTitle();
    }

    private void extractGameType(Bundle arguments) {
        if (arguments != null && mTextViewRoundTitle != null) {
            mGameType = arguments.containsKey(GAME_TYPE) ? arguments.getInt(GAME_TYPE) : -1;
        }
    }

    private void populateTitle() {
        switch (mGameType) {
            case 0:
                mTextViewRoundTitle.setText("All Genres");
                break;
            case 1:
                mTextViewRoundTitle.setText("Action");
                break;
            case 2:
                mTextViewRoundTitle.setText("Comedy");
                break;
            case 3:
                mTextViewRoundTitle.setText("RomCom");
                break;
            case 4:
                mTextViewRoundTitle.setText("SCI FI");
                break;
            default:
                break;
        }

        SpannableString titleString = new SpannableString(mTextViewRoundTitle.getText());
        titleString.setSpan(new UnderlineSpan(), 0, titleString.length(), 0);
        mTextViewRoundTitle.setText(titleString);
    }
}