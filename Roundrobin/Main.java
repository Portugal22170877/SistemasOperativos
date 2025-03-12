package Roundrobin;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Proceso> procesos = new ArrayList<>();
        
        for (int i = 1; i <= 4; i++) {
            int tiempoEjecucion = random.nextInt(10) + 1; // Asegurar tiempo entre 1 y 10
            procesos.add(new Proceso(i, tiempoEjecucion));
        }
        
        int quantum = 4;
        
        RoundRobinApropiativo rrApropiativo = new RoundRobinApropiativo(quantum);
        rrApropiativo.ejecutar(new ArrayList<>(procesos));
        
        System.out.println("\n----------------------------------------------------------------------------------------------------------------\n");
        
        RoundRobinNoApropiativo rrNoApropiativo = new RoundRobinNoApropiativo(quantum);
        rrNoApropiativo.ejecutar(new ArrayList<>(procesos));
    }
}