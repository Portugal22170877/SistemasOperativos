package PlanificadorDeProcesos;
import java.util.*;

class RoundRobinNoApropiativo {
    private Queue<Proceso> colaProcesos;
    private int quantum;

    public RoundRobinNoApropiativo(List<Proceso> procesos, int quantum) {
        this.colaProcesos = new LinkedList<>(procesos);
        this.quantum = quantum;
    }

    public void ejecutar() {
        System.out.println("\n--- Inicio de la simulación ---");
        int tiempoTotal = 0;
        while (!colaProcesos.isEmpty()) {
            Proceso procesoActual = colaProcesos.poll();
            
            System.out.println("\nEjecutando proceso: " + procesoActual.getId());
            System.out.println("Proceso ejecutándose hasta su finalización...");
            tiempoTotal += procesoActual.getTiempoRestante();
            procesoActual.setTiempoRestante(0);
            
            System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-10d%-20d%-20d%-15d\n", procesoActual.getId(), procesoActual.getTiempoEjecucion(), procesoActual.getTiempoRestante(), procesoActual.getPrioridad());
            
            System.out.println("Proceso " + procesoActual.getId() + " ha terminado.");
        }
        
        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal+" unidades de tiempo.");
    }
}
