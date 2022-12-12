package vuelos.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vuelos.entidades.Ruta;
import vuelos.entidades.Vuelo;

public class ControlVuelos {
    private List<Ruta> rutas;
    private List<Vuelo> posiblesVuelos = new ArrayList<>();

    public ControlVuelos() {

    }

    public List<Vuelo> getPosiblesVuelos() {
        return posiblesVuelos;
    }

    /**
     * Este metodo instancia un objeto de tipo cargador datos
     * y usa el metodo cargarDatos de este para empezar a llenar la lista.
     */
    public void cargarDatosIniciales() {
        try {
            CargadorDatos cargador = new CargadorDatos();
            rutas = cargador.cargarDatos();
        } catch (IOException e) {
            System.out.println("Se ha producido un error al cargar los datos iniciales");
        }
    }

    /**
     * Este metodo se encarga de llenar una lista con 
     * las rutas directas segun la información entregada
     * por el usuario.
     * @param origen
     * @param destino
     * @return rutasSinEscala
     */
    public List<Ruta> buscarRutasSinEscala(String origen, String destino) {

        List<Ruta> rutasSinEscala = new ArrayList<>();

        for (int i = 0; i < rutas.size(); i++) {
            double duracionVuelo = rutas.get(i).getDuracion();
            double precioVuelo = rutas.get(i).getPrecio();

            if (rutas.get(i).getOrigen().equals(origen) && rutas.get(i).getDestino().equals(destino)) {
                Ruta posibleRuta = new Ruta(origen, destino, duracionVuelo, precioVuelo);
                rutasSinEscala.add(posibleRuta);
            }
        }

        return rutasSinEscala;
    }

    /**
     * Este metodo se encarga de llenar una lista con 
     * las rutas indirectas segun la información entregada
     * por el usuario.
     * @param origen
     * @param destino
     * @return rutasConEscala
     */
    public List<Ruta> buscarRutasConEscala(String origen, String destino) {

        List<Ruta> rutasConEscala = new ArrayList<>();

        for (int i = 0; i < rutas.size(); i++) {
            for (int j = 0; j < rutas.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (rutas.get(i).getOrigen().equals(origen) &&
                        rutas.get(j).getOrigen().equals(rutas.get(i).getDestino()) &&
                        rutas.get(j).getDestino().equals(destino)) {
                    Ruta posibleRuta = new Ruta(origen,
                            destino,
                            rutas.get(i).getDuracion() + rutas.get(j).getDuracion(),
                            rutas.get(i).getPrecio() + rutas.get(j).getPrecio());

                    rutasConEscala.add(posibleRuta);
                }
            }
        }

        return rutasConEscala;
    }

    /**
     * Este metodo se encarga de crear los vuelos diferenciando 
     * segun si son vuelos indirectos o directos
     * @param origen
     * @param destino
     */
    public void crearVuelos(String origen, String destino) {

        List<Ruta> rutasConEscala = buscarRutasConEscala(origen, destino);
        List<Ruta> rutasSinEscala = buscarRutasSinEscala(origen, destino);

        for (Ruta ruta : rutasConEscala) {
            posiblesVuelos
                    .add(new Vuelo(ruta.getOrigen(), ruta.getDestino(), ruta.getDuracion(), ruta.getPrecio(), false));
        }

        for (Ruta ruta : rutasSinEscala) {
            posiblesVuelos
                    .add(new Vuelo(ruta.getOrigen(), ruta.getDestino(), ruta.getDuracion(), ruta.getPrecio(), true));
        }

    }

}
