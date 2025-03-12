package MultipleColaPrioridadYProcesoCorto;

public class Proceso {
    int id;
    int tiempoTotal;
    int tiempoRestante;
    int prioridad;
    String estado;

    public Proceso(int id, int tiempoTotal, int prioridad) {
        this.id = id;
        this.tiempoTotal = tiempoTotal;
        this.tiempoRestante = tiempoTotal;
        this.prioridad = prioridad;
        this.estado = "Bloqueado";
    }
}