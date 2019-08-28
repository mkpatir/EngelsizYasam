package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.models.MainIllnessModel;

import java.util.List;

public class IllListviewAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<MainIllnessModel> mainIllnessModelList;

    public IllListviewAdapter(Activity activity,LayoutInflater layoutInflater,List<MainIllnessModel> mainIllnessModelList){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        this.mainIllnessModelList = mainIllnessModelList;
    }

    @Override
    public int getCount() {
        return mainIllnessModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mainIllnessModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = layoutInflater.inflate(R.layout.patients_listview_layout,null);
            TextView name = (TextView)convertView.findViewById(R.id.patients_listview_name);
            TextView tckimlik = (TextView)convertView.findViewById(R.id.patients_listview_tckimlik);
            TextView illness = (TextView)convertView.findViewById(R.id.patients_listview_illness);
            TextView enter_or_exit = (TextView)convertView.findViewById(R.id.patients_listview_enter_or_exit);
            name.setText(mainIllnessModelList.get(position).getIllness_model().getName_surname());
            tckimlik.setText(mainIllnessModelList.get(position).getTc_kimlik_no());
            illness.setText(mainIllnessModelList.get(position).getIllness_model().getIll());
            String enter_exit = mainIllnessModelList.get(position).getIllness_model().getEnter_or_exit();
            if (enter_exit == "Enter"){
                enter_or_exit.setText("Giriş");
                enter_or_exit.setBackground(activity.getResources().getDrawable(R.drawable.enter_green_background));
            }
            else{
                enter_or_exit.setText("Çıkış");
                enter_or_exit.setBackground(activity.getResources().getDrawable(R.drawable.exit_red_background));
            }
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }
}
