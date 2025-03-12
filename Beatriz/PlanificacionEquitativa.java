import java.util.*;

class Proceso {
    int id, tiempoRestante, prioridad, usuario, boletos, usosCPU;
    String estado;
    
    public Proceso(int id) {
        Random rand = new Random();
        this.id = id;
        this.tiempoRestante = rand.nextInt(8) + 3;
        this.estado = rand.nextBoolean() ? "Listo" : "Bloqueado";
        this.prioridad = rand.nextInt(5) + 1;
        this.usuario = rand.nextInt(3) + 1;
        this.boletos = rand.nextInt(10) + 1;
        this.usosCPU = 0;
    }
}

interface Planificacion {
    void ejecutar(List<Proceso> procesos);
    String getNombre();
}

class RoundRobin implements Planificacion {
    private final int quantum = new Random().nextInt(4) + 2;
    
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Round Robin con quantum de " + quantum);
    }
    
    @Override
    public String getNombre() {
        return "Round Robin";
    }
}

class Prioridades implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Planificación por Prioridades...");
        procesos.sort(Comparator.comparingInt(p -> -p.prioridad));
    }
    
    @Override
    public String getNombre() {
        return "Prioridades";
    }
}

class MultiplesColas implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Múltiples Colas de Prioridad...");
        procesos.sort(Comparator.comparingInt(p -> p.usosCPU));
    }
    
    @Override
    public String getNombre() {
        return "Múltiples Colas de Prioridad";
    }
}

class SJF implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Proceso Más Corto Primero (SJF)...");
        procesos.sort(Comparator.comparingInt(p -> p.tiempoRestante));
    }
    
    @Override
    public String getNombre() {
        return "Proceso Más Corto Primero (SJF)";
    }
}

class PlanificacionGarantizada implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Planificación Garantizada...");
    }
    
    @Override
    public String getNombre() {
        return "Planificación Garantizada";
    }
}

class ParticipacionEquitativa implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Participación Equitativa...");
    }
    
    @Override
    public String getNombre() {
        return "Participación Equitativa";
    }
}

class BoletosLoteria implements Planificacion {
    @Override
    public void ejecutar(List<Proceso> procesos) {
        System.out.println("Ejecutando Boletos de Lotería...");
        int totalBoletos = procesos.stream().mapToInt(p -> p.boletos).sum();
        int boletoGanador = new Random().nextInt(totalBoletos);
        int acumulado = 0;
        for (Proceso p : procesos) {
            acumulado += p.boletos;
            if (acumulado > boletoGanador) {
                System.out.println("Proceso " + p.id + " seleccionado.");
                break;
            }
        }
    }
    
    @Override
    public String getNombre() {
        return "Boletos de Lotería";
    }
}

class SimuladorPlanificador {
    private List<Proceso> procesos = new ArrayList<>();
    private Planificacion algoritmo;
    private int cambiosProceso = 0;
    private String algoritmoUsado;
    
    public SimuladorPlanificador() {
        int numProcesos = new Random().nextInt(10) + 1;
        for (int i = 0; i < numProcesos; i++) {
            procesos.add(new Proceso(i));
        }
        seleccionarAlgoritmoAleatorio();
    }

    private void seleccionarAlgoritmoAleatorio() {
        List<Planificacion> algoritmos = Arrays.asList(
            new RoundRobin(), new Prioridades(), new MultiplesColas(), new SJF(),
            new PlanificacionGarantizada(), new ParticipacionEquitativa(), new BoletosLoteria()
        );
        this.algoritmo = algoritmos.get(new Random().nextInt(algoritmos.size()));
        this.algoritmoUsado = algoritmo.getNombre();
    }

    public void ejecutar() {
        algoritmo.ejecutar(procesos);
        mostrarResultados();
    }

    private void mostrarResultados() {
        System.out.println("\n--- Informe Final ---");
        System.out.println("Algoritmo utilizado: " + algoritmoUsado);
        System.out.println("Total de cambios de procesos: " + cambiosProceso);
        System.out.println("Matriz de procesos:");
        System.out.printf("%-4s %-10s %-17s %-10s %-7s %-7s %-7s\n", "ID", "Estado", "Tiempo Restante", "Prioridad", "Usuario", "Boletos", "Usos CPU");
        for (Proceso p : procesos) {
            System.out.printf("%-4d %-10s %-17d %-10d %-7d %-7d %-7d\n", p.id, p.estado, p.tiempoRestante, p.prioridad, p.usuario, p.boletos, p.usosCPU);
        }
    }

    public static void main(String[] args) {
        SimuladorPlanificador planificador = new SimuladorPlanificador();
        planificador.ejecutar();
    }
}
