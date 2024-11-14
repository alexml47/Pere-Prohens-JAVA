package vehicle.subclass;

import vehicle.Vehicle;

public class Cotxe extends Vehicle {
    private int numPortes;

    public Cotxe(String matricula, String marca, String model,int numPortes) {
        super(matricula, marca, model);
        this.numPortes = numPortes;
    }

    @Override
    public void accelerar() {
        int acceleracio = 10;
        System.out.println("El cotxe està accelerant amb " + acceleracio + "km");
        this.velocidad += acceleracio;
    }
}
