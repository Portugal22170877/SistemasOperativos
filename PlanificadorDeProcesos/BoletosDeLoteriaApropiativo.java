package PlanificadorDeProcesos;
import java.util.*;
class BoletosDeLoteriaApropiativo {
    private List<Proceso> procesos;
    private int quantum;

    public BoletosDeLoteriaApropiativo(List<Proceso> procesos, int quantum) {
        this.procesos = procesos;
        this.quantum = quantum;
    }

    public void ejecutar() {
        Queue<Proceso> cola = new LinkedList<>(procesos);
        int tiempoTotal = 0;
        System.out.println("--- Inicio de la simulación ---");

        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll(); // Saca el primer proceso de la cola
            System.out.println("Ejecutando proceso: " + proceso.getId());
            int tiempoEjecutado = Math.min(proceso.getTiempoRestante(), quantum); // Solo ejecuta el quantum disponible
            proceso.setTiempoRestante(proceso.getTiempoRestante() - tiempoEjecutado);
            tiempoTotal += tiempoEjecutado;

            // Imprimir el estado actual del proceso
            System.out.printf("%-10d%-20d%-20d%-15d\n", proceso.getId(), proceso.getTiempoEjecucion(), proceso.getTiempoRestante(), proceso.getPrioridad());

            if (proceso.getTiempoRestante() == 0) {
                System.out.println("Proceso " + proceso.getId() + " ha terminado.");
            } else {
                cola.offer(proceso); // Si el proceso no ha terminado, se reencola
                System.out.println("Proceso " + proceso.getId() + " se reencola.");
            }

            // Mostrar el tiempo ejecutado de este proceso
            System.out.println("Quantum utilizado: " + tiempoEjecutado);
            System.out.println("-------------------------------------------------------------");
        }

        System.out.println("--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal);
    }
}

