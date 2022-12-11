package vuelos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlVuelos {
    private List<Ruta> rutas;
    private List<Vuelo> posiblesVuelos = new ArrayList<>();

    public ControlVuelos() {

    }

    public void cargarDatosIniciales() {
        try {
            CargadorDatos cargador = new CargadorDatos();
            rutas = cargador.cargarDatos();
        } catch (IOException e) {
            System.out.println("Se ha producido un error al cargar los datos iniciales");
        }
    }

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

    public void mostrarVuelos(String origen, String destino) {

        crearVuelos(origen, destino);

        if (posiblesVuelos.isEmpty()) {
            System.out.println("No se han encontrado vuelos con origen en " + origen + " y destino en " + destino);
            return;
        }
        String mensajeEscala = "";
        String esp = " ";
        System.out.println();
        System.out.print(esp.repeat(30));
        System.out.println("Los posibles vuelos son:");
        String srt = "-";
        System.out.println(srt.repeat(120));
        for (int i = 0; i < posiblesVuelos.size(); i++) {
            if (posiblesVuelos.get(i).getDirecto()) {
                mensajeEscala = "Sin escala";
            } else {
                mensajeEscala = "Con escala";
            }
            System.out.println("De " + posiblesVuelos.get(i).getOrigen() +
                    " Hacia " + posiblesVuelos.get(i).getDestino() +
                    " Con una duración de " + posiblesVuelos.get(i).getDuracion() +
                    " horas y un precio de " + posiblesVuelos.get(i).getPrecio() +
                    " " + mensajeEscala);
            mensajeEscala = " ";
        }
        System.out.println(srt.repeat(120));
    }

}
