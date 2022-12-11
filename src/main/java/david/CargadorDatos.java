package david;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CargadorDatos{

    public CargadorDatos(){

    }
    public List<Ruta> cargarDatos() throws IOException{
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