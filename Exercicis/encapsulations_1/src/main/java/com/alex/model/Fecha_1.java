package main.java.com.alex.model;

import java.util.Date;

public class Fecha_1 {
    private int day;
    private int month;
    private int year;



    public Fecha_1(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }



    public int getAny() {
        Date date = new Date(year, month, day);
        return date.getYear();
    }




}
