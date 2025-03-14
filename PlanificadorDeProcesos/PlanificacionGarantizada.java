package PlanificadorDeProcesos;

import java.util.List;

public class PlanificacionGarantizada {
    private List<Proceso> procesos;

    public PlanificacionGarantizada(List<Proceso> procesos) {
        this.procesos = procesos;
    }
     

    public void ejecutar() {
        // Separador visual
        System.err.println("Inicio de la simulación");
        System.out.println("\n--- Ejecución de Planificación Garantizada ---");
        int tiempoTotal = 0;

        // Mostrar encabezado de la tabla de procesos
        System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
        System.out.println("-------------------------------------------------------------");
        
        // Mostrar los procesos iniciales
        for (Proceso proceso : procesos) {
            System.out.printf("%-10d%-20d%-20d%-15d\n", proceso.getId(), proceso.getTiempoEjecucion(), proceso.getTiempoRestante(), proceso.getPrioridad());
        }

        
        
        // Ejecución de procesos
        while (!procesos.isEmpty()) {
            Proceso procesoMenosUsado = obtenerProcesoMenosUsado();
            if (procesoMenosUsado != null) {
                System.out.println("Ejecutando proceso: " + procesoMenosUsado.getId());
                int tiempoUso = procesoMenosUsado.getTiempoRestante();
                procesoMenosUsado.setTiempoRestante(0);
                tiempoTotal += tiempoUso;
                System.out.println("Proceso " + procesoMenosUsado.getId() + " ha terminado.");

                // Mostrar la tabla de procesos después de la ejecución
                System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
                System.out.println("-------------------------------------------------------------");
                for (Proceso proceso : procesos) {
                    System.out.printf("%-10d%-20d%-20d%-15d\n", proceso.getId(), proceso.getTiempoEjecucion(), proceso.getTiempoRestante(), proceso.getPrioridad());
                }

                procesos.remove(procesoMenosUsado);
            }
        }
        
        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal + " Unidades de tiempo.");
    }

    private Proceso obtenerProcesoMenosUsado() {
        return procesos.stream()
                .min((p1, p2) -> Integer.compare(p1.getTiempoEjecucion(), p2.getTiempoEjecucion()))
                .orElse(null);
    }
}
