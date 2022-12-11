package vuelos;

public class Ruta extends DatosBase {

    public Ruta(String origen, String destino, double duracion, double precio) {
        super(origen, destino, duracion, precio);
    }

    @Override
    public String toString() {
        return super.getOrigen() + " " + super.getDestino() + " " + super.getDuracion() + " " + super.getPrecio();
    }

}
