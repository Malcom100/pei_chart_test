package com.example.aamirhasankhan.piecharttestapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by ttwyf on 7/25/2016.
 */
public class GraphActivity extends Activity {

    RadioButton radio1,radio2;
    private GestureDetectorCompat gestureObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);

        radio1 = (RadioButton) findViewById(R.id.radiobuttongraph1);
        radio2 = (RadioButton) findViewById(R.id.radiobuttongraph2);

        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(GraphActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
//                Bundle bundleanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
//                startActivity(intent,bundleanimation);
            }
        });

        LineChart lineChart = (LineChart) findViewById(R.id.chart1);
        LineChart lineChart1 = (LineChart) findViewById(R.id.chart2);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(3, 0));
        entries.add(new Entry(4, 1));
        entries.add(new Entry(5, 2));


        LineDataSet dataset = new LineDataSet(entries, "# MY SAFETY SCORE");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Monday");
        labels.add("Tuesday");
        labels.add("Wednesday");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(new int[]{ColorTemplate.getHoloBlue()}); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(3, 0));
        entries2.add(new Entry(4, 1));
        entries2.add(new Entry(5, 2));


        LineDataSet dataset2 = new LineDataSet(entries2, "# MY DRIVING TIME");

        ArrayList<String> labels2 = new ArrayList<String>();
        labels2.add("Monday");
        labels2.add("Tuesday");
        labels2.add("Wednesday");


        LineData data2 = new LineData(labels2, dataset2);
        dataset2.setColors(new int[]{ColorTemplate.getHoloBlue()}); //
        dataset2.setDrawCubic(true);
        dataset2.setDrawFilled(true);

        lineChart1.setData(data2);
        lineChart1.animateY(5000);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
    }

    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e2.getX() > e1.getX()){

                Intent intent = new Intent(GraphActivity.this,MainActivity.class);
                finish();
                startActivity(intent);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
            else{
                if(e2.getX() < e1.getX()){
//                    Intent intent = new Intent(MainActivity.this,GraphActivity.class);
//                    finish();
//                    startActivity(intent);
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
