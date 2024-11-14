import vehicle.subclass.*;

public class Main {
    public static void main(String[] args) {
        Cotxe cotxe = new Cotxe("KDSQ1234","Toyota","Yaris",4);
        Moto moto = new Moto("123ADSF","Yamaha","04",4);
        CotxeElectric cotxeElectric = new CotxeElectric("56ASD3","Tesla","Model 3",5);
        Avio avio = new Avio("LSA222","BOENG","100020");
        Lilium lilium = new Lilium("RKD221","Lilium","Jet");

        cotxe.accelerar();
        cotxe.mostrarInformacio();

        System.out.println("---------------------");

        moto.accelerar();
        moto.mostrarInformacio();

        System.out.println("---------------------");

        cotxeElectric.accelerar();
        cotxeElectric.carregarBateria();
        cotxeElectric.mostrarInformacio();

        System.out.println("---------------------");

        avio.accelerar();
        avio.volar();
        avio.mostrarInformacio();

        System.out.println("---------------------");

        lilium.accelerar();
        lilium.carregarBateria();
        lilium.volar();
        lilium.mostrarInformacio();
    }
}
