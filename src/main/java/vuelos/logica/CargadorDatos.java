package vuelos.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vuelos.datos.LectorJSON;
import vuelos.entidades.Ruta;

public class CargadorDatos {

    public CargadorDatos() {

    }

    /**
     * Este metodo se encarga de crear las rutas con la informacion contenida en
     * el jsonArray y las añade a un ArrayList
     * @return rutas
     * @throws IOException
     */
    public List<Ruta> cargarDatos() throws IOException {
        LectorJSON lector = new LectorJSON("Rutas.json");
        JSONArray rutasJson = lector.leerDatosJSON();
        List<Ruta> rutas = new ArrayList<>();

        for (int i = 0; i < rutasJson.length(); i++) {
            JSONObject explrObject = rutasJson.getJSONObject(i);
            String origen = explrObject.get("origen").toString();
            String destino = explrObject.get("destino").toString();
            double precio = Double.valueOf(explrObject.get("precio").toString());
            double duracion = Double.valueOf(explrObject.get("duracion").toString());
            Ruta ruta = new Ruta(origen, destino, duracion, precio);
            rutas.add(ruta);
        }
        return rutas;

    }
}