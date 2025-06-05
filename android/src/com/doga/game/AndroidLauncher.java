package com.doga.game;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

import java.io.File;

public class AndroidLauncher extends AndroidApplication implements AndroidFragmentApplication.Callbacks{
	File outputDirectory;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		outputDirectory = getOutputDirectory(this);
		initialize(new ArrowGame(new AndroidInterfaceClass(), this), config);
	}

	protected File getOutputDirectory(Context context) {
		File mediaDir = Environment.getExternalStorageDirectory();

		if (mediaDir != null) {
			File appDir = new File(mediaDir, "Arrows");
			appDir.mkdirs();
			if (appDir.exists()) {
				Log.i(TAG, appDir.getPath());
				return appDir;
			}
		}
		return context.getFilesDir();
	}
}
