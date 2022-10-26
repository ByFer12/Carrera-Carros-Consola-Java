package manejadores;
import java.util.Scanner;

import enums.TipoPistas;
import objetos.Pista;

public class ManejadorPista {
    static Scanner ent = new Scanner(System.in);
    Pista pistas;

    public static void menuPistas(){
        Menu.mostrarDatos();
        int opcion;
        System.out.println("1--------Ver Gasolina necesaria para cada pista");
        System.out.println("2--------Ver Pistas");
        System.out.println("3--------Regresar");
        opcion=ent.nextInt();
        switch(opcion){
            case 1:
                verGasolina();
            break;

            case 2:
                verPistas();
            break;

            case 3:
            Menu.menuJuego();
            break;
        }
    }

    public static void verGasolina(){
        System.out.println(TipoPistas.ARENA.toString()+" Necesita de "+TipoPistas.ARENA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.TIERRA.toString()+" Necesita de "+TipoPistas.TIERRA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.CONCRETO.toString()+" Necesita de "+TipoPistas.CONCRETO.getLongitud()+" Galones de gasolina");
    }

    public static void verPistas(){
        System.out.println("PISTA DE ARENA");
        System.out.println("Longitud: "+TipoPistas.ARENA.getLongitud()+" Coeficiente: "+TipoPistas.ARENA.getCoeficiente());
        System.out.println();

    }
}
