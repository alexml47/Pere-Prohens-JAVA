package pere;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Platano> bosaDePlatano = new ArrayList<Platano>();

        Platano plat1 = new Platano("platano1",1);
        Platano plat2 = new Platano("platano2",2);
        Platano plat3 = new Platano("Blata3nb",3);
        Platano plat5 = new Platano("Blata3nb",3);
        Platano plat4 = new Platano("Alata4na",4);

        try {
            bosaDePlatano.add(plat1);
            bosaDePlatano.add(plat5);
            bosaDePlatano.add(plat2);
            bosaDePlatano.add(plat3);
            bosaDePlatano.add(plat1);
            bosaDePlatano.add(plat4);
            bosaDePlatano.add(plat5);
        } catch (Exception e) {
            System.out.println("Esta lleno :(");
        }

        List<Platano> platanosOrdenanados = bosaDePlatano.stream().sorted().toList();

        platanosOrdenanados.forEach(System.out::println);

        class ComparadorDePlatanos implements Comparator<Platano>{

            @Override
            public int compare(Platano o1, Platano o2) {
                int result = Integer.compare(o1.getPreu(),o2.getPreu());
                if (result == 0){
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        }

        ComparadorDePlatanos comparador = new ComparadorDePlatanos();

        bosaDePlatano.sort(comparador);

        bosaDePlatano.forEach(System.out::println);



        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }


        System.out.println("FIFO");
        for (int i = 0; i < 10; i++) {
            nums.removeFirst();
            System.out.println("--------");
            nums.forEach(System.out::println);
        }

        System.out.println("LIFO");
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        for (int i = 0; i < 10; i++) {
            nums.removeLast();
            System.out.println("--------");
            nums.forEach(System.out::println);
        }

        Predicate<Platano> mesCarQue = p -> p.getPreu() >= 3;

        class compDePlat implements Comparator<Platano>{

            @Override
            public int compare(Platano o1, Platano o2) {
                if (o1.getPreu() > o2.getPreu()){
                    return 1;
                } else if (o1.getPreu() < o2.getPreu()){
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        compDePlat comparadorX = new compDePlat();

        bosaDePlatano.stream().sorted().sorted(comparadorX).filter(mesCarQue)
                .map(item -> item.getName().toUpperCase())
                .forEach(System.out::println);

        System.out.println("-----------");

        bosaDePlatano.stream().sorted().filter(mesCarQue)
                .map(item -> new StringBuilder(item.getName()).reverse().toString().toUpperCase())
                .forEach(System.out::println);


    }
}