package vehicle.subclass;

import vehicle.Electric;

public class CotxeElectric extends Cotxe implements Electric {
    public CotxeElectric(String matricula, String marca, String model, int numPortes) {
        super(matricula, marca, model, numPortes);
    }

    @Override
    public void carregarBateria() {
        System.out.println("La bateria se carga");
    }
}
