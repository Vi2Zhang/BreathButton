package com.example.vito.breathbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Desctiption:
 * Created by Vito on 2015/12/19.
 * Email:developervito@163.com
 * ModifiedBy:Vito
 * ModifiedTime: 2015/12/19 19:15
 * ModifiedNotes:
 * Version 1.0
 */
public class MainActivity extends Activity{

    private Animation animationVoice,animationExit,animationIn;
    private ImageView back, voice;
    private boolean isVisible;  //动画执行标志位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breath_button_layout);
        initAnimation();
        bindViews();
        initView();

    }

    private void initView() {
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isVisible) {
                    back.startAnimation(animationIn);
                    isVisible = true;
                } else {
                    back.startAnimation(animationExit);
                    isVisible = false;
                }

            }
        });

    }

    private void bindViews() {
        back = (ImageView) findViewById(R.id.voice_back);
        voice = (ImageView) findViewById(R.id.voice);
    }

    private void initAnimation() {
        animationVoice = AnimationUtils.loadAnimation(this, R.anim.voice_button_anim);
        animationExit = AnimationUtils.loadAnimation(this, R.anim.voice_button_exit_anim);
        animationIn = AnimationUtils.loadAnimation(this, R.anim.voice_button_in_anim);
        //设置动画执行的回调函数
        animationIn.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                back.startAnimation(animationVoice);    //开始呼吸动画
                back.setVisibility(View.VISIBLE);
            }
        });

        animationExit.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                back.clearAnimation();  //清除动画
                back.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
