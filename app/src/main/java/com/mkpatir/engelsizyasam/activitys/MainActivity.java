package com.mkpatir.engelsizyasam.activitys;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.mkpatir.engelsizyasam.R;

public class MainActivity extends AppCompatActivity {
    CardView main_addillness_cardview;
    CardView main_patients_cardview;
    CardView main_reports_day_cardview;
    CardView main_last_events_cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_addillness_cardview = (CardView)findViewById(R.id.main_addillness_cardview);
        main_patients_cardview = (CardView)findViewById(R.id.main_patients_cardview);
        main_reports_day_cardview = (CardView)findViewById(R.id.main_reports_day_cardview);
        main_last_events_cardview = (CardView)findViewById(R.id.main_last_events_cardview);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        setClicks();
    }

    public void setClicks(){
        try {
            main_addillness_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,AddIllnessActivity.class);
                    startActivity(intent);
                }
            });
            main_patients_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,PatientsActivity.class);
                    startActivity(intent);
                }
            });
            main_reports_day_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ReportsDayActivity.class);
                    startActivity(intent);
                }
            });
            main_last_events_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,LastEventsActivity.class);
                    startActivity(intent);
                }
            });
        }
        catch (Exception ex){

        }
    }
}
