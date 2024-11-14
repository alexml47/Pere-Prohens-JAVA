package vehicle.subclass;

import vehicle.Vehicle;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model,int cilindrada) {
        super(matricula, marca, model);
        this.cilindrada = cilindrada;
    }

    @Override
    public void accelerar() {
        int acceleracio = 10;
        System.out.println("La moto està accelerant amb " + acceleracio + "km");
        this.velocidad += acceleracio;
    }
}
