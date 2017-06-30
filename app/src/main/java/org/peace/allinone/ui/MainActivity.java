package org.peace.allinone.ui;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import org.peace.allinone.R;

public class MainActivity extends Activity implements View.OnClickListener {

    static String T = "peace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.unregister).setOnClickListener(this);

        getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS_MODE), true, mObserver);
    }

    @Override
    public void onClick(View v) {
        getContentResolver().unregisterContentObserver(mObserver);
        Log.d(T, "unregister finished");
    }

    private ContentObserver mObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            Log.d(T, "onChange called");
        }
    };
}
