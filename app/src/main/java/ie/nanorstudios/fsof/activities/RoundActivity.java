package ie.nanorstudios.fsof.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
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
        // TODO: 28/04/2016 Create activity ui.

        if (savedInstanceState != null) {
            mGameType = savedInstanceState.getInt("GAME_TYPE");
            setupUI();
        }
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

}
