package PlanificadorDeProcesos;
import java.util.*;

class MultiplesColasPrioridadesApropiativo {
     private List<Queue<Proceso>> colasPrioridades;
    private int quantum;
    
    public MultiplesColasPrioridadesApropiativo(List<Proceso> procesos, int quantum) {
        this.quantum = quantum;
        this.colasPrioridades = new ArrayList<>();
        
        // Inicializamos las colas de prioridades (suponiendo que hay 5 niveles de prioridad)
        for (int i = 0; i < 5; i++) {
            colasPrioridades.add(new LinkedList<>());
        }

        // Insertamos los procesos en las colas correspondientes según su prioridad
        for (Proceso proceso : procesos) {
            colasPrioridades.get(proceso.getPrioridad() - 1).add(proceso);
        }
    }

    public void ejecutar() {
        System.out.println("\n--- Inicio de la simulación ---");
        int tiempoTotal = 0;
        
        // Mientras haya procesos en alguna cola de prioridad
        while (hayProcesos()) {
            // Iteramos a través de las colas de prioridades, desde la más alta hasta la más baja
            for (int i = 0; i < colasPrioridades.size(); i++) {
                Queue<Proceso> colaActual = colasPrioridades.get(i);
                if (!colaActual.isEmpty()) {
                    Proceso procesoActual = colaActual.poll();
                    
                    int tiempoUsado = Math.min(procesoActual.getTiempoRestante(), quantum);
                    System.out.println("\nEjecutando proceso: " + procesoActual.getId() + " | Quantum utilizado: " + tiempoUsado);
                    procesoActual.setTiempoRestante(procesoActual.getTiempoRestante() - tiempoUsado);
                    tiempoTotal += tiempoUsado;
                    
                    System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
                    System.out.println("-------------------------------------------------------------");
                    System.out.printf("%-10d%-20d%-20d%-15d\n", procesoActual.getId(), procesoActual.getTiempoEjecucion(), procesoActual.getTiempoRestante(), procesoActual.getPrioridad());
                    
                    // Si el proceso no ha terminado, se reencola a la misma cola
                    if (procesoActual.getTiempoRestante() > 0) {
                        System.out.println("Proceso " + procesoActual.getId() + " se reencola.");
                        colasPrioridades.get(i).add(procesoActual);
                    } else {
                        System.out.println("Proceso " + procesoActual.getId() + " ha terminado.");
                    }
                    
                    // Si ya no quedan procesos en esta cola, no volveremos a ejecutarlo
                    break;
                }
            }
        }
        
        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal+ " unidades de tiempo.");
    }

    private boolean hayProcesos() {
        // Verificamos si alguna de las colas tiene procesos pendientes
        for (Queue<Proceso> cola : colasPrioridades) {
            if (!cola.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

