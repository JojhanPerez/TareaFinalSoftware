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
public class LectorJSON {

    private String nombreArchivo;
    
    
    public LectorJSON(String ruta){
        this.nombreArchivo = ruta;
    }

    public JSONArray leerDatosJSON() throws IOException{
        Path rutaArchivo = Paths.get("src/main/java/david/" + nombreArchivo);
        BufferedReader lector = Files.newBufferedReader(rutaArchivo);
        String datos = "";
        String linea;
        while((linea = lector.readLine()) != null){
            datos = datos + linea;
        }
        JSONArray jsonArray = new JSONArray(datos);
        return jsonArray;
    }
    

}
