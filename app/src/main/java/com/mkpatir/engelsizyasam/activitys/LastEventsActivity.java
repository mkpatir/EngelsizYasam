package com.mkpatir.engelsizyasam.activitys;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.LastEventsListviewAdapter;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.EventModel;

import java.util.ArrayList;
import java.util.List;

public class LastEventsActivity extends AppCompatActivity {

    ListView last_events_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_events);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setTitle("Son Olaylar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        last_events_listview = (ListView)findViewById(R.id.last_events_listview);
        setListview();
    }

    private void setListview(){
        try {
            List<EventModel> eventModelList = new ArrayList<>();
            for (int i = StaticLists.eventModelList.size() - 1; i >= 0;i--){
                eventModelList.add(StaticLists.eventModelList.get(i));
            }
            LastEventsListviewAdapter lastEventsListviewAdapter = new LastEventsListviewAdapter(LastEventsActivity.this,getLayoutInflater(),eventModelList);
            last_events_listview.setAdapter(lastEventsListviewAdapter);
        }
        catch (Exception ex){

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
