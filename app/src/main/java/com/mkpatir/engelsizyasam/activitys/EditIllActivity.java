package com.mkpatir.engelsizyasam.activitys;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mkpatir.engelsizyasam.R;
import com.mkpatir.engelsizyasam.adapters.DateSpinnerAdapter;
import com.mkpatir.engelsizyasam.adapters.SexSpinnerAdapter;
import com.mkpatir.engelsizyasam.extras.DateList;
import com.mkpatir.engelsizyasam.extras.StaticLists;
import com.mkpatir.engelsizyasam.models.EventModel;
import com.mkpatir.engelsizyasam.models.IllnessModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditIllActivity extends AppCompatActivity {

    EditText edit_ill_name_surname_edittext;
    Spinner edit_ill_day_spinner;
    Spinner edit_ill_month_spinner;
    EditText edit_ill_year_edittext;
    EditText edit_ill_illness_edittext;
    Spinner edit_ill_sex_spinner;
    CheckBox edit_ill_enter_or_exit_checkbox;
    Button edit_ill_save_button;
    private int listPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ill);
        getSupportActionBar().setTitle("Hastayı Düzenle");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.AppColor1)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edit_ill_name_surname_edittext = (EditText)findViewById(R.id.edit_ill_namesurname_edittext);
        edit_ill_day_spinner = (Spinner)findViewById(R.id.edit_ill_day_spinner);
        edit_ill_month_spinner = (Spinner)findViewById(R.id.edit_ill_month_spinner);
        edit_ill_year_edittext = (EditText)findViewById(R.id.edit_ill_year_edittext);
        edit_ill_illness_edittext = (EditText)findViewById(R.id.edit_ill_illness_edittext);
        edit_ill_sex_spinner = (Spinner)findViewById(R.id.edit_ill_sex_spinner);
        edit_ill_enter_or_exit_checkbox = (CheckBox)findViewById(R.id.edit_ill_enter_or_exit_checkbox);
        edit_ill_save_button = (Button) findViewById(R.id.edit_ill_save_button);
        Intent intent = getIntent();
        listPosition = intent.getIntExtra("listPosition",0);
        edit_ill_name_surname_edittext.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getName_surname());
        edit_ill_illness_edittext.setText(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getIll());
        if (StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_or_exit().equals("Exit")){
            edit_ill_enter_or_exit_checkbox.setText("Girişini Yap");
        }
        setSpinners();
        saveEdits();
    }

    private void setSpinners(){
        try {
            DateSpinnerAdapter dateSpinnerAdapter = new DateSpinnerAdapter(EditIllActivity.this,getLayoutInflater(),DateList.getDayList());
            edit_ill_day_spinner.setAdapter(dateSpinnerAdapter);
            DateSpinnerAdapter dateSpinnerAdapter1 = new DateSpinnerAdapter(EditIllActivity.this,getLayoutInflater(),DateList.getMonthList());
            edit_ill_month_spinner.setAdapter(dateSpinnerAdapter1);
            SexSpinnerAdapter sexSpinnerAdapter = new SexSpinnerAdapter(EditIllActivity.this,getLayoutInflater());
            edit_ill_sex_spinner.setAdapter(sexSpinnerAdapter);
            char[] dateChar = StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getBirthdate().toCharArray();
            edit_ill_day_spinner.setSelection(Integer.parseInt("" + dateChar[0] + dateChar[1]));
            edit_ill_month_spinner.setSelection(Integer.parseInt("" + dateChar[3] + dateChar[4]));
            edit_ill_year_edittext.setText("" + dateChar[6] + dateChar[7] + dateChar[8] + dateChar[9]);
            if (StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getSex().equals("Erkek")){
                edit_ill_sex_spinner.setSelection(1);
            }
            else if (StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getSex().equals("Kadın")){
                edit_ill_sex_spinner.setSelection(2);
            }
        }
        catch (Exception ex){

        }
    }

    private void saveEdits(){
        try {
            edit_ill_save_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit_ill_name_surname_edittext.getText().toString().equals("")){
                        Toast.makeText(EditIllActivity.this,"İsim Soyisim Alanı Boş Bırakılamaz !",Toast.LENGTH_LONG).show();
                    }
                    else if (edit_ill_year_edittext.getText().toString().equals("") || edit_ill_day_spinner.getSelectedItemPosition() == 0 || edit_ill_month_spinner.getSelectedItemPosition() == 0){
                        Toast.makeText(EditIllActivity.this,"Doğum Tarihi Girmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (edit_ill_illness_edittext.getText().toString().equals("")){
                        Toast.makeText(EditIllActivity.this,"Hastalık Alanı Boş Bırakılamaz !",Toast.LENGTH_LONG).show();
                    }
                    else if (edit_ill_sex_spinner.getSelectedItemPosition() == 0){
                        Toast.makeText(EditIllActivity.this,"Cinsiyet Seçmelisiniz !",Toast.LENGTH_LONG).show();
                    }
                    else if (edit_ill_year_edittext.getText().toString().length() != 4){
                        Toast.makeText(EditIllActivity.this,"Yıl 4 haneli olmalıdır !",Toast.LENGTH_LONG).show();
                    }
                    else{
                        IllnessModel illnessModel = new IllnessModel();
                        illnessModel.setName_surname(edit_ill_name_surname_edittext.getText().toString());
                        illnessModel.setBirthdate(edit_ill_day_spinner.getSelectedItem().toString() + "/" + DateList.getMonthNumber(edit_ill_month_spinner.getSelectedItem().toString()) + "/" + edit_ill_year_edittext.getText().toString());
                        illnessModel.setIll(edit_ill_illness_edittext.getText().toString());
                        illnessModel.setSex(edit_ill_sex_spinner.getSelectedItem().toString());
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar cal = Calendar.getInstance();
                        if (edit_ill_enter_or_exit_checkbox.isChecked()){
                            if(edit_ill_enter_or_exit_checkbox.getText().toString().equals("Girişini Yap")){
                                illnessModel.setEnter_or_exit("Enter");
                            }
                            else if (edit_ill_enter_or_exit_checkbox.getText().toString().equals("Çıkışını Yap")){
                                illnessModel.setEnter_or_exit("Exit");
                            }
                            illnessModel.setEnter_exit_date(dateFormat.format(cal.getTime()));
                            illnessModel.setFromemployee("Deneme Hesabı");
                        }
                        else{
                            illnessModel.setEnter_or_exit(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_or_exit());
                            illnessModel.setEnter_exit_date(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getEnter_exit_date());
                            illnessModel.setFromemployee(StaticLists.mainIllnessModelList.get(listPosition).getIllness_model().getFromemployee());
                        }
                        StaticLists.mainIllnessModelList.get(listPosition).setIllness_model(illnessModel);
                        Toast.makeText(EditIllActivity.this,"Hasta yeniden düzenlendi.",Toast.LENGTH_LONG).show();
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("result_key", "edit_ok");
                        setResult(EditIllActivity.RESULT_OK, resultIntent);
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        EventModel eventModel = new EventModel();
                        eventModel.setEventName("Hasta Güncelleme");
                        eventModel.setEventDate(simpleDateFormat.format(calendar.getTime()));
                        eventModel.setEventDetail("Deneme Hesabı tarafından " + edit_ill_name_surname_edittext.getText().toString() + " isimli hastanın bilgileri güncellendi.");
                        StaticLists.eventModelList.add(eventModel);
                        if (StaticLists.eventModelList.size() > 20){
                            StaticLists.eventModelList.remove(0);
                        }
                        finish();
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
