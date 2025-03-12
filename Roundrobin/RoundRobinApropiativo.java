package Roundrobin;
import java.util.*;
class RoundRobinApropiativo {
    private int quantum;

    public RoundRobinApropiativo(int quantum) {
        this.quantum = quantum;
    }

    public void ejecutar(List<Proceso> procesos) {
        Queue<Proceso> colaProcesos = new LinkedList<>(procesos);
        System.out.println("=== Round Robin Apropiativo ===");
        imprimirTabla(procesos);
        
        int tiempoTotal = 0;
        while (!colaProcesos.isEmpty()) {
            Proceso proceso = colaProcesos.poll();
            proceso.estado = "Activo";
            System.out.println("Proceso " + proceso.id + " entra en ejecución.");
            imprimirTabla(procesos);
            
            int tiempoUso = Math.min(proceso.tiempoRestante, quantum);
            proceso.tiempoRestante -= tiempoUso;
            tiempoTotal += tiempoUso;
            System.out.println("Proceso " + proceso.id + " usó " + tiempoUso + " unidades de tiempo de CPU.");
            
            if (proceso.tiempoRestante > 0) {
                proceso.estado = "Interrumpido";
                System.out.println("Proceso " + proceso.id + " ha sido interrumpido y vuelve a la cola.");
                colaProcesos.add(proceso);
            } else {
                proceso.estado = "Finalizado";
                System.out.println("Proceso " + proceso.id + " ha finalizado.");
            }
            
            imprimirTabla(procesos);
        }
        System.out.println("Tiempo total de ejecución: " + tiempoTotal);
    }

    private void imprimirTabla(List<Proceso> procesos) {
        System.out.println("\nID  | Tiempo Total | Tiempo Restante | Estado");
        System.out.println("------------------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d  | %12d | %15d | %s\n", p.id, p.tiempoEjecucion, p.tiempoRestante, p.estado);
        }
        System.out.println("------------------------------------------------\n");
    }
}