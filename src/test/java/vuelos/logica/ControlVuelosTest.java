package vuelos.logica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vuelos.entidades.Ruta;

public class ControlVuelosTest {
    @Test
    public void origenDestinoEncontrados() {

        List<Ruta> rutas = new ArrayList<>();

        Ruta rutaEsperada1 = new Ruta("Pereira", "Cartagena", 1.5, 400000);
        Ruta rutaEsperada2 = new Ruta("Pereira", "Cartagena", 2, 340000);

        rutas.add(rutaEsperada1);
        rutas.add(rutaEsperada2);

        ControlVuelos control = new ControlVuelos();

        List<Ruta> rutas2 = new ArrayList<>();

        rutas2 = control.buscarRutasConEscala("Pereira", "Cartagena");

        assertEquals(rutaEsperada1, rutas2.get(0));

    }
}
