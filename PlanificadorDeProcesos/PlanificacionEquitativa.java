package PlanificadorDeProcesos;

import java.util.List;

public class PlanificacionEquitativa {
    private List<Proceso> procesos;

    public PlanificacionEquitativa(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public void ejecutar() {
        boolean todosCompletos;
        int tiempoTotal = 0; // Declarar e inicializar tiempoTotal
        System.err.println("Inicio de la simulación");
        // Mostrar encabezado de la tabla de procesos
        System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
        System.out.println("-------------------------------------------------------------");
        
        do {
            todosCompletos = true;
            
            // Se recorre cada proceso en la lista de procesos
            for (Proceso p : procesos) {
                if (p.getTiempoRestante() > 0) {
                    todosCompletos = false;
                    
                    // Ejecutar este proceso durante 1 unidad de tiempo
                    System.out.println("Ejecutando proceso " + p.getId() + " por 1 unidad de tiempo.");
                    
                    // Reducir el tiempo restante del proceso
                    p.setTiempoRestante(p.getTiempoRestante() - 1);

                    // Incrementar el tiempo total
                    tiempoTotal++;
                    
                    // Imprimir la tabla después de ejecutar el proceso
                    System.out.printf("%-10d%-20d%-20d%-15d\n", p.getId(), p.getTiempoEjecucion(), p.getTiempoRestante(), p.getPrioridad());
                }
            }
        } while (!todosCompletos); // Continuar hasta que todos los procesos estén completos
        System.out.println("Tiempo total de ejecución: " + tiempoTotal + " unidades de tiempo.");

        System.out.println("Todos los procesos han finalizado.");
    }
}
