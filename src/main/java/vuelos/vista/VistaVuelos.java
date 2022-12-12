package vuelos.vista;

import java.util.Scanner;

import vuelos.logica.ControlVuelos;

public class VistaVuelos {

    private ControlVuelos control = new ControlVuelos();

    public VistaVuelos() {

    }

    /**
     * Este metodo se encarga de mostrar los vuelos que cumplen 
     * con los requisitos del usuario diferenciandolos entre si son con 
     * escala o no.
     * @param origen
     * @param destino
     */
    public void mostrarVuelos(String origen, String destino) {

        this.control.crearVuelos(origen, destino);

        if (this.control.getPosiblesVuelos().isEmpty()) {
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
        for (int i = 0; i < this.control.getPosiblesVuelos().size(); i++) {
            if (this.control.getPosiblesVuelos().get(i).getDirecto()) {
                mensajeEscala = "Sin escala";
            } else {
                mensajeEscala = "Con escala";
            }
            System.out.println("De " + this.control.getPosiblesVuelos().get(i).getOrigen() +
                    " Hacia " + this.control.getPosiblesVuelos().get(i).getDestino() +
                    " Con una duración de " + this.control.getPosiblesVuelos().get(i).getDuracion() +
                    " horas y un precio de " + this.control.getPosiblesVuelos().get(i).getPrecio() +
                    " " + mensajeEscala);
            mensajeEscala = " ";
        }
        System.out.println(srt.repeat(120));
    }
    
    /**
     * Este metodo se encarga de solicitar el destino y el origen al usuario
     */
    public void interaccionUsuario() {

        Scanner datosUsuario = new Scanner(System.in);
        String origen;
        String destino;

        System.out.print("Ingrese la ciudad desde donde quiere iniciar su viaje: ");
        origen = datosUsuario.nextLine();

        System.out.print("Ingrese la ciudad a la cual quiere viajar: ");
        destino = datosUsuario.nextLine();

        this.control.cargarDatosIniciales();
        mostrarVuelos(origen, destino);
    }

}
