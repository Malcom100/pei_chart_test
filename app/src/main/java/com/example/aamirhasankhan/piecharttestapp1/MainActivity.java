package com.example.aamirhasankhan.piecharttestapp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import az.plainpie.PieView;

public class MainActivity extends AppCompatActivity {

    PieView pieViewLastRide, pieViewAllRides;
    TextView LastDrivingTime, AverageDrivingTime;
    RadioButton rd1,rd2;
    String a = "75";
    int x = 24;
    int y = 95;
    float totaltimeSlots = 3600;
    float badoutComes = 600;
    float result = 0;
    float finalResult = 0;
    private GestureDetectorCompat gestureObject;
    //DrawerLayout mDrawerLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rd1 = (RadioButton) findViewById(R.id.radiobuttonpie1);
        rd2 = (RadioButton) findViewById(R.id.radiobuttonpie2);
        rd2.setChecked(true);

        rd1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("Test","Transition from radio button : enter to leave");
                Intent intent = new Intent(MainActivity.this, GestureActivity.class);
                finish();
                startActivity(intent);

                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
//                Bundle bundleanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
//                startActivity(intent, bundleanimation);
            }
        });

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        calculateValue();
        pieViewLastRide = (PieView)findViewById(R.id.pieViewLastRide);
        pieViewLastRide.setInnerTextVisibility(View.VISIBLE);


        LastDrivingTime = (TextView)findViewById(R.id.tvLastDrivingTime);
        AverageDrivingTime = (TextView)findViewById(R.id.tvAvgDrivingTime);


        pieViewAllRides = (PieView)findViewById(R.id.pieViewAllRides);
        pieViewAllRides.setInnerTextVisibility(View.VISIBLE);


        setValuesLastRide();
        setValuesAllRide();



    }

    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e2.getX() > e1.getX()){
                Log.i("Test","Transition : enter to leave");
                Intent intent = new Intent(MainActivity.this,GestureActivity.class);
                finish();
                startActivity(intent);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
            else{
                if(e2.getX() < e1.getX()){

                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    public void calculateValue(){
        //formula = 1-(sum(outcome)/ count(outcome))
        //first     totaltimeslots - badoutComes
        //sum = badoutComes
        //count = (totaltimeSlots
         totaltimeSlots = 18;
         badoutComes = 4;
         result = 0;
        result = totaltimeSlots - badoutComes;
        Log.e("RESULT", "" + result);
        finalResult = 0;
        finalResult = (100 *result )/ totaltimeSlots;

        Log.e("FINALREULT", "" + finalResult);


    }


    private void setValuesLastRide() {

        // Change the text of the widget
        pieViewLastRide.setInnerText(finalResult + "% \n Safety Score");
        pieViewLastRide.setmPercentage((float) finalResult);
        pieViewLastRide.setMainBackgroundColor(Color.LTGRAY);
        // Change the text size of the widget
        pieViewLastRide.setPercentageTextSize(30);

        LastDrivingTime.setText(x + "min");

    }

    private void setValuesAllRide() {


        // Change the text of the widget
        pieViewAllRides.setInnerText(finalResult + "% \n Safety Score");
        pieViewAllRides.setmPercentage((float) finalResult);
        pieViewAllRides.setMainBackgroundColor(Color.LTGRAY);
        // Change the text size of the widget
        pieViewAllRides.setPercentageTextSize(30);

        AverageDrivingTime.setText(y + "hours");
    }


    }
