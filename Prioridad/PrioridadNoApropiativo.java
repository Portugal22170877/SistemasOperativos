package Prioridad;
import java.util.*;

class PrioridadNoApropiativo {

    public void ejecutar(List<Proceso> procesos) {
        System.out.println("\n=== Prioridades No Apropiativo ===");
        procesos.sort(Comparator.comparingInt(p -> p.prioridad));
        
        for (Proceso p : procesos) {
            p.estado = "Activo";
            Utilidades.imprimirProcesos(procesos);
            System.out.println("Proceso " + p.id + " usó " + p.tiempoRestante + " unidades de CPU.");
            p.tiempoRestante = 0;
            p.estado = "Finalizado";
            Utilidades.imprimirProcesos(procesos);
        }
    }
}