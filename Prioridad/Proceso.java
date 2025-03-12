package Prioridad;

public class Proceso {
    int id;
    int tiempoEjecucion;
    int tiempoRestante;
    int prioridad;
    String estado;

    public Proceso(int id, int tiempoEjecucion, int prioridad) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;
        this.prioridad = prioridad;
        this.estado = "Nuevo";
    }
}

