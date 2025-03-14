package PlanificadorDeProcesos;
import java.util.*;
public class MultiplesColasPrioridadesNoApropiativo {

    private List<Proceso> procesos;
    private int quantum;
    
    public MultiplesColasPrioridadesNoApropiativo(List<Proceso> procesos, int quantum) {
        this.procesos = procesos;
        this.quantum = quantum;
    }

    public void ejecutar() {
        // Ordenamos los procesos según la prioridad (de mayor a menor)
        procesos.sort(Comparator.comparingInt(Proceso::getPrioridad).reversed());
        
        int tiempoTotalEjecucion = 0;
        System.out.println("\n--- Inicio de la simulación ---");

        // Ejecutamos los procesos según la prioridad sin apropiación
        while (!procesos.isEmpty()) {
            Proceso p = procesos.get(0);  // Tomamos el primer proceso (de mayor prioridad)
            
            // Verificamos si el proceso ya ha terminado
            if (p.getTiempoRestante() > 0) {
                // Ejecutamos el proceso por su tiempo restante
                int tiempoEjecutado = Math.min(p.getTiempoRestante(), quantum);
                p.setTiempoRestante(p.getTiempoRestante() - tiempoEjecutado);
                tiempoTotalEjecucion += tiempoEjecutado;

                System.out.printf("Ejecutando proceso: %d | Quantum utilizado: %d\n", p.getId(), tiempoEjecutado);
                System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
                System.out.println("-------------------------------------------------------------");
                System.out.printf("%-10d%-20d%-20d%-15d\n", p.getId(), p.getTiempoEjecucion(), p.getTiempoRestante(), p.getPrioridad());

                // Si el proceso termina, lo eliminamos de la lista
                if (p.getTiempoRestante() == 0) {
                    System.out.printf("Proceso %d ha terminado.\n", p.getId());
                    procesos.remove(p);
                }
            }
        }

        System.out.println("\n--- Reporte Final ---");
        System.out.printf("Tiempo total de ejecución: %d\n", tiempoTotalEjecucion);
    }
}
    

