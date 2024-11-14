package main.java.com.alex.model;

import java.util.Date;

public class Fecha_2 {
    private String date = "10-10-2004";

    public Fecha_2(String date) {
        this.date = date;
    }

    public int getAny() {
        Date date = new Date(this.date.toString());
        return date.getYear();
    }
}
