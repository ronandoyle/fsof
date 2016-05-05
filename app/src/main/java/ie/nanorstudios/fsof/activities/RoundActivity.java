package ie.nanorstudios.fsof.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;

import butterknife.ButterKnife;
import ie.nanorstudios.fsof.R;
import ie.nanorstudios.fsof.fragments.RoundFragment;

/**
 * Created by Ronan on 28/04/2016.
 */
public class RoundActivity extends Activity {

    public static final String EXTRA_ROUND_COUNTER = "ExtraRoundCounter";
    public static final String EXTRA_LIVES = "ExtraLives";

    private RoundFragment mRoundFragment;

    private int mRoundCounter = 1;
    private int mGameType;
    private int mLives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        ButterKnife.bind(this);
        extractGameType();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_ROUND_COUNTER, mRoundCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle inState) {
        super.onRestoreInstanceState(inState);
        mRoundCounter = inState.getInt(EXTRA_ROUND_COUNTER);
    }

    private void addFragment() {
        if (mRoundFragment == null) {
            mRoundFragment = RoundFragment.newInstance(mLives, mRoundCounter, mGameType);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout, mRoundFragment, RoundFragment.TAG).commit();
        }
    }

    private void extractGameType() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey("GAME_TYPE")) {
                mGameType = extras.getInt("GAME_TYPE");
                addFragment();
            }
        }
    }

    public void checkAnswer() {
        // TODO: 05/05/2016 increment round count or decrement life.
    }
}