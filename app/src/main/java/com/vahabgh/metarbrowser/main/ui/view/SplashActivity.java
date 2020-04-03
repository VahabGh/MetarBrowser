package com.vahabgh.metarbrowser.main.ui.view;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;

import com.vahabgh.metarbrowser.R;

public class SplashActivity extends AppCompatActivity {

    private AppCompatImageView ivAirplane;
    private AppCompatTextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initViews();
        flyAirplane();

    }

    private void showTitle() {
        tvTitle.animate().alphaBy(1).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                goToMainActivity();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void flyAirplane() {
        int y = getResources().getDisplayMetrics().heightPixels;
        ivAirplane.setY(y);
        ivAirplane.animate().translationY(-2000f)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(2000)
                .setListener(
                        new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                showTitle();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        }
                ).start();

    }

    private void goToMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 500);
    }

    private void initViews() {
        ivAirplane = findViewById(R.id.ivAirplane);
        tvTitle = findViewById(R.id.tvTitle);
    }
}
