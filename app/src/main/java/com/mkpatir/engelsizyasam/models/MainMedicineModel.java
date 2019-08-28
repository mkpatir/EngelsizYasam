package com.mkpatir.engelsizyasam.models;

import java.util.List;

public class MainMedicineModel {
    private String tc_kimlik_no;
    private List<SecondMedicineModel> secondMedicineModelList;

    public String getTc_kimlik_no() {
        return tc_kimlik_no;
    }

    public void setTc_kimlik_no(String tc_kimlik_no) {
        this.tc_kimlik_no = tc_kimlik_no;
    }

    public List<SecondMedicineModel> getSecondMedicineModelList() {
        return secondMedicineModelList;
    }

    public void setSecondMedicineModelList(List<SecondMedicineModel> secondMedicineModelList) {
        this.secondMedicineModelList = secondMedicineModelList;
    }
}
