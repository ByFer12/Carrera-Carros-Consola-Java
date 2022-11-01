package principal;


import enums.TipoLlanta;
import enums.TipoMotor;
import manejadores.Menu;
import objetos.Jugador;
import objetos.Vehiculo;

public class Ejecutable {


    public static void main(String[] args) {
       //Menu menu = new Menu();
       Vehiculo v=new Vehiculo("Truck",TipoMotor.MOTOR_BASICO,TipoLlanta.CALIDAD_MEDIA,100,"A");
       Vehiculo v1=new Vehiculo("Bolido",TipoMotor.MOTOR_ALTO_RENDIMIENTO,TipoLlanta.CALIDAD_MEDIA,90,"B");
       Jugador j= new Jugador("Byron", "Tux", 23);
       j.agregarVehiculo(v);
       j.agregarVehiculo(v1);
       j.mostrarVehiculos();

    }
    
}
