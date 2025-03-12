package Prioridad;
import java.util.*;

public class Utilidades {
    public static void imprimirProcesos(List<Proceso> procesos) {
        System.out.println("ID | Tiempo Total | Tiempo Restante | Prioridad | Estado");
        System.out.println("---------------------------------------------------");
        for (Proceso p : procesos) {
            System.out.printf("%2d | %12d | %14d | %8d | %s%n", p.id, p.tiempoEjecucion, p.tiempoRestante, p.prioridad, p.estado);
        }
        System.out.println("---------------------------------------------------");
    }
}