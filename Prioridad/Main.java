package Prioridad;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Proceso> procesos = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            procesos.add(new Proceso(i, rand.nextInt(10) + 1, rand.nextInt(5) + 1));
        }
        
        new PrioridadApropiativo().ejecutar(new ArrayList<>(procesos));
        System.out.println("\n*********************************************************************************************************************\n");
        new PrioridadNoApropiativo().ejecutar(new ArrayList<>(procesos));
    }
}