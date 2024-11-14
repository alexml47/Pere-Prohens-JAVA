package main.java.com.alex.model;

import java.util.Date;

public class Fecha_3 {


    private int days;

    public Fecha_3(int days) {
        this.days = days;
    }

    public int getAny() {
        return this.days/365;
    }
}
