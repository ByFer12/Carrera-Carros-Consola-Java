package manejadores;

import java.util.Scanner;

import AyudaExcepciones.Helpers;
import excepciones.GasolinaVehiculoCaminoE;
import objetos.Jugador;
import objetos.Pista;
import objetos.Vehiculo;

public class ManejadorCompetir {
    private static Pista pistaElegida;

    private static Vehiculo vehiculoJugar;
    private Vehiculo enemigo;
    static Scanner ent = new Scanner(System.in);
    public ManejadorCompetir(){

        elegirPista();
        
    }

    public static void elegirPista(){
        int pistaElegir;
        ManejadorPista.verPistas();
        System.out.println("\n ELija el numero de la pista que desea utilizar para la carrera: ");
        pistaElegir=ent.nextInt();
        pistaElegida=ManejadorPista.unaPista(pistaElegir);

        elegirVehiculo();
    }
    
    public static void elegirVehiculo() {
        int opcion;
        Menu.jugador.mostrarVehiculos();
        System.out.println("Elige el numero del vehiculo que deseas usar para la carrera: ");
        opcion=ent.nextInt();
        Helpers help=new Helpers();
        try {
         
          vehiculoJugar=  help.validarVehiculo(Jugador.unVehiculo(opcion-1),pistaElegida);
          System.out.println("Elegido correctamente...\n");
          System.out.println("Nombre del vehiculo: "+vehiculoJugar.getNombre());

        } catch (GasolinaVehiculoCaminoE e) {
           System.out.println("El jugador no posee ningun vehiculo disponible debido a que: "+e.getMessage());
           
        }
    }

}