package PlanificadorDeProcesos;
import java.util.*;
public class BoletosDeLoteriaNoApropiativo {
    private List<Proceso> procesos;
    private int quantum;

    public BoletosDeLoteriaNoApropiativo(List<Proceso> procesos, int quantum) {
        this.procesos = procesos;
        this.quantum = quantum;
    }

    public void ejecutar() {
        Queue<Proceso> cola = new LinkedList<>(procesos);
        int tiempoTotal = 0;
        
        System.out.println("--- Inicio de la simulación ---");
        
        // Ejecutar procesos
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            int tiempoEjecutado = Math.min(proceso.getTiempoRestante(), quantum);
            proceso.setTiempoRestante(proceso.getTiempoRestante() - tiempoEjecutado);
            tiempoTotal += tiempoEjecutado;
            
            // Mostrar el estado después de cada ejecución
            System.out.println("Ejecutando proceso: " + proceso.getId());
            System.out.println(proceso);
            System.out.println("Quantum utilizado: " + tiempoEjecutado);
            System.out.println("-------------------------------------------------------------");
            
            if (proceso.getTiempoRestante() > 0) {
                // Si el proceso no ha terminado, se reencola
                System.out.println("Proceso " + proceso.getId() + " se reencola.");
                cola.add(proceso);
            } else {
                // Si el proceso ha terminado
                System.out.println("Proceso " + proceso.getId() + " ha terminado.");
            }
        }
        
        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal);
    }
}
    

