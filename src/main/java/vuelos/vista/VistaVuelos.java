package vuelos.vista;

import java.util.Scanner;

import vuelos.logica.ControlVuelos;

public class VistaVuelos {

    public VistaVuelos() {

    }

    public void interaccionUsuario() {

        Scanner datosUsuario = new Scanner(System.in);
        String origen;
        String destino;

        System.out.print("Ingrese la ciudad desde donde quiere iniciar su viaje: ");
        origen = datosUsuario.nextLine();

        System.out.print("Ingrese la ciudad a la cual quiere viajar: ");
        destino = datosUsuario.nextLine();

        ControlVuelos control = new ControlVuelos();
        control.cargarDatosIniciales();
        control.mostrarVuelos(origen, destino);
    }

}