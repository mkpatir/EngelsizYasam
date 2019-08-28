package com.mkpatir.engelsizyasam.activitys;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.IllListviewAdapter;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.IllnessModel;
import com.mkpatir.engelsizyasam.models.MainIllnessModel;

import java.util.ArrayList;
import java.util.List;

public class PatientsActivity extends AppCompatActivity {

    ListView patients_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        getSupportActionBar().setTitle("Hastalar");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        patients_listview = (ListView)findViewById(R.id.patients_listview);
        setListview();
    }

    private void setListview(){
        try {
            /*List<MainIllnessModel> mainIllnessModelList = new ArrayList<>();
            MainIllnessModel mainIllnessModel = new MainIllnessModel();
            mainIllnessModel.setTc_kimlik_no("12365495212");
            IllnessModel illnessModel = new IllnessModel();
            illnessModel.setName_surname("Mehmet Dengeli");
            illnessModel.setBirthdate("13/18/1975");
            illnessModel.setIll("Illness");
            illnessModel.setEnter_or_exit("Enter");
            illnessModel.setEnter_exit_date("10/03/2017");
            illnessModel.setFromemployee("Ali Keser");
            mainIllnessModel.setIllness_model(illnessModel);
            mainIllnessModelList.add(mainIllnessModel);*/
            IllListviewAdapter ıllListviewAdapter = new IllListviewAdapter(PatientsActivity.this,getLayoutInflater(),StaticLists.mainIllnessModelList);
            patients_listview.setAdapter(ıllListviewAdapter);
            patients_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(PatientsActivity.this,IllActivity.class);
                    intent.putExtra("listPosition",position);
                    intent.putExtra("illName",StaticLists.mainIllnessModelList.get(position).getIllness_model().getName_surname());
                    startActivity(intent);
                }
            });
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
