package com.littlejumbo.shitshot;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);

        findViewById(R.id.cacador_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(1);
            }
        });
        findViewById(R.id.cacador_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(2);
            }
        });
        findViewById(R.id.cacador_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(3);
            }
        });
        findViewById(R.id.cacador_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(4);
            }
        });
        findViewById(R.id.cacador_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(5);
            }
        });
        findViewById(R.id.cacador_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(6);
            }
        });
        findViewById(R.id.cacador_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(7);
            }
        });
        findViewById(R.id.cacador_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(8);
            }
        });
        findViewById(R.id.cacador_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCacador(9);
            }
        });
    }

    private void clickCacador(int id) {
        Log.d("Caçador", "Caçador " + id);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(100);
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);

        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }


    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
