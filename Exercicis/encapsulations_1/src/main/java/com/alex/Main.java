package main.java.com.alex;


import main.java.com.alex.model.Fecha_1;
import main.java.com.alex.model.Fecha_2;
import main.java.com.alex.model.Fecha_3;

public class Main {
    public static void main(String[] args) {
        Fecha_1 fecha1 = new Fecha_1(10,10,2004);
        Fecha_2 fecha2 = new Fecha_2("10-10-2004");
        Fecha_3 fecha3 = new main.java.com.alex.model.Fecha_3(50430);
        System.out.println(fecha1.getAny());
    }
}