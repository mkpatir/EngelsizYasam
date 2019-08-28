package com.mkpatir.engelsizyasam.extras;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Days;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateList {
    private static String[] dayList = {"Gün","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18",
            "19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private static String[] monthList = {"Ay","Ocak","Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık"};

    public static String[] getDayList(){
        return dayList;
    }

    public static String[] getMonthList(){
        return monthList;
    }

    public static String getMonthNumber(String monthName){
        if (monthName.equals("Ocak")){
            return "01";
        }
        else if (monthName.equals("Şubat")){
            return "02";
        }
        else if (monthName.equals("Mart")){
            return "03";
        }
        else if (monthName.equals("Nisan")){
            return "04";
        }
        else if (monthName.equals("Mayıs")){
            return "05";
        }
        else if (monthName.equals("Haziran")){
            return "06";
        }
        else if (monthName.equals("Temmuz")){
            return "07";
        }
        else if (monthName.equals("Ağustos")){
            return "08";
        }
        else if (monthName.equals("Eylül")){
            return "09";
        }
        else if (monthName.equals("Ekim")){
            return "10";
        }
        else if (monthName.equals("Kasım")){
            return "11";
        }
        else if (monthName.equals("Aralık")){
            return "12";
        }
        else {
            return "00";
        }
    }

    public static int getRemainingDays(String date){
        try {
            char[] dateChar = date.toCharArray();
            int day = Integer.parseInt("" + dateChar[0] + dateChar[1]);
            int month = Integer.parseInt("" + dateChar[3] + dateChar[4]);
            int year = Integer.parseInt("" + dateChar[6] + dateChar[7] + dateChar[8] + dateChar[9]);
            //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //Date otherDate = dateFormat.parse(day) ;
            org.joda.time.LocalDate today = org.joda.time.LocalDate.now();
            org.joda.time.LocalDate afterDate = new org.joda.time.LocalDate(year,month,day);
            return Days.daysBetween(today,afterDate).getDays();
            //Date fark = new Date(otherDate.getTime() - today.getTime());
            //return (otherDate.getTime() - today.getTime())/(1000*60*60*24);
            //Days fa = Days.daysBetween(today,otherDate);
            //return ((fark.getYear() % 70) * 365) + (fark.getMonth() * 30) + (fark.getDate()-1);
            //return fa.getDays();
        }
        catch (Exception ex){
            return 0;
        }
    }
}
