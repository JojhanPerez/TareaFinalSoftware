package vuelos;

public class Vuelo extends DatosBase{   
    private boolean directo;

    /*constructor */
    public Vuelo(String origen, String destino, double duracion, double precio, boolean directo){
        super(origen, destino, duracion, precio);
        this.directo = directo;
    }

    @Override
    public String toString() {
        if(directo){
            return super.getOrigen() + " " + super.getDestino() + " " + super.getDuracion() + " " + super.getPrecio() + " Con escala";
        }
        return super.getOrigen() + " " + super.getDestino() + " " + super.getDuracion() + " " + super.getPrecio() + " Sin escala";
    }

    
}