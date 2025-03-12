package MultipleColaPrioridadYProcesoCorto;
import java.util.*;

public class PlanificadorPrioridadNoApropiativo {
    public void ejecutar(List<Proceso> procesos) {
        // Ordenar por prioridad (menor número = mayor prioridad)
        procesos.sort(Comparator.comparingInt(p -> p.prioridad));
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
      // Método imprimirProcesos dentro de la clase
      private void imprimirProcesos(List<Proceso> procesos) {
        System.out.println("ID  | Tiempo Total | Tiempo Restante | Prioridad | Estado");
        System.out.println("-----------------------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d  | %12d | %14d | %8d | %s\n", 
                              p.id, p.tiempoTotal, p.tiempoRestante, p.prioridad, p.estado);
        }
        System.out.println("*****************************************************************************************************************************\n");
    }
}