package PlanificadorDeProcesos;
import  java.util.*;
public class ProcesoMasCortoPrimero {
    private List<Proceso> procesos;

    public ProcesoMasCortoPrimero(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public void ejecutar() {
        int tiempoTotal = 0;

        // Mientras haya procesos con tiempo restante
        while (!procesos.isEmpty()) {
            // Filtramos los procesos que aún no han terminado
            List<Proceso> procesosRestantes = new ArrayList<>();
            for (Proceso proceso : procesos) {
                if (proceso.getTiempoRestante() > 0) {
                    procesosRestantes.add(proceso);
                }
            }

            if (procesosRestantes.isEmpty()) break;

            // Encontramos el proceso con el menor tiempo restante
            Proceso procesoSeleccionado = procesosRestantes.stream()
                    .min(Comparator.comparingInt(Proceso::getTiempoRestante))
                    .orElseThrow(() -> new RuntimeException("No hay procesos disponibles"));

            // Se ejecuta durante el tiempo restante del proceso (sin excederlo)
            int quantumUtilizado = procesoSeleccionado.getTiempoRestante();
            procesoSeleccionado.setTiempoRestante(procesoSeleccionado.getTiempoRestante() - quantumUtilizado);

           // Mostramos el estado del proceso
           System.out.printf("Ejecutando proceso: %d | Quantum utilizado: %d\n", procesoSeleccionado.getId(), quantumUtilizado);
           System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
           System.out.println("-------------------------------------------------------------");
           System.out.printf("%-10d%-20d%-20d%-15d\n", procesoSeleccionado.getId(), procesoSeleccionado.getTiempoEjecucion(), procesoSeleccionado.getTiempoRestante(), procesoSeleccionado.getPrioridad());


            // Si el proceso ha terminado, lo eliminamos
            if (procesoSeleccionado.getTiempoRestante() == 0) {
                procesos.remove(procesoSeleccionado);
                System.out.println("Proceso " + procesoSeleccionado.getId() + " ha terminado.");
            }

            // Aumentamos el tiempo total de ejecución
            tiempoTotal += quantumUtilizado;
        }

        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal+" unidades de tiempo.");
    }
}

