package com.tha.fifteensecondsoffame.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.tha.fifteensecondsoffame.GameTypeInterfance;
import com.tha.fifteensecondsoffame.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends Activity implements GameTypeInterfance {

	@BindView(R.id.pickagenre) TextView tvPickAGenre;
	@BindView(R.id.iv_stars_footer) ImageView ivStars;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
    protected void startAllGame() {
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
