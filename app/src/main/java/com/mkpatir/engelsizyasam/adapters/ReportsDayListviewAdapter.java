package com.mkpatir.engelsizyasam.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.extras.DateList;
import com.mkpatir.engelsizyasam.models.ReportsDayListviewModel;

import java.util.List;

public class ReportsDayListviewAdapter extends BaseAdapter {

    private List<ReportsDayListviewModel> reportsDayListviewModelList;
    private Activity activity;
    private LayoutInflater layoutInflater;

    public ReportsDayListviewAdapter(Activity activity,LayoutInflater layoutInflater,List<ReportsDayListviewModel> reportsDayListviewModelList){
        this.activity = activity;
        this.layoutInflater = layoutInflater;
        this.reportsDayListviewModelList = reportsDayListviewModelList;
    }

    @Override
    public int getCount() {
        return reportsDayListviewModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return reportsDayListviewModelList.get(position);
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
                convertView = layoutInflater.inflate(R.layout.reports_day_listview_layout,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.tckimlik = (TextView)convertView.findViewById(R.id.reports_day_listview_tckimlik);
                viewHolder.report_name = (TextView) convertView.findViewById(R.id.reports_day_listview_report_name);
                viewHolder.report_end_date = (TextView)convertView.findViewById(R.id.reports_day_listview_report_end_date);
                viewHolder.remaining_day = (TextView)convertView.findViewById(R.id.reports_day_listview_remaining_day);
                viewHolder.cardview = (CardView)convertView.findViewById(R.id.reports_day_listview_cardview);
                viewHolder.alert = (ImageView)convertView.findViewById(R.id.reports_day_listview_alert);
            }
            else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            ReportsDayListviewModel reportsDayListviewModel = reportsDayListviewModelList.get(position);
            long fark = DateList.getRemainingDays(reportsDayListviewModel.getReportModel().getReport_end_date());
            viewHolder.tckimlik.setText(reportsDayListviewModel.getTcKimlikNo());
            viewHolder.report_name.setText(reportsDayListviewModel.getReport_name());
            viewHolder.report_end_date.setText(reportsDayListviewModel.getReportModel().getReport_end_date());
            if (fark > 0 && fark < 8){
                viewHolder.remaining_day.setText("Raporun süresinin bitmesine " + String.valueOf(fark) + " gün kalmış !");
                viewHolder.alert.setVisibility(View.VISIBLE);
                viewHolder.cardview.setCardBackgroundColor(activity.getResources().getColor(R.color.RedA700));
            }
            else if (fark == 0){
                viewHolder.remaining_day.setText("Raporun süresi bugün bitiyor !");
                viewHolder.alert.setVisibility(View.VISIBLE);
                viewHolder.cardview.setCardBackgroundColor(activity.getResources().getColor(R.color.RedA700));
            }
            else if (fark < 0){
                viewHolder.remaining_day.setText("Raporun süresi bitmiş !");
                viewHolder.alert.setVisibility(View.VISIBLE);
                viewHolder.cardview.setCardBackgroundColor(activity.getResources().getColor(R.color.RedA700));
            }
            else{
                viewHolder.remaining_day.setText("Raporun süresinin bitmesine " + String.valueOf(fark) + " gün var.");
            }
            return convertView;
        }
        catch (Exception ex){
            return null;
        }
    }

    public static class ViewHolder{
        TextView tckimlik;
        TextView report_name;
        TextView report_end_date;
        TextView remaining_day;
        CardView cardview;
        ImageView alert;
    }
}
