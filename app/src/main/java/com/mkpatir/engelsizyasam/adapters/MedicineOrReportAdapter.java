package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mkpatir.engelsizyasam.R;

import java.util.List;

public class MedicineOrReportAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<String> list;
    private TextView textView;

    public MedicineOrReportAdapter(Activity activity, LayoutInflater layoutInflater, List<String> list){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = layoutInflater.inflate(R.layout.sex_spinner_layout,null);
            textView = (TextView)convertView.findViewById(R.id.sex_spinner_layout_text);
            textView.setText(list.get(position));
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }

}
