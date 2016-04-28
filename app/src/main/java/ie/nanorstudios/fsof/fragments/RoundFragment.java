package ie.nanorstudios.fsof.fragments;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by Ronan on 28/04/2016.
 */
public class RoundFragment extends Fragment {

    public static RoundFragment newInstance(int gameType) {
        RoundFragment roundFragment = new RoundFragment();
        Bundle arguements = new Bundle();
        arguements.putInt("GameType", gameType);
        roundFragment.setArguments(arguements);
        return roundFragment;
    }


    // TODO: 28/04/2016 Setup usual fragment stuff.
    
}
