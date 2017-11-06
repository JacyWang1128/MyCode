package com.android.Project2048;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.Project2048.Game2048Layout;
import com.android.Project2048.Game2048Layout.OnGame2048Listener;

public class GameRoot extends Activity implements OnGame2048Listener
{
	private Game2048Layout mGame2048Layout;

	private TextView mScore;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gaming);

		mScore = (TextView) findViewById(R.id.id_score);
		mGame2048Layout = (Game2048Layout) findViewById(R.id.id_game2048);
		mGame2048Layout.setOnGame2048Listener(this);
		Button btRestart = (Button) findViewById(R.id.restart);
		btRestart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mGame2048Layout.restart();
			}
		});
	}

	@Override
	public void onScoreChange(int score)
	{
		mScore.setText("SCORE: " + score);
	}


	@Override
	public void onGameOver()
	{
		new AlertDialog.Builder(this).setTitle("GAME OVER")
				.setMessage("YOU HAVE GOT " + mScore.getText())
				.setPositiveButton("RESTART", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						mGame2048Layout.restart();
					}
				}).setNegativeButton("EXIT", new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						finish();
					}

				}).show();
	}

	private Builder setPostiveButton(String string,
			OnClickListener onClickListener) {
		// TODO Auto-generated method stub
		return null;
	}

}
