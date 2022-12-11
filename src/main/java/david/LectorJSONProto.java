package david;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
public class LectorJSONProto {

    private String rutaArchivo;
    
    
    public LectorJSONProto(String ruta){
        this.rutaArchivo = ruta;
    }

    public List<Ruta> leerDatosJSON(String nombreArchivo) throws IOException{
        Path rutaArchivo = Paths.get("src/main/java/david/" + nombreArchivo);
        BufferedReader lector = Files.newBufferedReader(rutaArchivo);
        String datos = "";
        String linea;
        List<Ruta> rutas = new ArrayList<>();
        while((linea = lector.readLine()) != null){
            datos = datos + linea;
        }
        JSONArray jsonArray = new JSONArray(datos);
        for (int i = 0; i < jsonArray.length(); i++) {  
            JSONObject explrObject = jsonArray.getJSONObject(i);  
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
