package PlanificadorDeProcesos;
import java.util.*;
import java.util.stream.Collectors;

class PrioridadesApropiativo {
    private Queue<Proceso> colaProcesos;
    private int quantum;
    private Random random;
    private Set<Integer> procesosBloqueados;
    
    public PrioridadesApropiativo(List<Proceso> procesos, int quantum) {
        this.colaProcesos = new LinkedList<>(procesos);
        this.quantum = quantum;
        this.random = new Random();
        this.procesosBloqueados = new HashSet<>();
        this.colaProcesos = new LinkedList<>(
            this.colaProcesos.stream()
                .sorted(Comparator.comparingInt(Proceso::getPrioridad)
                        .thenComparingInt(Proceso::getOrdenLlegada))
                .collect(Collectors.toList())
        );
    }

    private boolean bloquearProceso(Proceso proceso) {
        return random.nextDouble() < 0.5;
    }
    
    private boolean desbloquearProceso(Proceso proceso) {
        return random.nextDouble() < 0.7;
    }

    public void ejecutar() {
        System.out.println("\n--- Inicio de la simulación ---");
        int tiempoTotal = 0;
        
        while (!colaProcesos.isEmpty()) {
            Proceso procesoActual = colaProcesos.poll();

            if (procesosBloqueados.contains(procesoActual.getId())) {
                if (desbloquearProceso(procesoActual)) {
                    System.out.println("Proceso " + procesoActual.getId() + " se ha desbloqueado y puede ejecutarse.");
                    procesosBloqueados.remove(procesoActual.getId());
                } else {
                    System.out.println("Proceso " + procesoActual.getId() + " sigue bloqueado y se reencola.");
                    colaProcesos.add(procesoActual);
                    continue;
                }
            }

            int tiempoUsado = Math.min(procesoActual.getTiempoRestante(), quantum);
            procesoActual.setTiempoRestante(procesoActual.getTiempoRestante() - tiempoUsado);
            procesoActual.incrementarTiempoEjecucion(tiempoUsado);
            tiempoTotal += tiempoUsado;

            System.out.println("\nEjecutando proceso: " + procesoActual.getId() + 
                               " | Quantum utilizado: " + tiempoUsado);
            System.out.printf("%-10s%-20s%-20s%-15s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad", "Orden Llegada");
            System.out.println("------------------------------------------------------------------");
            System.out.printf("%-10d%-20d%-20d%-15d%-15d\n", procesoActual.getId(), procesoActual.getTiempoEjecucion(), procesoActual.getTiempoRestante(), procesoActual.getPrioridad(), procesoActual.getOrdenLlegada());

            if (procesoActual.getTiempoRestante() > 0) {
                if (bloquearProceso(procesoActual)) {
                    System.out.println("Proceso " + procesoActual.getId() + " se ha bloqueado y será reencolado.");
                    procesosBloqueados.add(procesoActual.getId());
                }
                System.out.println("Proceso " + procesoActual.getId() + " se reencola al final de la cola.");
                colaProcesos.add(procesoActual);
            } else {
                System.out.println("Proceso " + procesoActual.getId() + " ha terminado.");
            }
        }

        System.out.println("\n--- Reporte Final ---");
        System.out.println("Tiempo total de ejecución: " + tiempoTotal + " unidades de tiempo.");
    }
}