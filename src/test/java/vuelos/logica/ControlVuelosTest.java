package vuelos.logica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vuelos.entidades.Ruta;

public class ControlVuelosTest {
    @Test
    public void origenDestinoEncontrados() {

        List<Ruta> rutasEsperadas = new ArrayList<>();

        Ruta rutaEsperada1 = new Ruta("Pereira", "Cartagena", 1.5, 400000);
        Ruta rutaEsperada2 = new Ruta("Pereira", "Cartagena", 3.5, 340000);

        rutasEsperadas.add(rutaEsperada1);
        rutasEsperadas.add(rutaEsperada2);

        ControlVuelos control = new ControlVuelos();
        List<Ruta> rutasEsperadas2 = new ArrayList<>();
        control.cargarDatosIniciales();
        rutasEsperadas2 = control.buscarRutasConEscala("Pereira", "Cartagena");

        assertEquals(rutasEsperadas.get(0).getOrigen(), rutasEsperadas2.get(0).getOrigen());
        assertEquals(rutasEsperadas.get(0).getDestino(), rutasEsperadas2.get(0).getDestino());
        assertEquals(rutasEsperadas.get(0).getDuracion(), rutasEsperadas2.get(0).getDuracion(), 0);
        assertEquals(rutasEsperadas.get(0).getPrecio(), rutasEsperadas2.get(0).getPrecio(), 0);

        assertEquals(rutasEsperadas.get(1).getOrigen(), rutasEsperadas2.get(1).getOrigen());
        assertEquals(rutasEsperadas.get(1).getDestino(), rutasEsperadas2.get(1).getDestino());
        assertEquals(rutasEsperadas.get(1).getDuracion(), rutasEsperadas2.get(1).getDuracion(), 0);
        assertEquals(rutasEsperadas.get(1).getPrecio(), rutasEsperadas2.get(1).getPrecio(), 0);
    }

    @Test
    public void listaDeRutasVacia(){
        List<Ruta> rutasEsperadas = new ArrayList<>();
        ControlVuelos control = new ControlVuelos();
        List<Ruta> rutasEsperadas2 = new ArrayList<>();
        control.cargarDatosIniciales();
        rutasEsperadas2 = control.buscarRutasConEscala("Medellin", "Leticia");
        assertEquals(rutasEsperadas.isEmpty(), rutasEsperadas2.isEmpty());
    }
}
