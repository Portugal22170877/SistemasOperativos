package PlanificadorDeProcesos;

class Proceso {
    private static int contadorId = 1;
    private int id;
    private int tiempoEjecucion;
    private int prioridad;
    private int tiempoRestante;

    public Proceso(int tiempoEjecucion, int prioridad) {
        this.id = contadorId++;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;
        this.prioridad = prioridad;
    }

    public int getId() { return id; }
    public int getTiempoEjecucion() { return tiempoEjecucion; }
    public int getTiempoRestante() { return tiempoRestante; }
    public void setTiempoRestante(int tiempo) { this.tiempoRestante = tiempo; }
    public int getPrioridad() { return prioridad; }
}