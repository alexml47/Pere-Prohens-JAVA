package vehicle;

public abstract class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    protected int velocidad;

    public Vehicle (String matricula, String marca, String model){
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
    }

    public abstract void accelerar();

    public void mostrarInformacio(){
        System.out.println("La matricula: " + matricula);
        System.out.println("La marca: " + marca);
        System.out.println("El modelo: " + model);
    };
}
