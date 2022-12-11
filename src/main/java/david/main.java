package david;

public class main{
    public static void main(String[] args) {
        ControlVuelos control = new ControlVuelos();
        control.cargarDatosIniciales();
        control.mostrarVuelos("Manizales", "Cartagena");
    }
}
