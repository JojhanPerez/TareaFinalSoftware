package vuelos.entidades;

public class Vuelo extends DatosBase {
    private boolean directo;

    /* constructor */
    public Vuelo(String origen, String destino, double duracion, double precio, boolean directo) {
        super(origen, destino, duracion, precio);
        this.directo = directo;
    }

    public boolean getDirecto() {
        return directo;
    }

}