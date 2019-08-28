package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.extras.SelectedDatas;
import com.mkpatir.engelsizyasam.models.SecondMedicineModel;

import java.util.List;

public class IllMedicineListviewAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<SecondMedicineModel> secondMedicineModelList;

    public IllMedicineListviewAdapter(Activity activity,LayoutInflater layoutInflater,List<SecondMedicineModel> secondMedicineModelList){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        this.secondMedicineModelList = secondMedicineModelList;
    }
    @Override
    public int getCount() {
        return secondMedicineModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return secondMedicineModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        try {
            convertView = layoutInflater.inflate(R.layout.ill_medicine_listview_background,null);
            TextView name = (TextView)convertView.findViewById(R.id.ill_medicine_listview_medicinename);
            TextView dfu = (TextView)convertView.findViewById(R.id.ill_medicine_listview_directionsforuse);
            TextView start_date = (TextView)convertView.findViewById(R.id.ill_medicine_listview_startdate);
            Button delete = (Button)convertView.findViewById(R.id.ill_medicine_listview_delete_button);
            Button edit = (Button)convertView.findViewById(R.id.ill_medicine_listview_edit_button);
            name.setText(secondMedicineModelList.get(position).getMedicine_name());
            dfu.setText(secondMedicineModelList.get(position).getMedicineModel().getDirections_for_use());
            start_date.setText(secondMedicineModelList.get(position).getMedicineModel().getStart_date());
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectedDatas.selectedIllMedicineListPosition = position;
                    //Toast.makeText(activity.getApplicationContext(),position,Toast.LENGTH_LONG).show();
                    System.out.println(position);
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectedDatas.selectedIllMedicineListPosition = position;
                    //Toast.makeText(activity.getApplicationContext(),position,Toast.LENGTH_LONG).show();
                }
            });
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }
}
