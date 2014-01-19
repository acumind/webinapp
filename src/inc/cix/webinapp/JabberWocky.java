package inc.cix.webinapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

public class JabberWocky extends Activity {

	private static final String TAG = "JabberWocky";
	private WebView contentWebView;
	private MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Logger.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_jabberwocky);

		contentWebView = (WebView) findViewById(R.id.contentWebView);
		contentWebView.getSettings().setBuiltInZoomControls(true);
		contentWebView.loadUrl("file:///android_asset/webcontent/jabberwocky.html");

		player = MediaPlayer.create(this,R.raw.audio_clip);		
		player.setLooping(true);
	
	}

	@Override
	protected void onPause() {
		Logger.d(TAG, "onPause");
		player.pause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		Logger.d(TAG, "onResume");		
		player.start();
		super.onResume();
	}

	
	@Override
	protected void onDestroy() {
		Logger.d(TAG, "onDestroy");
		contentWebView.setVisibility(View.GONE);
		contentWebView.destroy();
		player.stop();
		player.release();
		super.onDestroy();
	}
	
	

	@Override
	public void onBackPressed() {
		Logger.d(TAG, "onBackPressed");
		super.onBackPressed();
	}

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && contentWebView.canGoBack()) {
			contentWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onBtnClick(View v) {

		switch (v.getId()) {

		case R.id.btnWiki:
			Log.d(TAG, "onBtnClick: btnWiki clicked");
			Intent in = new Intent();
			in.setAction(Intent.ACTION_VIEW);
			in.setData(Uri.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
			startActivity(in);
			break;

		case R.id.btnWall:
			Log.d(TAG, "onBtnClick: btnWall clicked");
			contentWebView.loadUrl("file:///android_asset/webcontent/jabberwocky.jpg");
			break;

		}

	}

}
