package com.mkpatir.engelsizyasam.activitys;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.ReportsDayListviewAdapter;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.ReportsDayListviewModel;
import com.mkpatir.engelsizyasam.models.SecondReportModel;

import java.util.ArrayList;
import java.util.List;

public class ReportsDayActivity extends AppCompatActivity {

    ListView reports_day_listview;
    ReportsDayListviewAdapter reportsDayListviewAdapter;
    List<ReportsDayListviewModel> reportsDayListviewModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_day);
        getSupportActionBar().setTitle("Kalan Rapor Bilgileri");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reports_day_listview = (ListView)findViewById(R.id.reports_day_listview);
        setListview();
    }

    private void setListview(){
        try {
            List<String> tcKimlikList = new ArrayList<>();
            for (int i = 0 ; i < StaticLists.mainReportModelList.size();i++){
                for (int j = 0;j < StaticLists.mainReportModelList.get(i).getSecondReportModelList().size();j++){
                    tcKimlikList.add(StaticLists.mainReportModelList.get(i).getTc_kimlik_no());
                }
            }
            List<SecondReportModel> secondReportModelList = new ArrayList<>();
            for (int i = 0;i < StaticLists.mainReportModelList.size();i++){
                secondReportModelList.addAll(StaticLists.mainReportModelList.get(i).getSecondReportModelList());
            }
            for (int i = 0;i < secondReportModelList.size();i++){
                ReportsDayListviewModel reportsDayListviewModel = new ReportsDayListviewModel();
                reportsDayListviewModel.setTcKimlikNo(tcKimlikList.get(i));
                reportsDayListviewModel.setReport_name(secondReportModelList.get(i).getReport_name());
                reportsDayListviewModel.setReportModel(secondReportModelList.get(i).getReportModel());
                reportsDayListviewModelList.add(reportsDayListviewModel);
            }
            reportsDayListviewModelList.remove(0);
            reportsDayListviewAdapter = new ReportsDayListviewAdapter(ReportsDayActivity.this,getLayoutInflater(),reportsDayListviewModelList);
            reports_day_listview.setAdapter(reportsDayListviewAdapter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.search_menu,menu);
            MenuItem search = menu.findItem(R.id.search_in_actionbar);
            SearchView searchView = (SearchView)search.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (newText != null && newText.length() > 0){
                        newText = newText.toLowerCase();
                        List<ReportsDayListviewModel> tempList = new ArrayList<>();
                        for (int i = 0;i<reportsDayListviewModelList.size();i++){
                            if (reportsDayListviewModelList.get(i).getTcKimlikNo().toLowerCase().contains(newText) || reportsDayListviewModelList.get(i).getReport_name().toLowerCase().contains(newText)){
                                ReportsDayListviewModel reportsDayListviewModel = reportsDayListviewModelList.get(i);
                                tempList.add(reportsDayListviewModel);
                            }
                        }
                        reportsDayListviewAdapter = new ReportsDayListviewAdapter(ReportsDayActivity.this,getLayoutInflater(),tempList);
                        reports_day_listview.setAdapter(reportsDayListviewAdapter);
                    }
                    else {
                        reportsDayListviewAdapter = new ReportsDayListviewAdapter(ReportsDayActivity.this,getLayoutInflater(),reportsDayListviewModelList);
                        reports_day_listview.setAdapter(reportsDayListviewAdapter);
                    }
                    return true;
                }
            });
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

}
