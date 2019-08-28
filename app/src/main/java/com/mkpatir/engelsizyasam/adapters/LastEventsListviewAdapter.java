package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.models.EventModel;

import java.util.List;

public class LastEventsListviewAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<EventModel> eventModelList;

    public LastEventsListviewAdapter(Activity activity,LayoutInflater layoutInflater,List<EventModel> eventModelList){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        this.eventModelList = eventModelList;
    }
    @Override
    public int getCount() {
        return eventModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            ViewHolder viewHolder;
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.last_events_listview_layout,null);
                viewHolder = new ViewHolder();
                viewHolder.event_name = (TextView)convertView.findViewById(R.id.last_events_listview_event_name);
                viewHolder.event_date = (TextView)convertView.findViewById(R.id.last_events_listview_event_date);
                viewHolder.event_detail = (TextView)convertView.findViewById(R.id.last_events_listview_event_detail);
            }
            else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.event_name.setText(eventModelList.get(position).getEventName());
            viewHolder.event_date.setText(eventModelList.get(position).getEventDate());
            viewHolder.event_detail.setText(eventModelList.get(position).getEventDetail());
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }

    private static class ViewHolder{
        private TextView event_name;
        private TextView event_date;
        private TextView event_detail;
    }
}
