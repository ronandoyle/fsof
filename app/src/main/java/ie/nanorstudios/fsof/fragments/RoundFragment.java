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

import java.util.Timer;
import java.util.TimerTask;

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
    @BindView(R.id.tv_first_name) TextView mTextViewFirstName;
    @BindView(R.id.tv_second_name) TextView mTextViewSecondName;
    @BindView(R.id.tv_timer) TextView mTextViewTimer;
    TimerTask timer = new TimerTask() {
        int counter = 3;

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (counter >= 1) {
                        mTextViewTimer.setText(Integer.toString(counter));
                    }
                    counter--;
                }
            });
            if (counter < 1) {
                timer.cancel();
                // TODO: 05/05/2016 Start the answer fragment...
            }
        }
    };
    private int mGameType = -1;
    private int mCounter;

    public static RoundFragment newInstance(int lives, int roundCount, int gameType) {
        RoundFragment roundFragment = new RoundFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(LIVES, lives);
        arguments.putInt(ROUND_COUNT, roundCount);
        arguments.putInt(GAME_TYPE, gameType);
        roundFragment.setArguments(arguments);
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
        // TODO: 05/05/2016 Animate in name fields before starting the timer.
        populateTitle();
        startTimer();
    }

    private void extractGameType(Bundle arguments) {
        if (arguments != null) {
            mGameType = arguments.containsKey(GAME_TYPE) ? arguments.getInt(GAME_TYPE) : -1;
        }
    }

    private void populateTitle() {
        if (mTextViewRoundTitle == null) {
            return;
        }
        SpannableString titleString =
                new SpannableString(String.format(getString(R.string.round_title), mCounter));
        titleString.setSpan(new UnderlineSpan(), 0, titleString.length(), 0);
        mTextViewRoundTitle.setText(titleString);
    }

    private void startTimer() {
        new Timer().scheduleAtFixedRate(timer, 0, 1000);
    }
}