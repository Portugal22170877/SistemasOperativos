import java.util.*;
import algoritmos;

public class PlanificadorDeProcesos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- PLANIFICADOR DE PROCESOS ---");
            System.out.println("1. Round Robin");
            System.out.println("2. Prioridades");
            System.out.println("3. Múltiples Colas");
            System.out.println("4. SJF");
            System.out.println("5. Planificación Garantizada");
            System.out.println("6. Boletos de Lotería");
            System.out.println("7. Planificación Equitativa");
            System.out.println("8. Salir");
            System.out.print("Seleccione un algoritmo: ");
            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("¿Debe ser apropiativo? (S/N): ");
                char apropiativo = scanner.next().toUpperCase().charAt(0);
                boolean esApropiativo = (apropiativo == 'S');
                
                switch (opcion) {
                    case 1:
                        System.out.println("Ejecutando Round Robin (" + (esApropiativo ? "Apropiativo" : "No Apropiativo") + ")...");
                        new algoritmos.RoundRobin(esApropiativo).ejecutar();
                        break;
                    case 2:
                        System.out.println("Ejecutando Planificación por Prioridades (" + (esApropiativo ? "Apropiativo" : "No Apropiativo") + ")...");
                        new algoritmos.Prioridades(esApropiativo).ejecutar();
                        break;
                    case 3:
                        System.out.println("Ejecutando Múltiples Colas...");
                        new algoritmos.MultiplesColas().ejecutar();
                        break;
                    case 4:
                        System.out.println("Ejecutando SJF (" + (esApropiativo ? "Apropiativo" : "No Apropiativo") + ")...");
                        new algoritmos.SJF(esApropiativo).ejecutar();
                        break;
                    case 5:
                        System.out.println("Ejecutando Planificación Garantizada...");
                        new algoritmos.PlanificacionGarantizada().ejecutar();
                        break;
                    case 6:
                        System.out.println("Ejecutando Boletos de Lotería (" + (esApropiativo ? "Apropiativo" : "No Apropiativo") + ")...");
                        new algoritmos.BoletosLoteria(esApropiativo).ejecutar();
                        break;
                    case 7:
                        System.out.println("Ejecutando Planificación Equitativa...");
                        new algoritmos.PlanificacionEquitativa().ejecutar();
                        break;
                }
            } else if (opcion == 7) {
                System.out.println("Ejecutando Planificación Equitativa...");
                new algoritmos.PlanificacionEquitativa().ejecutar();
            } else if (opcion == 8) {
                System.out.println("Saliendo...");
                salir = true;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
