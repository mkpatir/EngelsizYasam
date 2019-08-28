
package com.mkpatir.engelsizyasam.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.DateSpinnerAdapter;
import com.mkpatir.engelsizyasam.adapters.IllMedicineListviewAdapter;
import com.mkpatir.engelsizyasam.adapters.MedicineOrReportAdapter;
import com.mkpatir.engelsizyasam.extras.DateList;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.EventModel;
import com.mkpatir.engelsizyasam.models.MedicineModel;
import com.mkpatir.engelsizyasam.models.ReportModel;
import com.mkpatir.engelsizyasam.models.SecondMedicineModel;
import com.mkpatir.engelsizyasam.models.SecondReportModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

public class IllActivity extends AppCompatActivity {

    TextView ill_tckimlik;
    TextView ill_namesurname;
    TextView ill_birthdate;
    TextView ill_illness;
    TextView ill_sex;
    TextView ill_lastdate;
    TextView ill_fromemployee;
    Button ill_edit_ill_button;
    private String illName = "";
    private int REQUEST_CODE = 1;

    /////////////////////// Medicine


    Spinner ill_medicine_spinner;
    EditText ill_medicine_name;
    EditText ill_medicine_directions_for_use;
    Spinner ill_medicine_day_spinner;
    Spinner ill_medicine_month_spinner;
    EditText ill_medicine_year_edittext;
    Button ill_medicine_edit_button;
    CardView ill_medicine_cardview;
    LinearLayout ill_medicine_edit_layout;
    LinearLayout ill_medicine_name_layout;
    Button ill_medicine_cancel_button;
    Button ill_medicine_delete_button;
    Button ill_medicine_ok_button;
    Button ill_medicine_add_medicine;
    private int listPosition;
    private int selectedMedicine = 1;
    private int selectedIllMedicineListPosition = -1;
    private List<SecondMedicineModel> selectedIllMedicineList = new ArrayList<>();
    private List<String> selectedIllMedicineNameList = new ArrayList<>();

    //////////////////////// Report

    Spinner ill_report_spinner;
    Button ill_report_edit_button;
    LinearLayout ill_report_name_layout;
    Button ill_report_add_report;
    LinearLayout ill_report_edit_layout;
    EditText ill_report_name;
    EditText ill_report_info;
    Spinner ill_report_start_day_spinner;
    Spinner ill_report_start_month_spinner;
    EditText ill_report_start_year_edittext;
    Spinner ill_report_end_day_spinner;
    Spinner ill_report_end_month_spinner;
    EditText ill_report_end_year_edittext;
    Button ill_report_cancel_button;
    Button ill_report_delete_button;
    Button ill_report_ok_button;
    private List<SecondReportModel> selectedIllReportList = new ArrayList<>();
    private List<String> selectedIllReportNameList = new ArrayList<>();
    private int selectedReport = 1;
    private int selectedIllReportListPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ill);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        Intent intent = getIntent();
        listPosition = intent.getIntExtra("listPosition",-1);
        illName = intent.getStringExtra("illName");
        getSupportActionBar().setTitle(illName);
        ill_tckimlik = (TextView)findViewById(R.id.ill_tckimlik);
        ill_namesurname = (TextView)findViewById(R.id.ill_namesurname);
        ill_birthdate = (TextView)findViewById(R.id.ill_birthdate);
        ill_illness = (TextView)findViewById(R.id.ill_illness);
        ill_sex = (TextView)findViewById(R.id.ill_sex);
        ill_lastdate = (TextView)findViewById(R.id.ill_lastdate);
        ill_fromemployee = (TextView)findViewById(R.id.ill_fromemployee);
        ill_edit_ill_button = (Button)findViewById(R.id.ill_edit_ill_button);
        ill_edit_ill_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IllActivity.this,EditIllActivity.class);
                intent.putExtra("listPosition",listPosition);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        if (StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_or_exit().equals("Enter")){
            ill_fromemployee.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getFromemployee() + " tarafından girişi yapıldı.");
        }
        else{
            ill_fromemployee.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getFromemployee() + " tarafından çıkışı yapıldı.");
        }

        //////Medicine

        ill_medicine_spinner = (Spinner)findViewById(R.id.ill_medicine_spinner);
        ill_medicine_name = (EditText)findViewById(R.id.ill_medicine_name);
        ill_medicine_directions_for_use = (EditText)findViewById(R.id.ill_medicine_directions_for_use);
        ill_medicine_day_spinner = (Spinner)findViewById(R.id.ill_medicine_day_spinner);
        ill_medicine_month_spinner = (Spinner)findViewById(R.id.ill_medicine_month_spinner);
        ill_medicine_year_edittext = (EditText)findViewById(R.id.ill_medicine_year_edittext);
        ill_medicine_edit_button = (Button)findViewById(R.id.ill_medicine_edit_button);
        ill_medicine_cardview = (CardView)findViewById(R.id.ill_medicine_cardview);
        ill_medicine_edit_layout = (LinearLayout)findViewById(R.id.ill_medicine_edit_layout);
        ill_medicine_add_medicine = (Button)findViewById(R.id.ill_medicine_add_medicine);
        ill_medicine_cancel_button = (Button)findViewById(R.id.ill_medicine_cancel_button);
        ill_medicine_delete_button = (Button)findViewById(R.id.ill_medicine_delete_button);
        ill_medicine_ok_button = (Button)findViewById(R.id.ill_medicine_ok_button);
        ill_medicine_name_layout = (LinearLayout)findViewById(R.id.ill_medicine_name_layout);
        ill_namesurname.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getName_surname());
        ill_tckimlik.setText(StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no());
        ill_illness.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getIll());
        ill_sex.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getSex());
        ill_birthdate.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getBirthdate());
        ill_lastdate.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_exit_date());
        setMedicineSpinners();
        setMedicineClicks();

        //////////////Report

        ill_report_spinner = (Spinner)findViewById(R.id.ill_report_spinner);
        ill_report_edit_button = (Button)findViewById(R.id.ill_report_edit_button);
        ill_report_name_layout = (LinearLayout)findViewById(R.id.ill_report_name_layout);
        ill_report_add_report = (Button)findViewById(R.id.ill_report_add_report);
        ill_report_name = (EditText)findViewById(R.id.ill_report_name);
        ill_report_edit_layout = (LinearLayout)findViewById(R.id.ill_report_edit_layout);
        ill_report_info = (EditText)findViewById(R.id.ill_report_info);
        ill_report_start_day_spinner = (Spinner)findViewById(R.id.ill_report_start_day_spinner);
        ill_report_start_month_spinner = (Spinner)findViewById(R.id.ill_report_start_month_spinner);
        ill_report_start_year_edittext = (EditText)findViewById(R.id.ill_report_start_year_edittext);
        ill_report_end_day_spinner = (Spinner)findViewById(R.id.ill_report_end_day_spinner);
        ill_report_end_month_spinner = (Spinner)findViewById(R.id.ill_report_end_month_spinner);
        ill_report_end_year_edittext = (EditText)findViewById(R.id.ill_report_end_year_edittext);
        ill_report_cancel_button = (Button)findViewById(R.id.ill_report_cancel_button);
        ill_report_delete_button = (Button)findViewById(R.id.ill_report_delete_button);
        ill_report_ok_button = (Button)findViewById(R.id.ill_report_ok_button);
        setReportSpinners();
        setReportClicks();
    }

    private void setMedicineSpinners(){
        try {
            DateSpinnerAdapter dateSpinnerAdapter = new DateSpinnerAdapter(IllActivity.this,getLayoutInflater(),DateList.getDayList());
            ill_medicine_day_spinner.setAdapter(dateSpinnerAdapter);
            DateSpinnerAdapter dateSpinnerAdapter1 = new DateSpinnerAdapter(IllActivity.this,getLayoutInflater(),DateList.getMonthList());
            ill_medicine_month_spinner.setAdapter(dateSpinnerAdapter1);
            for (int i = 0;i < StaticLists.mainMedicineModelList.size();i++){
                if (StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no().equals(StaticLists.mainMedicineModelList.get(i).getTc_kimlik_no())){
                    selectedIllMedicineList = StaticLists.mainMedicineModelList.get(i).getSecondMedicineModelList();
                    selectedIllMedicineListPosition = i;
                }
            }
            if (selectedIllMedicineList.size() > 1){
                for (int i = 0 ; i < selectedIllMedicineList.size();i++){
                    selectedIllMedicineNameList.add(selectedIllMedicineList.get(i).getMedicine_name());
                }
                selectedIllMedicineNameList.remove(0);
                ill_medicine_name_layout.setVisibility(View.VISIBLE);
                MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(IllActivity.this,getLayoutInflater(),selectedIllMedicineNameList);
                ill_medicine_spinner.setAdapter(medicineOrReportAdapter);
                ill_medicine_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selectedMedicine = position+1;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
        catch (Exception ex){

        }
    }

    private void setMedicineClicks(){
        try {
            ill_medicine_add_medicine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_medicine_edit_layout.setVisibility(View.VISIBLE);
                    ill_medicine_delete_button.setVisibility(View.GONE);
                    ill_medicine_ok_button.setText("Ekle");
                    ill_medicine_name.setText("");
                    ill_medicine_directions_for_use.setText("");
                    ill_medicine_day_spinner.setSelection(0);
                    ill_medicine_month_spinner.setSelection(0);
                    ill_medicine_year_edittext.setText("");
                }
            });
            ill_medicine_cancel_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_medicine_edit_layout.setVisibility(View.GONE);
                }
            });
            ill_medicine_edit_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_medicine_edit_layout.setVisibility(View.VISIBLE);
                    ill_medicine_name.setText(selectedIllMedicineList.get(selectedMedicine).getMedicine_name());
                    ill_medicine_directions_for_use.setText(selectedIllMedicineList.get(selectedMedicine).getMedicineModel().getDirections_for_use());
                    char[] med_dateChar = selectedIllMedicineList.get(selectedMedicine).getMedicineModel().getStart_date().toCharArray();
                    ill_medicine_day_spinner.setSelection(Integer.parseInt("" + med_dateChar[0] + med_dateChar[1]));
                    ill_medicine_month_spinner.setSelection(Integer.parseInt("" + med_dateChar[3] + med_dateChar[4]));
                    ill_medicine_year_edittext.setText("" + med_dateChar[6] + med_dateChar[7] + med_dateChar[8] + med_dateChar[9]);
                    ill_medicine_ok_button.setText("Kaydet");
                    ill_medicine_delete_button.setVisibility(View.VISIBLE);
                }
            });
            ill_medicine_delete_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().remove(selectedMedicine);
                    refreshMedicineSpinner();
                }
            });
            ill_medicine_ok_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ill_medicine_ok_button.getText().equals("Ekle")){
                        MedicineModel medicineModel = new MedicineModel();
                        SecondMedicineModel secondMedicineModel = new SecondMedicineModel();
                        if (ill_medicine_name.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"İlaç ismi alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_directions_for_use.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Kullanım detayları alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_day_spinner.getSelectedItemPosition() == 0 || ill_medicine_month_spinner.getSelectedItemPosition() == 0 || ill_medicine_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else{
                            boolean isSame = false;
                            for (int i = 0; i < StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().size();i++){
                                if (StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().get(i).getMedicine_name().equals(ill_medicine_name.getText().toString())){
                                    isSame = true;
                                }
                            }
                            if (isSame){
                                Toast.makeText(IllActivity.this,"Bu isimde bir ilaç bu hastaya daha önce eklenmiş !",Toast.LENGTH_LONG).show();
                            }
                            else{
                                medicineModel.setDirections_for_use(ill_medicine_directions_for_use.getText().toString());
                                medicineModel.setStart_date(ill_medicine_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_medicine_month_spinner.getSelectedItem().toString()) + "/" + ill_medicine_year_edittext.getText().toString());
                                secondMedicineModel.setMedicine_name(ill_medicine_name.getText().toString());
                                secondMedicineModel.setMedicineModel(medicineModel);
                                StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().add(secondMedicineModel);
                                Toast.makeText(IllActivity.this,"İlaç eklendi.",Toast.LENGTH_LONG).show();
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                EventModel eventModel = new EventModel();
                                eventModel.setEventName("İlaç Ekleme");
                                eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                                eventModel.setEventDetail("Deneme Hesabı tarafından " + ill_namesurname.getText().toString() + " isimli hastaya " + ill_medicine_name.getText().toString() + " isimli ilaç eklendi.");
                                StaticLists.eventModelList.add(eventModel);
                                if (StaticLists.eventModelList.size() > 20){
                                    StaticLists.eventModelList.remove(0);
                                }
                                refreshMedicineSpinner();
                            }
                        }
                    }
                    else if (ill_medicine_ok_button.getText().equals("Kaydet")){
                        MedicineModel medicineModel = new MedicineModel();
                        SecondMedicineModel secondMedicineModel = new SecondMedicineModel();
                        if (ill_medicine_name.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"İlaç ismi alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_directions_for_use.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Kullanım detayları alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_day_spinner.getSelectedItemPosition() == 0 || ill_medicine_month_spinner.getSelectedItemPosition() == 0 || ill_medicine_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_medicine_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else{
                            boolean isSame = false;
                            for (int i = 0; i < StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().size();i++){
                                if (StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().get(i).getMedicine_name().equals(ill_medicine_name.getText().toString()) && i != selectedMedicine){
                                    isSame = true;
                                }
                            }
                            if (isSame){
                                Toast.makeText(IllActivity.this,"Bu isimde bir ilaç bu hastaya daha önce eklenmiş !",Toast.LENGTH_LONG).show();
                            }
                            else{
                                medicineModel.setDirections_for_use(ill_medicine_directions_for_use.getText().toString());
                                medicineModel.setStart_date(ill_medicine_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_medicine_month_spinner.getSelectedItem().toString()) + "/" + ill_medicine_year_edittext.getText().toString());
                                secondMedicineModel.setMedicine_name(ill_medicine_name.getText().toString());
                                secondMedicineModel.setMedicineModel(medicineModel);
                                StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().remove(selectedMedicine);
                                StaticLists.mainMedicineModelList.get(selectedIllMedicineListPosition).getSecondMedicineModelList().add(secondMedicineModel);
                                Toast.makeText(IllActivity.this,"İlaç yeniden düzenlendi.",Toast.LENGTH_LONG).show();
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                EventModel eventModel = new EventModel();
                                eventModel.setEventName("İlaç Güncelleme");
                                eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                                eventModel.setEventDetail("Deneme Hesabı tarafından " + ill_namesurname.getText().toString() + " isimli hastanın " + ill_medicine_name.getText().toString() + " isimli ilacı güncellendi.");
                                StaticLists.eventModelList.add(eventModel);
                                if (StaticLists.eventModelList.size() > 20){
                                    StaticLists.eventModelList.remove(0);
                                }
                                refreshMedicineSpinner();
                            }
                        }
                    }
                }
            });
        }
        catch (Exception ex){

        }
    }

    private void refreshMedicineSpinner(){
        try {
            ill_medicine_edit_layout.setVisibility(View.GONE);
            selectedIllMedicineNameList.clear();
            for (int i = 0;i < StaticLists.mainMedicineModelList.size();i++){
                if (StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no().equals(StaticLists.mainMedicineModelList.get(i).getTc_kimlik_no())){
                    selectedIllMedicineList = StaticLists.mainMedicineModelList.get(i).getSecondMedicineModelList();
                    selectedIllMedicineListPosition = i;
                }
            }
            if (selectedIllMedicineList.size() > 1){
                for (int i = 0 ; i < selectedIllMedicineList.size();i++){
                    selectedIllMedicineNameList.add(selectedIllMedicineList.get(i).getMedicine_name());
                }
                selectedIllMedicineNameList.remove(0);
                ill_medicine_name_layout.setVisibility(View.VISIBLE);
                MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(IllActivity.this,getLayoutInflater(),selectedIllMedicineNameList);
                ill_medicine_spinner.setAdapter(medicineOrReportAdapter);
                selectedMedicine = 1;
            }
            else{
                ill_medicine_name_layout.setVisibility(View.GONE);
            }
        }
        catch (Exception ex){

        }
    }

    private void setReportSpinners(){
        try {
            DateSpinnerAdapter dateSpinnerAdapter = new DateSpinnerAdapter(IllActivity.this,getLayoutInflater(),DateList.getDayList());
            ill_report_start_day_spinner.setAdapter(dateSpinnerAdapter);
            DateSpinnerAdapter dateSpinnerAdapter1 = new DateSpinnerAdapter(IllActivity.this,getLayoutInflater(),DateList.getMonthList());
            ill_report_start_month_spinner.setAdapter(dateSpinnerAdapter1);
            ill_report_end_day_spinner.setAdapter(dateSpinnerAdapter);
            ill_report_end_month_spinner.setAdapter(dateSpinnerAdapter1);
            for (int i = 0;i < StaticLists.mainReportModelList.size();i++){
                if (StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no().equals(StaticLists.mainReportModelList.get(i).getTc_kimlik_no())){
                    selectedIllReportList = StaticLists.mainReportModelList.get(i).getSecondReportModelList();
                    selectedIllReportListPosition = i;
                }
            }
            if (selectedIllReportList.size() > 1){
                for (int i = 0 ; i < selectedIllReportList.size();i++){
                    selectedIllReportNameList.add(selectedIllReportList.get(i).getReport_name());
                }
                selectedIllReportNameList.remove(0);
                ill_report_name_layout.setVisibility(View.VISIBLE);
                MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(IllActivity.this,getLayoutInflater(),selectedIllReportNameList);
                ill_report_spinner.setAdapter(medicineOrReportAdapter);
                ill_report_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selectedReport = position+1;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
        catch (Exception ex){

        }
    }

    private void setReportClicks(){
        try {
            ill_report_edit_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_report_name.setText(selectedIllReportList.get(selectedReport).getReport_name());
                    ill_report_info.setText(selectedIllReportList.get(selectedReport).getReportModel().getReport_info());
                    char[] rep_start_dateChar = selectedIllReportList.get(selectedReport).getReportModel().getReport_start_date().toCharArray();
                    char[] rep_end_dateChar = selectedIllReportList.get(selectedReport).getReportModel().getReport_end_date().toCharArray();
                    ill_report_start_day_spinner.setSelection(Integer.parseInt("" + rep_start_dateChar[0] + rep_start_dateChar[1]));
                    ill_report_start_month_spinner.setSelection(Integer.parseInt("" + rep_start_dateChar[3] + rep_start_dateChar[4]));
                    ill_report_start_year_edittext.setText("" + rep_start_dateChar[6] + rep_start_dateChar[7] + rep_start_dateChar[8] + rep_start_dateChar[9]);
                    ill_report_end_day_spinner.setSelection(Integer.parseInt("" + rep_end_dateChar[0] + rep_end_dateChar[1]));
                    ill_report_end_month_spinner.setSelection(Integer.parseInt("" + rep_end_dateChar[3] + rep_end_dateChar[4]));
                    ill_report_end_year_edittext.setText("" + rep_end_dateChar[6] + rep_end_dateChar[7] + rep_end_dateChar[8] + rep_end_dateChar[9]);
                    ill_report_ok_button.setText("Kaydet");
                    ill_report_edit_layout.setVisibility(View.VISIBLE);
                    ill_report_delete_button.setVisibility(View.VISIBLE);
                }
            });
            ill_report_add_report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_report_name.setText("");
                    ill_report_info.setText("");
                    ill_report_start_day_spinner.setSelection(0);
                    ill_report_start_month_spinner.setSelection(0);
                    ill_report_start_year_edittext.setText("");
                    ill_report_end_day_spinner.setSelection(0);
                    ill_report_end_month_spinner.setSelection(0);
                    ill_report_end_year_edittext.setText("");
                    ill_report_delete_button.setVisibility(View.GONE);
                    ill_report_ok_button.setText("Ekle");
                    ill_report_edit_layout.setVisibility(View.VISIBLE);
                }
            });
            ill_report_cancel_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ill_report_edit_layout.setVisibility(View.GONE);
                }
            });
            ill_report_delete_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().remove(selectedReport);
                    refreshReportSpinner();
                }
            });
            ill_report_ok_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ill_report_ok_button.getText().equals("Ekle")){
                        ReportModel reportModel = new ReportModel();
                        SecondReportModel secondReportModel = new SecondReportModel();
                        if (ill_report_name.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Rapor ismi alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_info.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Rapor bilgileri alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_start_day_spinner.getSelectedItemPosition() == 0 || ill_report_start_month_spinner.getSelectedItemPosition() == 0 || ill_report_start_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_end_day_spinner.getSelectedItemPosition() == 0 || ill_report_end_month_spinner.getSelectedItemPosition() == 0 || ill_report_end_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_start_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_end_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else{
                            boolean isSame = false;
                            for (int i = 0; i < StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().size();i++){
                                if (StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().get(i).getReport_name().equals(ill_report_name.getText().toString())){
                                    isSame = true;
                                }
                            }
                            if (isSame){
                                Toast.makeText(IllActivity.this,"Bu isimde bir rapor bu hastaya daha önce eklenmiş !",Toast.LENGTH_LONG).show();
                            }
                            else{
                                reportModel.setReport_info(ill_report_info.getText().toString());
                                reportModel.setReport_start_date(ill_report_start_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_report_start_month_spinner.getSelectedItem().toString()) + "/" + ill_report_start_year_edittext.getText().toString());
                                reportModel.setReport_end_date(ill_report_end_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_report_end_month_spinner.getSelectedItem().toString()) + "/" + ill_report_end_year_edittext.getText().toString());
                                secondReportModel.setReport_name(ill_report_name.getText().toString());
                                secondReportModel.setReportModel(reportModel);
                                StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().add(secondReportModel);
                                Toast.makeText(IllActivity.this,"Rapor eklendi.",Toast.LENGTH_LONG).show();
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                EventModel eventModel = new EventModel();
                                eventModel.setEventName("Rapor Ekleme");
                                eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                                eventModel.setEventDetail("Deneme Hesabı tarafından " + ill_namesurname.getText().toString() + " isimli hastaya " + ill_report_name.getText().toString() + " isimli rapor eklendi.");
                                StaticLists.eventModelList.add(eventModel);
                                if (StaticLists.eventModelList.size() > 20){
                                    StaticLists.eventModelList.remove(0);
                                }
                                refreshReportSpinner();
                            }
                        }
                    }
                    else if (ill_report_ok_button.getText().equals("Kaydet")){
                        ReportModel reportModel = new ReportModel();
                        SecondReportModel secondReportModel = new SecondReportModel();
                        if (ill_report_name.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Rapor ismi alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_info.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Rapor bilgileri alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_start_day_spinner.getSelectedItemPosition() == 0 || ill_report_start_month_spinner.getSelectedItemPosition() == 0 || ill_report_start_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_end_day_spinner.getSelectedItemPosition() == 0 || ill_report_end_month_spinner.getSelectedItemPosition() == 0 || ill_report_end_year_edittext.getText().toString().equals("")){
                            Toast.makeText(IllActivity.this,"Tarih alanı boş bırakılamaz !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_start_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else if (ill_report_end_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(IllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                        }
                        else{
                            boolean isSame = false;
                            for (int i = 0; i < StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().size();i++){
                                if (StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().get(i).getReport_name().equals(ill_report_name.getText().toString()) && i != selectedReport){
                                    isSame = true;
                                }
                            }
                            if (isSame){
                                Toast.makeText(IllActivity.this,"Bu isimde bir rapor bu hastaya daha önce eklenmiş !",Toast.LENGTH_LONG).show();
                            }
                            else{
                                reportModel.setReport_info(ill_report_info.getText().toString());
                                reportModel.setReport_start_date(ill_report_start_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_report_start_month_spinner.getSelectedItem().toString()) + "/" + ill_report_start_year_edittext.getText().toString());
                                reportModel.setReport_end_date(ill_report_end_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(ill_report_end_month_spinner.getSelectedItem().toString()) + "/" + ill_report_end_year_edittext.getText().toString());
                                secondReportModel.setReport_name(ill_report_name.getText().toString());
                                secondReportModel.setReportModel(reportModel);
                                StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().remove(selectedReport);
                                StaticLists.mainReportModelList.get(selectedIllReportListPosition).getSecondReportModelList().add(secondReportModel);
                                Toast.makeText(IllActivity.this,"Rapor yeniden düzenlendi.",Toast.LENGTH_LONG).show();
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                EventModel eventModel = new EventModel();
                                eventModel.setEventName("Rapor Güncelleme");
                                eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                                eventModel.setEventDetail("Deneme Hesabı tarafından " + ill_namesurname.getText().toString() + " isimli hastanın " + ill_report_name.getText().toString() + " isimli raporu güncellendi.");
                                StaticLists.eventModelList.add(eventModel);
                                if (StaticLists.eventModelList.size() > 20){
                                    StaticLists.eventModelList.remove(0);
                                }
                                refreshReportSpinner();
                            }
                        }
                    }
                }
            });
        }
        catch (Exception ex){

        }
    }

    private void refreshReportSpinner(){
        try {
            ill_report_edit_layout.setVisibility(View.GONE);
            selectedIllReportNameList.clear();
            for (int i = 0;i < StaticLists.mainReportModelList.size();i++){
                if (StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no().equals(StaticLists.mainReportModelList.get(i).getTc_kimlik_no())){
                    selectedIllReportList = StaticLists.mainReportModelList.get(i).getSecondReportModelList();
                    selectedIllReportListPosition = i;
                }
            }
            if (selectedIllReportList.size() > 1){
                for (int i = 0 ; i < selectedIllReportList.size();i++){
                    selectedIllReportNameList.add(selectedIllReportList.get(i).getReport_name());
                }
                selectedIllReportNameList.remove(0);
                ill_report_name_layout.setVisibility(View.VISIBLE);
                MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(IllActivity.this,getLayoutInflater(),selectedIllReportNameList);
                ill_report_spinner.setAdapter(medicineOrReportAdapter);
                selectedReport = 1;
            }
            else{
                ill_report_name_layout.setVisibility(View.GONE);
            }
        }
        catch (Exception ex){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                if (data.getStringExtra("result_key").equals("edit_ok")){
                    ill_namesurname.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getName_surname());
                    ill_tckimlik.setText(StaticLists.mainIllnessModelList.get(listPosition).getTc_kimlik_no());
                    ill_illness.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getIll());
                    ill_sex.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getSex());
                    ill_birthdate.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getBirthdate());
                    ill_lastdate.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_exit_date());
                    if (StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_or_exit().equals("Enter")){
                        ill_fromemployee.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getFromemployee() + " tarafından girişi yapıldı.");
                    }
                    else{
                        ill_fromemployee.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getFromemployee() + " tarafından çıkışı yapıldı.");
                    }
                }
            }
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
