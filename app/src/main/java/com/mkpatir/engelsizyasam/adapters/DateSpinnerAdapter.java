package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mkpatir.engelsizyasam.R;

import java.util.List;

public class DateSpinnerAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private String[] dateList;
    private TextView dateText;

    public DateSpinnerAdapter(Activity activity,LayoutInflater layoutInflater,String[] dateList){
        this.activity = activity;
        this.dateList = dateList;
        this.layoutInflater = layoutInflater;
    }
    @Override
    public int getCount() {
        return dateList.length;
    }

    @Override
    public Object getItem(int position) {
        return dateList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = layoutInflater.inflate(R.layout.date_spinner_layout,null);
            dateText = (TextView)convertView.findViewById(R.id.date_spinner_layout_text);
            dateText.setText(dateList[position]);
            if (position == 0){
                dateText.setTextColor(activity.getResources().getColor(android.R.color.darker_gray));
            }
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0){
            return false;
        }
        else {
            return true;
        }
    }
}
