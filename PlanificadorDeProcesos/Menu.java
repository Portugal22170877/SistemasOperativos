package PlanificadorDeProcesos;
import java.util.*;
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Proceso> procesos = new ArrayList<>();

        int quantum = random.nextInt(5) + 1; // Quantum aleatorio entre 1 y 5
        

        // Menú de selección de algoritmos
        while (true) {
            System.out.println("\nSeleccione el algoritmo de planificación:");
            System.out.println("1. Round Robin apropiativo");
            System.out.println("2. Round Robin No apropiativo");
            System.out.println("3. Prioridades apropiativo");
            System.out.println("4. Prioridades no apropiativo");
            System.out.println("5. Múltiples colas de prioridades apropiativo");
            System.out.println("6. Múltiples colas de prioridades no apropiativo");
            System.out.println("7. Boletos de Lotería apropiativo");
            System.out.println("8. Boletos de Lotería no apropiativo");
            System.out.println("9. Proceso más corto primero");
            System.out.println("10. Planificación garantizada");
            System.out.println("11. Planificación equitativa");
            System.out.println("12. Salir");
            
            int opcion = scanner.nextInt();
            if (opcion == 12) break;

            // Generar quantum aleatorio después de elegir el algoritmo
            int Quantum = random.nextInt(5) + 1; // Quantum aleatorio entre 1 y 5
            System.out.println("Quantum generado aleatoriamente: " + quantum);
            
            // Generar procesos aleatorios después de elegir el algoritmo
            procesos.clear();
            for (int i = 0; i < 5; i++) {
                procesos.add(new Proceso(random.nextInt(10) + 1, random.nextInt(5) + 1));
            }
            
            System.out.println("Procesos generados:");
            System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Tiempo de Ejecución", "Tiempo Restante", "Prioridad");
            System.out.println("-------------------------------------------------------------");
            for (Proceso p : procesos) {
                System.out.printf("%-10d%-20d%-20d%-15d\n", p.getId(), p.getTiempoEjecucion(), p.getTiempoRestante(), p.getPrioridad());
            }
            
            if (opcion == 1) {
                RoundRobinApropiativo rr = new RoundRobinApropiativo(procesos, quantum);
                rr.ejecutar();
            } else if (opcion == 2) {
                new RoundRobinNoApropiativo(procesos, quantum).ejecutar();
            } 
            if (opcion == 3) {
                new PrioridadesApropiativo(procesos, quantum).ejecutar();
            
            } 
            if (opcion == 4) {
                new PrioridadesNoApropiativo(procesos).ejecutar();
            } 
            if (opcion == 5) {
                new MultiplesColasPrioridadesApropiativo(procesos, quantum).ejecutar();
            }
            if (opcion == 6) {
                new MultiplesColasPrioridadesNoApropiativo(procesos, quantum).ejecutar();
            }
            if (opcion == 7) {
                new BoletosDeLoteriaApropiativo(procesos, quantum).ejecutar();
            }
            if (opcion == 8) {
                new BoletosDeLoteriaNoApropiativo(procesos, quantum).ejecutar();
            }
            if (opcion == 9) {
                new ProcesoMasCortoPrimero(procesos).ejecutar();
            }
            if (opcion == 10) {
                new PlanificacionGarantizada(procesos).ejecutar();
            }
            if (opcion == 11) {
                new PlanificacionEquitativa(procesos).ejecutar();
            }

        }
        
        scanner.close();
    }
}
