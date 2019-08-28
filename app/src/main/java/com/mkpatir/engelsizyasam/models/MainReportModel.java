package com.mkpatir.engelsizyasam.models;

import java.util.List;

public class MainReportModel {
    private String tc_kimlik_no;
    private List<SecondReportModel> secondReportModelList;

    public String getTc_kimlik_no() {
        return tc_kimlik_no;
    }

    public void setTc_kimlik_no(String tc_kimlik_no) {
        this.tc_kimlik_no = tc_kimlik_no;
    }

    public List<SecondReportModel> getSecondReportModelList() {
        return secondReportModelList;
    }

    public void setSecondReportModelList(List<SecondReportModel> secondReportModelList) {
        this.secondReportModelList = secondReportModelList;
    }
}
