package Roundrobin;
class Proceso {
    int id;
    int tiempoEjecucion;
    int tiempoRestante;
    String estado;

    public Proceso(int id, int tiempoEjecucion) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;
        this.estado = "Bloqueado"; // Al inicio, todos los procesos están en espera
    }
}