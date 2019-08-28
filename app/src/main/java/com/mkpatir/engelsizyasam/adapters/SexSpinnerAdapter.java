package com.mkpatir.engelsizyasam.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.res.Resources;

import com.mkpatir.engelsizyasam.R;

import java.util.ArrayList;
import java.util.List;

public class SexSpinnerAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Activity activity;
    private List<String> sexList = new ArrayList<>();
    private TextView sex_spinner_text;
    public SexSpinnerAdapter(Activity activity, LayoutInflater layoutInflater){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        sexList.add("Seçiniz");
        sexList.add("Erkek");
        sexList.add("Kadın");
    }
    @Override
    public int getCount() {
        return sexList.size();
    }

    @Override
    public Object getItem(int position) {
        return sexList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = layoutInflater.inflate(R.layout.sex_spinner_layout,null);
            sex_spinner_text = convertView.findViewById(R.id.sex_spinner_layout_text);
            if (position == 0){
                sex_spinner_text.setTextColor(activity.getResources().getColor(android.R.color.darker_gray));
            }
            String sex = sexList.get(position);
            sex_spinner_text.setText(sex);
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
