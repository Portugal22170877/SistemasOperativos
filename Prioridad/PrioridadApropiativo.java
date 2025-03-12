package Prioridad;
import java.util.*;
class PrioridadApropiativo {

    public void ejecutar(List<Proceso> procesos) {
        System.out.println("\n=== Prioridades Apropiativo ===");
        PriorityQueue<Proceso> cola = new PriorityQueue<>(Comparator.comparingInt(p -> p.prioridad));
        cola.addAll(procesos);
        
        while (!cola.isEmpty()) {
            Proceso actual = cola.poll();
            actual.estado = "Activo";
            Utilidades.imprimirProcesos(procesos);
            
            int usoCPU = Math.min(4, actual.tiempoRestante);
            actual.tiempoRestante -= usoCPU;
            System.out.println("Proceso " + actual.id + " usó " + usoCPU + " unidades de CPU.");
            
            if (actual.tiempoRestante > 0) {
                actual.estado = "Interrumpido";
                cola.add(actual);
            } else {
                actual.estado = "Finalizado";
            }
            Utilidades.imprimirProcesos(procesos);
        }
    }
}