package inc.cix.webinapp;

import android.util.Log;



public class Logger {

	public static void d(String TAG, String text) {

		Log.d(TAG, text);

	}

	public static void i(String TAG, String text) {

		Log.i(TAG, text);

	}

	public static void e(String TAG, String text) {

		Log.e(TAG, text);

	}

	public static void v(String TAG, String text) {

		Log.v(TAG, text);
	}

	public static void critical(String TAG, String text) {
		Log.i(TAG, text);
	}

}
