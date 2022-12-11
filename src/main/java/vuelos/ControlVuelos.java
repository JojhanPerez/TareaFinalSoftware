package vuelos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlVuelos {
    private List<Ruta> rutas;
    private List<Vuelo> posiblesVuelos = new ArrayList<>();

    public ControlVuelos(){

    }

    public void cargarDatosIniciales(){
        try {
            CargadorDatos cargador = new CargadorDatos();
            rutas = cargador.cargarDatos();
        } catch (IOException e) {
            System.out.println("Se ha producido un error al cargar los datos iniciales");
        }
    }

    public void buscarRutasSinEscala(String origen, String destino){

        for(int i = 0; i < rutas.size(); i++){
            String origenVuelo = rutas.get(i).getOrigen();
            String destinVuelo = rutas.get(i).getDestino();
            double duracionVuelo = rutas.get(i).getDuracion();
            double precioVuelo = rutas.get(i).getPrecio();
            boolean directo = true;

            if(origenVuelo.equals(origen) && destinVuelo.equals(destino)){
                this.posiblesVuelos.add(new Vuelo(origenVuelo, destinVuelo, duracionVuelo, precioVuelo, directo));
            }
        }
    }

    public void buscarRutasConEscala(String origen, String destino){
        for(int i = 0; i < rutas.size(); i++){
            for(int j = 0; j < rutas.size(); j++){
                if(i == j){
                    continue;
                }
                if(rutas.get(i).getOrigen().equals(origen) && 
                rutas.get(j).getOrigen().equals(rutas.get(i).getDestino()) && 
                rutas.get(j).getDestino().equals(destino)){
                    this.posiblesVuelos.add(new Vuelo(origen, 
                        destino, 
                        rutas.get(i).getDuracion() + rutas.get(j).getDuracion(), 
                        rutas.get(i).getPrecio() + rutas.get(j).getPrecio(), 
                        true));
                }
            }
        }
    }

    public void mostrarVuelos(String origen, String destino){
        buscarRutasSinEscala(origen, destino);
        buscarRutasConEscala(origen, destino);
        if(posiblesVuelos.isEmpty()){
            System.out.println("No se han encontrado vuelos con origen en " + origen + " y destino en " + destino);
            return;
        }
        System.out.println("Los posibles vuelos son:");
        String mensajeEscala = "";
        for(int i = 0; i < posiblesVuelos.size(); i++){
            if(posiblesVuelos.get(i).getDirecto()){
                mensajeEscala = "Con escala";
            }
            else{
                mensajeEscala = "Sin escala";
            }
            System.out.println("De " + posiblesVuelos.get(i).getOrigen() + 
            " Hacia " + posiblesVuelos.get(i).getDestino() + 
            " Con una duración de " + posiblesVuelos.get(i).getDuracion() + 
            " horas y un precio de " + posiblesVuelos.get(i).getPrecio() +
             " " + mensajeEscala)
            ;
        }
    }

 
}
