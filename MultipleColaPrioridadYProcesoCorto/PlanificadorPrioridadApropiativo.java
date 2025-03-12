package MultipleColaPrioridadYProcesoCorto;
import java.util.*;


public class PlanificadorPrioridadApropiativo {
    public void ejecutar(List<Proceso> procesos) {
        procesos.sort(Comparator.comparingInt(p -> p.prioridad)); 
        PriorityQueue<Proceso> cola = new PriorityQueue<>(Comparator.comparingInt(p -> p.prioridad));
        cola.addAll(procesos);
        
        while (!cola.isEmpty()) {
            Proceso actual = cola.poll();
            actual.estado = "Activo";
            imprimirProcesos(procesos);
            
            while (actual.tiempoRestante > 0) {
                int usoCPU = Math.min(4, actual.tiempoRestante);
                actual.tiempoRestante -= usoCPU;
                System.out.println("Proceso " + actual.id + " usó " + usoCPU + " unidades de CPU.");
                
                // Revisar si hay un proceso de mayor prioridad esperando
                Optional<Proceso> nuevoProceso = cola.stream()
                        .filter(p -> p.prioridad > actual.prioridad) 
                        .findFirst();

                if (nuevoProceso.isPresent()) { 
                    actual.estado = "Interrumpido";
                    cola.add(actual); 
                    break; 
                }
            }
            
            if (actual.tiempoRestante == 0) {
                actual.estado = "Finalizado";
            }
            imprimirProcesos(procesos);
        }
    }
    
    private void imprimirProcesos(List<Proceso> procesos) {
        System.out.println("ID  | Tiempo Total | Tiempo Restante | Prioridad | Estado");
        System.out.println("-----------------------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d  | %12d | %14d | %8d | %s\n", p.id, p.tiempoTotal, p.tiempoRestante, p.prioridad, p.estado);
        }
        System.out.println("*****************************************************************************************************************************\n");
    }
}