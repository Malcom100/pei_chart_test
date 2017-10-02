package com.example.aamirhasankhan.piecharttestapp1;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class GestureActivity extends AppCompatActivity {
    private GestureDetectorCompat gestureObject;
    RadioButton rd1,rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        rd1 = (RadioButton) findViewById(R.id.radiobuttonpie1);
        rd2 = (RadioButton) findViewById(R.id.radiobuttonpie2);
        rd2.setChecked(false);
        rd2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.i("Test","Transition from radio button : rigth in to left out");
                Intent intent = new Intent(GestureActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
//                Intent intent = new Intent(MainActivity.this,GraphActivity.class);
//                startActivity(intent);
            }
        });


        rd1.setChecked(true);
    }
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e2.getX() > e1.getX()){

            }
            else{
                if(e2.getX() < e1.getX()){
//                    Intent intent = new Intent(MainActivity.this,GraphActivity.class);
//                    finish();
//                    startActivity(intent);

                    Log.i("Test","Transition : rigth in to left out ");

                    Intent intent = new Intent(GestureActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
