package com.mkpatir.engelsizyasam.activitys;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.DateSpinnerAdapter;
import com.mkpatir.engelsizyasam.adapters.MedicineOrReportAdapter;
import com.mkpatir.engelsizyasam.adapters.SexSpinnerAdapter;
import com.mkpatir.engelsizyasam.extras.DateList;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.EventModel;
import com.mkpatir.engelsizyasam.models.IllnessModel;
import com.mkpatir.engelsizyasam.models.MainIllnessModel;
import com.mkpatir.engelsizyasam.models.MainMedicineModel;
import com.mkpatir.engelsizyasam.models.MainReportModel;
import com.mkpatir.engelsizyasam.models.MedicineModel;
import com.mkpatir.engelsizyasam.models.ReportModel;
import com.mkpatir.engelsizyasam.models.SecondMedicineModel;
import com.mkpatir.engelsizyasam.models.SecondReportModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddIllnessActivity extends AppCompatActivity {

    Spinner addillness_sex_spinner;
    Spinner addillness_day_spinner;
    Spinner addillness_month_spinner;
    Spinner addillness_g_day_spinner;
    Spinner addillness_g_month_spinner;
    Spinner addillness_i_day_spinner;
    Spinner addillness_i_month_spinner;
    Spinner addillness_rs_day_spinner;
    Spinner addillness_rs_month_spinner;
    Spinner addillness_re_day_spinner;
    Spinner addillness_re_month_spinner;
    EditText addillness_rs_year_edittext;
    EditText addillness_re_year_edittext;
    EditText addillness_i_year_edittext;
    EditText addillness_year_edittext;
    EditText addillness_g_year_edittext;
    EditText addilness_tckimlik_edittext;
    EditText addillness_namesurname_edittext;
    EditText addillness_ill_edittext;
    EditText addillness_fromemployee_edittext;
    CardView addillness_add_medicine_cardview;
    CardView addillness_add_report_cardview;
    Button addillness_add_medicine_button;
    Button addillness_add_report_button;
    ImageView addillness_add_medicine_close;
    ImageView addillness_add_report_close;
    LinearLayout addillness_added_medicine_layout;
    LinearLayout addillness_added_report_layout;
    Button addillness_add_medicine;
    Button addillness_add_report;
    EditText addillness_add_medicine_name;
    EditText addillness_add_medicine_directions;
    EditText addillness_add_report_name;
    EditText addillness_add_report_info;
    Spinner addillness_added_medicine_spinner;
    Spinner addillness_added_report_spinner;
    Button addillness_added_medicine_editbutton;
    Button addillness_added_report_editbutton;
    Button addillness_add_medicine_delete;
    Button addillness_add_report_delete;
    Button addillness_add_illness_button;
    MainIllnessModel mainIllnessModel = new MainIllnessModel();
    IllnessModel illnessModel = new IllnessModel();
    List<MedicineModel> medicineModelList = new ArrayList<>();
    List<String> medicineNameList = new ArrayList<>();
    List<ReportModel> reportModelList = new ArrayList<>();
    List<String> reportNameList = new ArrayList<>();
    int selectedMedicineCounter = 0;
    int selectedReportCounter = 0;
    String day = "";
    String month = "";
    String year = "";
    String g_day = "";
    String g_month = "";
    String g_year = "";
    String i_day = "";
    String i_month = "";
    String i_year = "";
    String rs_day = "";
    String rs_month = "";
    String rs_year = "";
    String re_day = "";
    String re_month = "";
    String re_year = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_illness);
        addillness_sex_spinner = (Spinner)findViewById(R.id.addillness_sex_spinner);
        addillness_day_spinner = (Spinner)findViewById(R.id.addillness_day_spinner);
        addillness_month_spinner = (Spinner)findViewById(R.id.addillness_month_spinner);
        addillness_g_day_spinner = (Spinner)findViewById(R.id.addillness_g_day_spinner);
        addillness_g_month_spinner = (Spinner)findViewById(R.id.addillness_g_month_spinner);
        addillness_year_edittext = (EditText)findViewById(R.id.addillness_year_edittext);
        addillness_g_year_edittext = (EditText)findViewById(R.id.addillness_g_year_edittext);
        addillness_i_day_spinner = (Spinner)findViewById(R.id.addillness_i_day_spinner);
        addillness_i_month_spinner = (Spinner)findViewById(R.id.addillness_i_month_spinner);
        addillness_i_year_edittext = (EditText)findViewById(R.id.addillness_i_year_edittext);
        addillness_rs_day_spinner = (Spinner)findViewById(R.id.addillness_rs_day_spinner);
        addillness_rs_month_spinner = (Spinner)findViewById(R.id.addillness_rs_month_spinner);
        addillness_re_day_spinner = (Spinner)findViewById(R.id.addillness_re_day_spinner);
        addillness_re_month_spinner = (Spinner)findViewById(R.id.addillness_re_month_spinner);
        addillness_rs_year_edittext = (EditText)findViewById(R.id.addillness_rs_year_edittext);
        addillness_re_year_edittext = (EditText)findViewById(R.id.addillness_re_year_edittext);
        addilness_tckimlik_edittext = (EditText)findViewById(R.id.addilness_tckimlik_edittext);
        addillness_namesurname_edittext = (EditText)findViewById(R.id.addillness_namesurname_edittext);
        addillness_ill_edittext = (EditText)findViewById(R.id.addillness_ill_edittext);
        addillness_fromemployee_edittext = (EditText)findViewById(R.id.addillness_fromemployee_edittext);
        addillness_add_medicine_cardview = (CardView)findViewById(R.id.addillness_add_medicine_cardview);
        addillness_add_report_cardview = (CardView)findViewById(R.id.addillness_add_report_cardview);
        addillness_add_medicine_button = (Button)findViewById(R.id.addillness_add_medicine_button);
        addillness_add_report_button = (Button)findViewById(R.id.addillness_add_report_button);
        addillness_add_medicine_close = (ImageView)findViewById(R.id.addillness_add_medicine_close);
        addillness_add_report_close = (ImageView)findViewById(R.id.addillness_add_report_close);
        addillness_added_medicine_layout = (LinearLayout)findViewById(R.id.addillness_added_medicine_layout);
        addillness_added_report_layout = (LinearLayout)findViewById(R.id.addillness_added_report_layout);
        addillness_add_medicine = (Button)findViewById(R.id.addillness_add_medicine);
        addillness_add_report = (Button)findViewById(R.id.addillness_add_report);
        addillness_add_medicine_name = (EditText)findViewById(R.id.addillness_add_medicine_name);
        addillness_add_medicine_directions = (EditText)findViewById(R.id.addillness_add_medicine_directions);
        addillness_added_medicine_spinner = (Spinner)findViewById(R.id.addillness_added_medicine_spinner);
        addillness_add_report_name = (EditText)findViewById(R.id.addillness_add_report_name);
        addillness_add_report_info = (EditText)findViewById(R.id.addillness_add_report_info);
        addillness_added_report_spinner = (Spinner)findViewById(R.id.addillness_added_report_spinner);
        addillness_added_medicine_editbutton = (Button)findViewById(R.id.addillness_added_medicine_editbutton);
        addillness_added_report_editbutton = (Button)findViewById(R.id.addillness_added_report_editbutton);
        addillness_add_medicine_delete = (Button)findViewById(R.id.addillness_add_medicine_delete);
        addillness_add_report_delete = (Button)findViewById(R.id.addillness_add_report_delete);
        addillness_add_illness_button = (Button)findViewById(R.id.addillness_add_illness_button);
        getSupportActionBar().setTitle("Hasta Ekle");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSpinner();
        setClicks();
        addIllness();
    }

    public void setSpinner(){
        try {
            SexSpinnerAdapter sexSpinnerAdapter = new SexSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater());
            addillness_sex_spinner.setAdapter(sexSpinnerAdapter);
            addillness_sex_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 1){
                        illnessModel.setSex("Erkek");
                    }
                    else if (position == 2){
                        illnessModel.setSex("Kadın");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter dayAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getDayList());
            addillness_day_spinner.setAdapter(dayAdapter);
            addillness_day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    day = DateList.getDayList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter monthAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getMonthList());
            addillness_month_spinner.setAdapter(monthAdapter);
            addillness_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    month = DateList.getMonthList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter g_dayAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getDayList());
            addillness_g_day_spinner.setAdapter(g_dayAdapter);
            addillness_g_day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g_day = DateList.getDayList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter g_monthAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getMonthList());
            addillness_g_month_spinner.setAdapter(g_monthAdapter);
            addillness_g_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    g_month = DateList.getMonthList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter i_dayAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getDayList());
            addillness_i_day_spinner.setAdapter(i_dayAdapter);
            addillness_i_day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    i_day = DateList.getDayList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter i_monthAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getMonthList());
            addillness_i_month_spinner.setAdapter(i_monthAdapter);
            addillness_i_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    i_month = DateList.getMonthList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter rs_dayAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getDayList());
            addillness_rs_day_spinner.setAdapter(rs_dayAdapter);
            addillness_rs_day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    rs_day = DateList.getDayList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter rs_monthAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getMonthList());
            addillness_rs_month_spinner.setAdapter(rs_monthAdapter);
            addillness_rs_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    rs_month = DateList.getMonthList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter re_dayAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getDayList());
            addillness_re_day_spinner.setAdapter(re_dayAdapter);
            addillness_re_day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    re_day = DateList.getDayList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            DateSpinnerAdapter re_monthAdapter = new DateSpinnerAdapter(AddIllnessActivity.this,getLayoutInflater(),DateList.getMonthList());
            addillness_re_month_spinner.setAdapter(re_monthAdapter);
            addillness_re_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    re_month = DateList.getMonthList()[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            addillness_added_medicine_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedMedicineCounter = position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            addillness_added_report_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedReportCounter = position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        catch (Exception ex){

        }
    }

    public void setClicks(){
        try {
            addillness_add_medicine_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addillness_add_medicine.setText("Ekle");
                    addillness_add_medicine_delete.setVisibility(View.GONE);
                    addillness_add_medicine_cardview.setVisibility(View.VISIBLE);
                }
            });
            addillness_add_medicine_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addillness_add_medicine_name.setText("");
                    addillness_add_medicine_directions.setText("");
                    addillness_i_day_spinner.setSelection(0);
                    addillness_i_month_spinner.setSelection(0);
                    addillness_i_year_edittext.setText("");
                    addillness_add_medicine_delete.setVisibility(View.GONE);
                    addillness_add_medicine_cardview.setVisibility(View.GONE);
                }
            });
            addillness_add_report_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addillness_add_report.setText("Ekle");
                    addillness_add_report_delete.setVisibility(View.GONE);
                    addillness_add_report_cardview.setVisibility(View.VISIBLE);
                }
            });
            addillness_add_report_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addillness_add_report_name.setText("");
                    addillness_add_report_info.setText("");
                    addillness_rs_day_spinner.setSelection(0);
                    addillness_rs_month_spinner.setSelection(0);
                    addillness_rs_year_edittext.setText("");
                    addillness_re_day_spinner.setSelection(0);
                    addillness_re_month_spinner.setSelection(0);
                    addillness_re_year_edittext.setText("");
                    addillness_add_report_delete.setVisibility(View.GONE);
                    addillness_add_report_cardview.setVisibility(View.GONE);
                }
            });

            /*

            Add Medicine Click

             */

            addillness_add_medicine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (addillness_add_medicine.getText().equals("Ekle")){
                        boolean isSame = false;
                        if (!medicineNameList.isEmpty()){
                            for (int i = 0;i < medicineNameList.size();i++){
                                if (addillness_add_medicine_name.getText().toString().equals(medicineNameList.get(i))){
                                    isSame = true;
                                }
                            }
                        }
                        if (addillness_add_medicine_name.getText().toString().equals("") || addillness_add_medicine_directions.getText().toString().equals("") || i_day.equals("") || i_month.equals("") || addillness_i_year_edittext.getText().toString().equals("")){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen boş alan bırakmayınız !",Toast.LENGTH_LONG).show();
                        }
                        else if (addillness_i_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen geçerli bir yıl giriniz !",Toast.LENGTH_LONG).show();
                        }
                        else if (isSame){
                            Toast.makeText(AddIllnessActivity.this,"Bu isimde bir ilaç zaten listede var !",Toast.LENGTH_LONG).show();
                        }
                        else {
                            medicineNameList.add(addillness_add_medicine_name.getText().toString());
                            MedicineModel medicineModel = new MedicineModel();
                            medicineModel.setDirections_for_use(addillness_add_medicine_directions.getText().toString());
                            medicineModel.setStart_date(i_day + "/" + DateList.getMonthNumber(i_month) + "/" + addillness_i_year_edittext.getText().toString());
                            medicineModelList.add(medicineModel);
                            MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),medicineNameList);
                            addillness_added_medicine_spinner.setAdapter(medicineOrReportAdapter);
                            addillness_added_medicine_layout.setVisibility(View.VISIBLE);
                            Toast.makeText(AddIllnessActivity.this,"İlaç listeye eklendi.",Toast.LENGTH_LONG).show();
                            addillness_add_medicine_name.setText("");
                            addillness_add_medicine_directions.setText("");
                            addillness_i_day_spinner.setSelection(0);
                            addillness_i_month_spinner.setSelection(0);
                            addillness_i_year_edittext.setText("");
                            addillness_add_medicine_cardview.setVisibility(View.GONE);
                        }
                    }
                    else if (addillness_add_medicine.getText().equals("Kaydet")){
                        boolean isSame = false;
                        if (!medicineNameList.isEmpty()){
                            for (int i = 0;i < medicineNameList.size();i++){
                                if (addillness_add_medicine_name.getText().toString().equals(medicineNameList.get(i)) && i != selectedMedicineCounter){
                                    isSame = true;
                                }
                            }
                        }
                        if (addillness_add_medicine_name.getText().toString().equals("") || addillness_add_medicine_directions.getText().toString().equals("") || i_day.equals("") || i_month.equals("") || addillness_i_year_edittext.getText().toString().equals("")){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen boş alan bırakmayınız !",Toast.LENGTH_LONG).show();
                        }
                        else if (addillness_i_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen geçerli bir yıl giriniz !",Toast.LENGTH_LONG).show();
                        }
                        else if (isSame){
                            Toast.makeText(AddIllnessActivity.this,"Bu isimde bir ilaç zaten listede var !",Toast.LENGTH_LONG).show();
                        }
                        else {
                            medicineNameList.remove(selectedMedicineCounter);
                            medicineNameList.add(addillness_add_medicine_name.getText().toString());
                            MedicineModel medicineModel = new MedicineModel();
                            medicineModel.setDirections_for_use(addillness_add_medicine_directions.getText().toString());
                            medicineModel.setStart_date(i_day + "/" + DateList.getMonthNumber(i_month) + "/" + addillness_i_year_edittext.getText().toString());
                            medicineModelList.remove(selectedMedicineCounter);
                            medicineModelList.add(selectedMedicineCounter,medicineModel);
                            MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),medicineNameList);
                            addillness_added_medicine_spinner.setAdapter(medicineOrReportAdapter);
                            addillness_added_medicine_layout.setVisibility(View.VISIBLE);
                            Toast.makeText(AddIllnessActivity.this,"İlaç yeniden düzenlendi.",Toast.LENGTH_LONG).show();
                            addillness_add_medicine_name.setText("");
                            addillness_add_medicine_directions.setText("");
                            addillness_i_day_spinner.setSelection(0);
                            addillness_i_month_spinner.setSelection(0);
                            addillness_i_year_edittext.setText("");
                            addillness_add_medicine_cardview.setVisibility(View.GONE);
                        }
                    }
                }
            });

            /*

            Added Medicine Edit Button Click

             */

            addillness_added_medicine_editbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    char[] s_date_char = medicineModelList.get(selectedMedicineCounter).getStart_date().toCharArray();
                    String s_i_day = "" + s_date_char[0] + s_date_char[1];
                    String s_i_month = "" + s_date_char[3] + s_date_char[4];
                    String s_i_year = "" + s_date_char[6] + s_date_char[7] + s_date_char[8] + s_date_char[9];
                    addillness_add_medicine_name.setText(medicineNameList.get(selectedMedicineCounter));
                    addillness_add_medicine_directions.setText(medicineModelList.get(selectedMedicineCounter).getDirections_for_use());
                    addillness_i_day_spinner.setSelection(Integer.parseInt(s_i_day));
                    addillness_i_month_spinner.setSelection(Integer.parseInt(s_i_month));
                    addillness_i_year_edittext.setText(s_i_year);
                    addillness_add_medicine.setText("Kaydet");
                    addillness_add_medicine_delete.setVisibility(View.VISIBLE);
                    addillness_add_medicine_cardview.setVisibility(View.VISIBLE);
                }
            });

            /*

            Added Medicine Delete Click

             */

            addillness_add_medicine_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    medicineNameList.remove(selectedMedicineCounter);
                    medicineModelList.remove(selectedMedicineCounter);
                    if (medicineNameList.size() == 0){
                        addillness_added_medicine_layout.setVisibility(View.GONE);
                    }
                    MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),medicineNameList);
                    addillness_added_medicine_spinner.setAdapter(medicineOrReportAdapter);
                    addillness_add_medicine_name.setText("");
                    addillness_add_medicine_directions.setText("");
                    addillness_i_day_spinner.setSelection(0);
                    addillness_i_month_spinner.setSelection(0);
                    addillness_i_year_edittext.setText("");
                    addillness_add_medicine_cardview.setVisibility(View.GONE);
                }
            });

            /*

            Add Report Click

             */

            addillness_add_report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (addillness_add_report.getText().equals("Ekle")){
                        boolean isSame = false;
                        if (!reportNameList.isEmpty()){
                            for (int i = 0;i < reportNameList.size();i++){
                                if (addillness_add_report_name.getText().toString().equals(reportNameList.get(i))){
                                    isSame = true;
                                }
                            }
                        }
                        if (addillness_add_report_name.getText().toString().equals("") || addillness_add_report_info.getText().toString().equals("") || re_day.equals("") || re_month.equals("") || addillness_re_year_edittext.getText().toString().equals("")
                                || rs_day.equals("") || rs_month.equals("") || addillness_rs_year_edittext.getText().toString().equals("")){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen boş alan bırakmayınız !",Toast.LENGTH_LONG).show();
                        }
                        else if (addillness_re_year_edittext.getText().toString().length() != 4 || addillness_re_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen geçerli bir yıl giriniz !",Toast.LENGTH_LONG).show();
                        }
                        else if (isSame){
                            Toast.makeText(AddIllnessActivity.this,"Bu isimde bir rapor zaten listede var !",Toast.LENGTH_LONG).show();
                        }
                        else {
                            reportNameList.add(addillness_add_report_name.getText().toString());
                            ReportModel reportModel = new ReportModel();
                            reportModel.setReport_info(addillness_add_report_info.getText().toString());
                            reportModel.setReport_start_date(rs_day + "/" + DateList.getMonthNumber(rs_month) + "/" + addillness_rs_year_edittext.getText().toString());
                            reportModel.setReport_end_date(re_day + "/" + DateList.getMonthNumber(re_month) + "/" + addillness_re_year_edittext.getText().toString());
                            reportModelList.add(reportModel);
                            MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),reportNameList);
                            addillness_added_report_spinner.setAdapter(medicineOrReportAdapter);
                            addillness_added_report_layout.setVisibility(View.VISIBLE);
                            Toast.makeText(AddIllnessActivity.this,"Rapor listeye eklendi.",Toast.LENGTH_LONG).show();
                            addillness_add_report_name.setText("");
                            addillness_add_report_info.setText("");
                            addillness_rs_day_spinner.setSelection(0);
                            addillness_rs_month_spinner.setSelection(0);
                            addillness_rs_year_edittext.setText("");
                            addillness_re_day_spinner.setSelection(0);
                            addillness_re_month_spinner.setSelection(0);
                            addillness_re_year_edittext.setText("");
                            addillness_add_report_cardview.setVisibility(View.GONE);
                        }
                    }
                    else if (addillness_add_report.getText().equals("Kaydet")){
                        boolean isSame = false;
                        if (!reportNameList.isEmpty()){
                            for (int i = 0;i < reportNameList.size();i++){
                                if (addillness_add_report_name.getText().toString().equals(reportNameList.get(i)) && i != selectedReportCounter){
                                    isSame = true;
                                }
                            }
                        }
                        if (addillness_add_report_name.getText().toString().equals("") || addillness_add_report_info.getText().toString().equals("") || re_day.equals("") || re_month.equals("") || addillness_re_year_edittext.getText().toString().equals("")
                                || rs_day.equals("") || rs_month.equals("") || addillness_rs_year_edittext.getText().toString().equals("")){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen boş alan bırakmayınız !",Toast.LENGTH_LONG).show();
                        }
                        else if (addillness_re_year_edittext.getText().toString().length() != 4 || addillness_re_year_edittext.getText().toString().length() != 4){
                            Toast.makeText(AddIllnessActivity.this,"Lütfen geçerli bir yıl giriniz !",Toast.LENGTH_LONG).show();
                        }
                        else if (isSame){
                            Toast.makeText(AddIllnessActivity.this,"Bu isimde bir rapor zaten listede var !",Toast.LENGTH_LONG).show();
                        }
                        else {
                            reportNameList.remove(selectedReportCounter);
                            reportNameList.add(addillness_add_report_name.getText().toString());
                            ReportModel reportModel = new ReportModel();
                            reportModel.setReport_info(addillness_add_report_info.getText().toString());
                            reportModel.setReport_start_date(rs_day + "/" + DateList.getMonthNumber(rs_month) + "/" + addillness_rs_year_edittext.getText().toString());
                            reportModel.setReport_end_date(re_day + "/" + DateList.getMonthNumber(re_month) + "/" + addillness_re_year_edittext.getText().toString());
                            reportModelList.remove(selectedReportCounter);
                            reportModelList.add(reportModel);
                            MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),reportNameList);
                            addillness_added_report_spinner.setAdapter(medicineOrReportAdapter);
                            addillness_added_report_layout.setVisibility(View.VISIBLE);
                            Toast.makeText(AddIllnessActivity.this,"Rapor yeniden düzenlendi.",Toast.LENGTH_LONG).show();
                            addillness_add_report_name.setText("");
                            addillness_add_report_info.setText("");
                            addillness_rs_day_spinner.setSelection(0);
                            addillness_rs_month_spinner.setSelection(0);
                            addillness_rs_year_edittext.setText("");
                            addillness_re_day_spinner.setSelection(0);
                            addillness_re_month_spinner.setSelection(0);
                            addillness_re_year_edittext.setText("");
                            addillness_add_report_cardview.setVisibility(View.GONE);
                        }
                    }
                }
            });

            /*

            Added Report Edit Button Click

             */

            addillness_added_report_editbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    char[] s_date_char = reportModelList.get(selectedReportCounter).getReport_start_date().toCharArray();
                    char[] e_date_char = reportModelList.get(selectedReportCounter).getReport_end_date().toCharArray();
                    String s_r_day = "" + s_date_char[0] + s_date_char[1];
                    String s_r_month = "" + s_date_char[3] + s_date_char[4];
                    String s_r_year = "" + s_date_char[6] + s_date_char[7] + s_date_char[8] + s_date_char[9];
                    String e_r_day = "" + e_date_char[0] + e_date_char[1];
                    String e_r_month = "" + e_date_char[3] + e_date_char[4];
                    String e_r_year = "" + e_date_char[6] + e_date_char[7] + e_date_char[8] + e_date_char[9];
                    addillness_add_report_name.setText(reportNameList.get(selectedReportCounter));
                    addillness_add_report_info.setText(reportModelList.get(selectedReportCounter).getReport_info());
                    addillness_rs_day_spinner.setSelection(Integer.parseInt(s_r_day));
                    addillness_rs_month_spinner.setSelection(Integer.parseInt(s_r_month));
                    addillness_rs_year_edittext.setText(s_r_year);
                    addillness_re_day_spinner.setSelection(Integer.parseInt(e_r_day));
                    addillness_re_month_spinner.setSelection(Integer.parseInt(e_r_month));
                    addillness_re_year_edittext.setText(e_r_year);
                    addillness_add_report.setText("Kaydet");
                    addillness_add_report_delete.setVisibility(View.VISIBLE);
                    addillness_add_report_cardview.setVisibility(View.VISIBLE);
                }
            });

            /*

            Added Report Delete Click

             */

            addillness_add_report_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reportNameList.remove(selectedReportCounter);
                    reportModelList.remove(selectedReportCounter);
                    if (reportNameList.size() == 0){
                        addillness_added_report_layout.setVisibility(View.GONE);
                    }
                    MedicineOrReportAdapter medicineOrReportAdapter = new MedicineOrReportAdapter(AddIllnessActivity.this,getLayoutInflater(),reportNameList);
                    addillness_added_report_spinner.setAdapter(medicineOrReportAdapter);
                    addillness_add_report_name.setText("");
                    addillness_add_report_info.setText("");
                    addillness_rs_day_spinner.setSelection(0);
                    addillness_rs_month_spinner.setSelection(0);
                    addillness_rs_year_edittext.setText("");
                    addillness_re_day_spinner.setSelection(0);
                    addillness_re_month_spinner.setSelection(0);
                    addillness_re_year_edittext.setText("");
                    addillness_add_report_cardview.setVisibility(View.GONE);
                }
            });
        }
        catch (Exception ex){

        }
    }

    public void addIllness(){
        try {
            addillness_add_illness_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (addilness_tckimlik_edittext.getText().toString().equals("")){
                        Toast.makeText(AddIllnessActivity.this,"TC Kimlik Alanı Boş Bırakılamaz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addilness_tckimlik_edittext.getText().toString().length() != 11){
                        Toast.makeText(AddIllnessActivity.this,"TC Kimlik Numarası 11 Haneli Olmalıdır !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_namesurname_edittext.getText().toString().equals("")){
                        Toast.makeText(AddIllnessActivity.this,"İsim Soyisim Alanı Boş Bırakılamaz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_year_edittext.getText().toString().equals("") || day.equals("") || month.equals("")){
                        Toast.makeText(AddIllnessActivity.this,"Doğum Tarihi Girmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_ill_edittext.getText().toString().equals("")){
                        Toast.makeText(AddIllnessActivity.this,"Hastalık Alanı Boş Bırakılamaz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_sex_spinner.getSelectedItemPosition() == 0){
                        Toast.makeText(AddIllnessActivity.this,"Cinsiyet Seçmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (g_day.equals("") || g_month.equals("") || addillness_g_year_edittext.getText().toString().equals("")){
                        Toast.makeText(AddIllnessActivity.this,"Hasta Giriş Tarihini Girmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_fromemployee_edittext.getText().toString().equals("")){
                        Toast.makeText(AddIllnessActivity.this,"Hasta Girişini Kimin Yaptığını Girmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (addillness_year_edittext.getText().toString().length() != 4 || addillness_g_year_edittext.getText().toString().length() != 4){
                        Toast.makeText(AddIllnessActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                    }
                    else{
                        boolean isSameIll = false;
                        for (int i = 0; i < StaticLists.mainIllnessModelList.size();i++){
                            if (addilness_tckimlik_edittext.getText().toString().equals(StaticLists.mainIllnessModelList.get(i).getTc_kimlik_no())){
                                isSameIll = true;
                            }
                        }
                        if (isSameIll){
                            Toast.makeText(AddIllnessActivity.this,"Kayıtlarda bu tc kimlik numarasına sahip bir hasta var",Toast.LENGTH_LONG).show();
                        }
                        else{
                            illnessModel.setName_surname(addillness_namesurname_edittext.getText().toString());
                            illnessModel.setBirthdate(day + "/" + DateList.getMonthNumber(month)+ "/" + addillness_year_edittext.getText().toString());
                            illnessModel.setIll(addillness_ill_edittext.getText().toString());
                            illnessModel.setEnter_exit_date(g_day + "/" + DateList.getMonthNumber(g_month) + "/" + addillness_g_year_edittext.getText().toString());
                            illnessModel.setEnter_or_exit("Enter");
                            illnessModel.setFromemployee(addillness_fromemployee_edittext.getText().toString());
                            mainIllnessModel.setTc_kimlik_no(addilness_tckimlik_edittext.getText().toString());
                            mainIllnessModel.setIllness_model(illnessModel);
                        /*

                        Deneme Verileri

                         */
                            StaticLists.mainIllnessModelList.add(mainIllnessModel);
                            if (!medicineModelList.isEmpty()){
                                List<SecondMedicineModel> secondMedicineModelList = new ArrayList<>();
                                SecondMedicineModel secondMedicineModel_def = new SecondMedicineModel();
                                secondMedicineModel_def.setMedicine_name("default_medicine");
                                secondMedicineModel_def.setMedicineModel(null);
                                secondMedicineModelList.add(secondMedicineModel_def);
                                for (int i = 0; i< medicineModelList.size();i++){
                                    SecondMedicineModel secondMedicineModel = new SecondMedicineModel();
                                    secondMedicineModel.setMedicine_name(medicineNameList.get(i));
                                    secondMedicineModel.setMedicineModel(medicineModelList.get(i));
                                    secondMedicineModelList.add(secondMedicineModel);
                                }
                                MainMedicineModel mainMedicineModel = new MainMedicineModel();
                                mainMedicineModel.setTc_kimlik_no(addilness_tckimlik_edittext.getText().toString());
                                mainMedicineModel.setSecondMedicineModelList(secondMedicineModelList);
                                StaticLists.mainMedicineModelList.add(mainMedicineModel);
                            }
                            else{
                                List<SecondMedicineModel> secondMedicineModelList = new ArrayList<>();
                                SecondMedicineModel secondMedicineModel_def = new SecondMedicineModel();
                                secondMedicineModel_def.setMedicine_name("default_medicine");
                                secondMedicineModel_def.setMedicineModel(null);
                                secondMedicineModelList.add(secondMedicineModel_def);
                                MainMedicineModel mainMedicineModel = new MainMedicineModel();
                                mainMedicineModel.setTc_kimlik_no(addilness_tckimlik_edittext.getText().toString());
                                mainMedicineModel.setSecondMedicineModelList(secondMedicineModelList);
                                StaticLists.mainMedicineModelList.add(mainMedicineModel);
                            }
                            if (!reportModelList.isEmpty()){
                                List<SecondReportModel> secondReportModelList = new ArrayList<>();
                                SecondReportModel secondReportModel_def = new SecondReportModel();
                                secondReportModel_def.setReport_name("default_report");
                                secondReportModel_def.setReportModel(null);
                                secondReportModelList.add(secondReportModel_def);
                                for (int i = 0; i < reportModelList.size();i++){
                                    SecondReportModel secondReportModel = new SecondReportModel();
                                    secondReportModel.setReport_name(reportNameList.get(i));
                                    secondReportModel.setReportModel(reportModelList.get(i));
                                    secondReportModelList.add(secondReportModel);
                                }
                                MainReportModel mainReportModel = new MainReportModel();
                                mainReportModel.setTc_kimlik_no(addilness_tckimlik_edittext.getText().toString());
                                mainReportModel.setSecondReportModelList(secondReportModelList);
                                StaticLists.mainReportModelList.add(mainReportModel);
                            }
                            else{
                                List<SecondReportModel> secondReportModelList = new ArrayList<>();
                                SecondReportModel secondReportModel = new SecondReportModel();
                                secondReportModel.setReport_name("default_report");
                                secondReportModel.setReportModel(null);
                                secondReportModelList.add(secondReportModel);
                                MainReportModel mainReportModel = new MainReportModel();
                                mainReportModel.setTc_kimlik_no(addilness_tckimlik_edittext.getText().toString());
                                mainReportModel.setSecondReportModelList(secondReportModelList);
                                StaticLists.mainReportModelList.add(mainReportModel);
                            }
                            Calendar calendar = Calendar.getInstance();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            EventModel eventModel = new EventModel();
                            eventModel.setEventName("Hasta Ekleme");
                            eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                            eventModel.setEventDetail("Deneme Hesabı tarafından " + addillness_namesurname_edittext.getText().toString() + " isimli hasta eklendi.");
                            StaticLists.eventModelList.add(eventModel);
                            if (StaticLists.eventModelList.size() > 20){
                                StaticLists.eventModelList.remove(0);
                            }
                        /*

                        Deneme Verileri Sonu

                         */
                            Toast.makeText(AddIllnessActivity.this,"Hasta başarıyla eklendi.",Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
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
