package PlanificadorDeProcesos;

class Proceso {
    private static int contadorId = 1;
    private int id;
    private int tiempoEjecucion;
    private int prioridad;
    private int tiempoRestante;
    private int ordenLlegada;

    public Proceso(int tiempoEjecucion, int prioridad, int ordenLlegada) {
        this.id = contadorId++;
        this.tiempoEjecucion = 0;
        this.tiempoRestante = tiempoEjecucion;
        this.prioridad = prioridad;
        this.ordenLlegada = ordenLlegada;
    }

    public int getId() { return id; }
    public int getTiempoEjecucion() { return tiempoEjecucion; }
    public int getTiempoRestante() { return tiempoRestante; }
    public void setTiempoRestante(int tiempo) { this.tiempoRestante = tiempo; }
    public void incrementarTiempoEjecucion(int tiempo) { this.tiempoEjecucion += tiempo; }
    public int getPrioridad() { return prioridad; }
    public int getOrdenLlegada() { return ordenLlegada; }
}