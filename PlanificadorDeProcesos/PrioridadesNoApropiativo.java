package PlanificadorDeProcesos;
import java.util.*;

class PrioridadesNoApropiativo {
    private List<Proceso> procesos;

    public PrioridadesNoApropiativo(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public void ejecutar() {
        procesos.sort(Comparator.comparingInt(Proceso::getPrioridad));
        
        int tiempoTotal = 0;
        System.out.println("\n--- Inicio de la simulación ---");

        for (Proceso proceso : procesos) {
            System.out.println("\nEjecutando proceso: " + proceso.getId());
            System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-10d%-20d%-20d%-15d\n", proceso.getId(), proceso.getTiempoEjecucion(), proceso.getTiempoRestante(), proceso.getPrioridad());
            proceso.setTiempoRestante(0);
            tiempoTotal += proceso.getTiempoEjecucion();
            System.out.println("Proceso " + proceso.getId() + " ha terminado.");
        }

        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal + " unidades de tiempo.");
    }
}
