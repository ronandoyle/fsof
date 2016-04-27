package com.tha.fifteensecondsoffame;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Display;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.*;

public class AnswerScreen extends Activity {
	
	Typeface tf;
	TextView header;
	TextView word;
	SpannableString content;
	SpannableString guessContent;
	ArrayList<String> wordArray = new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answer);
		
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		
		tf = Typeface.createFromAsset(getAssets(),
                "fonts/SF Hollywood Hills.ttf");
		
		content = new SpannableString("Answer");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        
        guessContent = new SpannableString("The Lord of The Rings");
        guessContent.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		
		header = (TextView) findViewById(R.id.header);
		header.setTypeface(tf);
		header.setText(content);
		header.setTextColor(Color.WHITE);
		header.setWidth((int) (width/1.5));
		
		Pattern pattern = Pattern.compile("(\\w)(\\s+)");
		String newString = guessContent.toString();
		
		String[] guessArray = pattern.split(newString);
		for (int x = 0; x < guessArray.length; x++) {
			System.out.println("ARRAY " + guessArray[x]);
		}
		
		
		word = (TextView) findViewById(R.id.guess);
		word.setTypeface(tf);
		word.setText(guessContent);
		word.setTextColor(Color.WHITE);
		word.setWidth((int) (width/1.5));
		
		
		
		
	}

}
