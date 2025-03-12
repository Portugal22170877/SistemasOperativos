package Roundrobin;

import java.util.*;

class RoundRobinNoApropiativo {
    private int quantum;

    public RoundRobinNoApropiativo(int quantum) {
        this.quantum = quantum;
    }

    public void ejecutar(List<Proceso> procesos) {
        System.out.println("=== Round Robin No Apropiativo ===");
        imprimirTabla(procesos);
        
        for (Proceso proceso : procesos) {
            proceso.estado = "Activo";
            System.out.println("Proceso " + proceso.id + " entra en ejecución.");
            imprimirTabla(procesos);
            
            proceso.tiempoRestante = 0;
            proceso.estado = "Finalizado";
            System.out.println("Proceso " + proceso.id + " ha finalizado.");
            
            imprimirTabla(procesos);
        }
    }

    private void imprimirTabla(List<Proceso> procesos) {
        System.out.println("\nID  | Tiempo Total | Tiempo Restante | Estado");
        System.out.println("-----------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d  | %12d | %15d | %s\n", p.id, p.tiempoEjecucion, p.tiempoRestante, p.estado);
        }
        System.out.println("-----------------------------------------\n");
    }
}