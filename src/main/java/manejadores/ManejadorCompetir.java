package manejadores;

import java.util.Scanner;

import objetos.Jugador;
import objetos.Pista;
import objetos.Vehiculo;

public class ManejadorCompetir {
    private Pista pistas;

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


    }
    
    public static void elegirVehiculo() {
        int opcion;
        Menu.jugador.mostrarVehiculos();
        System.out.println("Elige el numero del vehiculo que deseas usar para la carrera: ");
        opcion=ent.nextInt();
        vehiculoJugar=Jugador.unVehiculo(opcion-1);
    }

}