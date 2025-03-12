package MultipleColaPrioridadYProcesoCorto;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Proceso> procesos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            procesos.add(new Proceso(i, rand.nextInt(10) + 1, rand.nextInt(5) + 1));
        }

        System.out.println("=== Planificación por Prioridades Apropiativo ===");
        new PlanificadorPrioridadApropiativo().ejecutar(new ArrayList<>(procesos));

        System.out.println("=== Planificación por Prioridades No Apropiativo ===");
        new PlanificadorPrioridadNoApropiativo().ejecutar(new ArrayList<>(procesos));

       System.out.println("=== Planificador por SJF ===");
       new PlanificadorSJF().ejecutar(new ArrayList<>(procesos));
    }
}
