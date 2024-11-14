package pere;

import java.util.ArrayList;
import java.util.List;

public class Bosa <T>{
    private int MAX_SIZE = 10;
    private List <T> bosa = new ArrayList<T>();

    public Bosa(int MAX_SIZE){
        this.MAX_SIZE = MAX_SIZE;
    }

    public void addItem(T item) throws Exception {
        if (bosa.size() != MAX_SIZE){
            bosa.add(item);
        } else {
            throw new RuntimeException();
        }
    }
}
