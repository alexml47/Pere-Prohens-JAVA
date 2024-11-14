package pere;

public class Platano implements Comparable<Platano>{
    String name;
    int preu;

    public Platano(String name,int preu){;
        this.name = name;
        this.preu = preu;
    }

    public int getPreu() {
        return preu;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Platano" + "[Name: " + this.name + " ,price:" + this.preu + "]";
    }

    public int compareTo(Platano p){
        return this.name.compareTo(p.getName());
    }

}
