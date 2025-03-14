package PlanificadorDeProcesos;
import java.util.*;

class PrioridadesApropiativo {
    private PriorityQueue<Proceso> colaProcesos;
    private int quantum;

    public PrioridadesApropiativo(List<Proceso> procesos, int quantum) {
        this.colaProcesos = new PriorityQueue<>(Comparator.comparingInt(Proceso::getPrioridad));
        this.colaProcesos.addAll(procesos);
        this.quantum = quantum;
    }

    public void ejecutar() {
        System.out.println("\n--- Inicio de la simulación ---");
        int tiempoTotal = 0;
        while (!colaProcesos.isEmpty()) {
            Proceso procesoActual = colaProcesos.poll();
            System.out.println("\nEjecutando proceso: " + procesoActual.getId() + " | Quantum utilizado: " + Math.min(procesoActual.getTiempoRestante(), quantum));
            
            int tiempoUsado = Math.min(procesoActual.getTiempoRestante(), quantum);
            procesoActual.setTiempoRestante(procesoActual.getTiempoRestante() - tiempoUsado);
            tiempoTotal += tiempoUsado;

            // Mostrar tabla de procesos
            System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-10d%-20d%-20d%-15d\n", procesoActual.getId(), procesoActual.getTiempoEjecucion(), procesoActual.getTiempoRestante(), procesoActual.getPrioridad());

            if (procesoActual.getTiempoRestante() > 0) {
                System.out.println("Proceso " + procesoActual.getId() + " se reencola.");
                colaProcesos.add(procesoActual); // Reencolar proceso si no ha terminado
            } else {
                System.out.println("Proceso " + procesoActual.getId() + " ha terminado.");
            }

            // Reordenar la cola de procesos después de cada ejecución
            PriorityQueue<Proceso> nuevaCola = new PriorityQueue<>(Comparator.comparingInt(Proceso::getPrioridad));
            nuevaCola.addAll(colaProcesos);
            colaProcesos = nuevaCola;
        }

        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal);
    }
}