import java.util.*;
import Planificacion;
import Prioridad;
import Roundrobin;
import Boletos;
import MultipleColaPrioridadYProcesoCorto;  

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        List<Proceso> procesos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            int tiempoTotal = rand.nextInt(10) + 1;
            int prioridad = rand.nextInt(5) + 1;
            procesos.add(new Proceso(i, tiempoTotal, prioridad));
        }

        System.out.println("Seleccione el tipo de planificación:");
        System.out.println("1. Planificación Equitativa");
        System.out.println("2. Planificación Garantizada");
        System.out.println("3. Prioridad Apropiativo");
        System.out.println("4. Prioridad No Apropiativo");
        System.out.println("5. Round Robin Apropiativo");
        System.out.println("6. Round Robin No Apropiativo");
        System.out.println("7. Boletos de Lotería Apropiativo");
        System.out.println("8. Boletos de Lotería No Apropiativo");
        System.out.println("9. Prioridad Apropiativo (Múltiples Colas)");
        System.out.println("10. Prioridad No Apropiativo (Múltiples Colas)");
        System.out.println("11. SJF (Proceso Corto Primero)");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                new Planificacion.PlanificacionEquitativa().ejecutar(new ArrayList<>(procesos));
                break;
            case 2:
                new Planificacion.PlanificacionGarantizada().ejecutar(new ArrayList<>(procesos));
                break;
            case 3:
                new Prioridad.PrioridadApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 4:
                new Prioridad.PrioridadNoApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 5:
                new Roundrobin.RoundRobinApropiativo(4).ejecutar(new ArrayList<>(procesos));
                break;
            case 6:
                new Roundrobin.RoundRobinNoApropiativo(4).ejecutar(new ArrayList<>(procesos));
                break;
            case 7:
                new Boletos.BoletosLoteriaApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 8:
                new Boletos.BoletosLoteriaNoApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 9:
                new MultipleColaPrioridadYProcesoCorto.PlanificadorPrioridadApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 10:
                new MultipleColaPrioridadYProcesoCorto.PlanificadorPrioridadNoApropiativo().ejecutar(new ArrayList<>(procesos));
                break;
            case 11:
                new MultipleColaPrioridadYProcesoCorto.PlanificadorSJF().ejecutar(new ArrayList<>(procesos));
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
