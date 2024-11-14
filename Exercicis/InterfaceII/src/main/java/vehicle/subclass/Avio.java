package vehicle.subclass;

import vehicle.Vehicle;
import vehicle.Volador;

public class Avio extends Vehicle implements Volador {
    public Avio(String matricula, String marca, String model) {
        super(matricula, marca, model);
    }

    @Override
    public void accelerar() {
        int acceleracio = 10;
        System.out.println("El avion està accelerant amb " + acceleracio + "km");
        this.velocidad += acceleracio;
    }

    @Override
    public void volar() {
        System.out.println("I BELIEVE I CAN FLY");
    }
}
