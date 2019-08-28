package com.mkpatir.engelsizyasam.models;

public class ReportsDayListviewModel {
    private String tcKimlikNo;
    private String report_name;
    private ReportModel reportModel;

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public ReportModel getReportModel() {
        return reportModel;
    }

    public void setReportModel(ReportModel reportModel) {
        this.reportModel = reportModel;
    }
}
