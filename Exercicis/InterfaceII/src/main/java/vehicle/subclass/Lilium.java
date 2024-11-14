package vehicle.subclass;

import vehicle.Electric;
import vehicle.Vehicle;
import vehicle.Volador;

public class Lilium extends CotxeElectric implements Volador {
    public Lilium(String matricula, String marca, String model) {
        super(matricula, marca, model,4);
    }

    @Override
    public void carregarBateria() {
        System.out.println("BRUM BRUM, ESTOY CARGANDO");
    }

    @Override
    public void accelerar() {
        int acceleracio = 10;
        System.out.println("El lilium està accelerant amb " + acceleracio + "km");
        this.velocidad += acceleracio;
    }

    @Override
    public void volar() {
        System.out.println("I BELIEVE I CAN FLY");
    }
}
