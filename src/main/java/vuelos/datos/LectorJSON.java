package vuelos.datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.JSONArray;

public class LectorJSON {

    private String nombreArchivo;

    public LectorJSON(String ruta) {
        this.nombreArchivo = ruta;
    }

    /**
     * Este metodo se encarga de seguir una ruta que lo lleva  a un archivo json
     * y mediante este genera un JSONArray con la informacion retenida
     * @return jsonArray
     * @throws IOException
     */
    public JSONArray leerDatosJSON() throws IOException {
        Path rutaArchivo = Paths.get("src/main/java/vuelos/datos/" + nombreArchivo);
        BufferedReader lector = Files.newBufferedReader(rutaArchivo);
        String datos = "";
        String linea;
        while ((linea = lector.readLine()) != null) {
            datos = datos + linea;
        }
        JSONArray jsonArray = new JSONArray(datos);
        return jsonArray;
    }

}
