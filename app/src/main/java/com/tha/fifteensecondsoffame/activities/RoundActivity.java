package com.tha.fifteensecondsoffame.activities;

import android.app.Activity;
import android.os.Bundle;

import com.tha.fifteensecondsoffame.GameTypeInterfance;

/**
 * Created by Ronan on 28/04/2016.
 */
public class RoundActivity extends Activity {

    private int mGameType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 28/04/2016 Create activity ui.

        if (savedInstanceState != null) {
            mGameType = savedInstanceState.getInt("GAME_TYPE");
            displayGameTypeSlashScreen();
        }
    }

    private void displayGameTypeSlashScreen() {
        switch (mGameType) {
            // TODO: 28/04/2016 Show view with relevant picture, then load show and populate a round.
            case GameTypeInterfance.ALL:
                break;
            case GameTypeInterfance.ACTION:
                break;
            case GameTypeInterfance.COMEDY:
                break;
            case GameTypeInterfance.ROMANCE:
                break;
            case GameTypeInterfance.SCIFI:
                break;
            default:
                break;
        }
    }
}
