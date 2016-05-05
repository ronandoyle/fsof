package ie.nanorstudios.fsof.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ie.nanorstudios.fsof.GameTypeInterfance;
import ie.nanorstudios.fsof.R;
import ie.nanorstudios.fsof.fragments.RoundFragment;

/**
 * Created by Ronan on 28/04/2016.
 */
public class RoundActivity extends Activity {

    private RoundFragment mRoundFragment;

    private int mGameType;
    @BindView(R.id.iv_round_splash_view) ImageView mSplashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        ButterKnife.bind(this);
        extractGameType();
    }

    private void setupUI() {
        switch (mGameType) {
            case GameTypeInterfance.ALL:
                displayGameTypeSlashScreen(R.drawable.all_genres);
                break;
            case GameTypeInterfance.ACTION:
                // TODO: 28/04/2016 displayGameTypeSlashScreen
                break;
            case GameTypeInterfance.COMEDY:
                // TODO: 28/04/2016 displayGameTypeSlashScreen
                break;
            case GameTypeInterfance.ROMANCE:
                // TODO: 28/04/2016 displayGameTypeSlashScreen
                break;
            case GameTypeInterfance.SCIFI:
                // TODO: 28/04/2016 displayGameTypeSlashScreen
                break;
            default:
                break;
        }
        if (mRoundFragment != null) {
            mRoundFragment = RoundFragment.newInstance(mGameType);
        }
    }

    private void displayGameTypeSlashScreen(int resourceId) {
        mSplashView.setBackground(getDrawable(resourceId));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mSplashView.setVisibility(View.GONE);
    }

    private void extractGameType() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey("GAME_TYPE")) {
                mGameType = extras.getInt("GAME_TYPE");
                setupUI();
            }
        }
    }
}