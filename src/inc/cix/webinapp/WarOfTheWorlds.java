package inc.cix.webinapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class WarOfTheWorlds extends Activity {

	WebView contentWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_content);
		
		contentWebView = (WebView) findViewById(R.id.contentWebView);
		contentWebView.getSettings().setBuiltInZoomControls(true);
		contentWebView.loadUrl("file:///android_asset/webcontent/waroftheworlds.html");		
	}



}
