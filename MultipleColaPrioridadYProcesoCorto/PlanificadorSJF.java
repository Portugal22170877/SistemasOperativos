package MultipleColaPrioridadYProcesoCorto;

import java.util.*;

public class PlanificadorSJF {
    public void ejecutar(List<Proceso> procesos) {
        procesos.sort(Comparator.comparingInt(p -> p.tiempoTotal)); // Ordena por tiempo total de ejecución
        Queue<Proceso> cola = new LinkedList<>(procesos);

        while (!cola.isEmpty()) {
            Proceso actual = cola.poll();
            actual.estado = "Activo";
            imprimirProcesos(procesos);

            System.out.println("Proceso " + actual.id + " usó " + actual.tiempoRestante + " unidades de CPU.");
            actual.tiempoRestante = 0;
            actual.estado = "Finalizado";

            imprimirProcesos(procesos);
        }
    }

    private void imprimirProcesos(List<Proceso> procesos) {
        System.out.println("ID  | Tiempo Total | Tiempo Restante | Estado");
        System.out.println("---------------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d  | %12d | %14d | %s\n", p.id, p.tiempoTotal, p.tiempoRestante, p.estado);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
    }
}



