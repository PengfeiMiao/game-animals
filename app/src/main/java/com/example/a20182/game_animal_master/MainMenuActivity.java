package com.example.a20182.game_animal_master;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainMenuActivity extends AppCompatActivity {

    public static int score = -1;

    public static int[] imageID = {
            R.drawable.bear,
            R.drawable.bird,
            R.drawable.cat,
            R.drawable.elephant,
            R.drawable.fish,
            R.drawable.flower,
            R.drawable.giraffe,
            R.drawable.honey,
            R.drawable.house,
            R.drawable.hypo,
            R.drawable.kangaroo,
            R.drawable.leo,
            R.drawable.lion,
            R.drawable.pig,
            R.drawable.sun
    };

    public static String[] imageName = {
            "bear",
            "bird",
            "cat",
            "elephant",
            "fish",
            "flower",
            "giraffe",
            "honey",
            "house",
            "hypo",
            "kangaroo",
            "leo",
            "lion",
            "pig",
            "sun"
    };

    public static int[] rand = {0, 0, 0, 0};

    public static int flag = -1,
                        result = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        if(score!=-1)disPlay();
        //onConfigurationChanged(this.getResources().getConfiguration());
    /*
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else if(this.getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    */
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        switch (newConfig.orientation)
        {
            case (Configuration.ORIENTATION_LANDSCAPE):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case (Configuration.ORIENTATION_PORTRAIT):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }

    public void btnPlay(View view){
        //Intent intent =new Intent(MainMenuActivity.this, DisplayActivity.class);
        //startActivity(intent);
        if(score==-1)score=0;
        randList();
        disPlay();
    }

    public void randList(){

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            rand[i] = Math.abs(random.nextInt()) % 15;
            for (int j = 0; j < i; j++) {
                if (rand[i] == rand[j]) {
                    rand[i] = Math.abs(random.nextInt()) % 15;
                    j = 0;
                }
            }
        }

        Random random1 = new Random();
        flag = Math.abs(random1.nextInt()) % 4;

    }

    public void disPlay() {
        setContentView(R.layout.display);
        TextView tv = (TextView) findViewById(R.id.tv_score);
        tv.setText("Score:"+String.valueOf(score));

        ImageView iv11 = (ImageView) findViewById(R.id.iv1);
        iv11.setImageResource(imageID[rand[0]]);
        ImageView iv22 = (ImageView) findViewById(R.id.iv2);
        iv22.setImageResource(imageID[rand[1]]);
        ImageView iv33 = (ImageView) findViewById(R.id.iv3);
        iv33.setImageResource(imageID[rand[2]]);
        ImageView iv44 = (ImageView) findViewById(R.id.iv4);
        iv44.setImageResource(imageID[rand[3]]);

        TextView tv1 = (TextView) findViewById(R.id.tv_Tip);
        tv1.setText(imageName[rand[flag]]);
    }

    public void sel_1(View view){
        result = 0;
        nagetive();
    }
    public void sel_2(View view){
        result = 1;
        nagetive();
    }
    public void sel_3(View view){
        result = 2;
        nagetive();
    }
    public void sel_4(View view){
        result = 3;
        nagetive();
    }

    public void nagetive(){
        if(result==flag){
            score++;
            setContentView(R.layout.success);
            TextView tv = (TextView) findViewById(R.id.tv_Sscore);
            tv.setText("Score:"+String.valueOf(score));
        }
        else{
            setContentView(R.layout.fail);
            score = 0;
        }
    }

    public void exit(View view){
        finish();
        //参数用作状态码；根据惯例，非 0 的状态码表示异常终止。
        System.exit(0);
    }

}


