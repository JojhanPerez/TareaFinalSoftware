package david;

public abstract class DatosBase {
    private String origen;
    private String destino;
    private double duracion;
    private double precio;

    public DatosBase(String origen, String destino, double duracion, double precio){
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String getOrigen(){
        return this.origen;
    }
    public String getDestino(){
        return this.destino;
    }
    public double getDuracion(){
        return this.duracion;
    }
    public double getPrecio(){
        return this.precio;
    }
}
