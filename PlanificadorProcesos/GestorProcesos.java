// Clase GestorProcesos
import java.util.*;
class GestorProcesos {
    List<Proceso> procesos = new ArrayList<>();

    public void agregarProceso(Proceso p) {
        procesos.add(p);
    }

    public List<Proceso> obtenerProcesos() {
        return procesos;
    }
}
