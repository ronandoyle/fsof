package ie.nanorstudios.fsof.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import ie.nanorstudios.fsof.GameTypeInterfance;
import ie.nanorstudios.fsof.R;

import butterknife.OnClick;

public class MainActivity extends Activity implements GameTypeInterfance {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
		setupTypeface();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupTypeface() {
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/SF Hollywood Hills.ttf");
	}

    @OnClick(R.id.btn_all)
    public void startAllGame() {
        Intent startGameIntent = new Intent(this, RoundActivity.class);
        startGameIntent.putExtra("GAME_TYPE", GameTypeInterfance.ALL);
        startActivity(startGameIntent);
    }

    @OnClick(R.id.btn_action)
    protected void startActionGame() {
        Intent startGameIntent = new Intent(this, RoundActivity.class);
        startGameIntent.putExtra("GAME_TYPE", GameTypeInterfance.ACTION);
        startActivity(startGameIntent);
    }

    @OnClick(R.id.btn_comedy)
    protected void startComedyGame() {
        Intent startGameIntent = new Intent(this, RoundActivity.class);
        startGameIntent.putExtra("GAME_TYPE", GameTypeInterfance.COMEDY);
        startActivity(startGameIntent);
    }

    @OnClick(R.id.btn_romance)
    protected void startRomanceGame() {
        Intent startGameIntent = new Intent(this, RoundActivity.class);
        startGameIntent.putExtra("GAME_TYPE", GameTypeInterfance.ROMANCE);
        startActivity(startGameIntent);
    }

    @OnClick(R.id.btn_scifi)
    protected void startSciFiGame() {
        Intent startGameIntent = new Intent(this, RoundActivity.class);
        startGameIntent.putExtra("GAME_TYPE", GameTypeInterfance.SCIFI);
        startActivity(startGameIntent);
    }
}
