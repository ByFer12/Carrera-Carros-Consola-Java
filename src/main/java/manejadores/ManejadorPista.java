package manejadores;
import java.util.Scanner;

import enums.TipoPistas;
import objetos.Pista;

public class ManejadorPista {
    static Scanner ent = new Scanner(System.in);
    static Pista pistas;

    public static void menuPistas(){

        Menu.mostrarDatos();
        int opcion,desicion=0;
        do {
            
            System.out.println("\u001B[37m1--------Ver Gasolina necesaria para cada pista");
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
                desicion=1;
                
                break;
            }
        } while (desicion!=1);
        }
        
    public static void verGasolina(){
        System.out.println("\n");
        System.out.println(TipoPistas.ARENA.toString()+" Necesita de "+TipoPistas.ARENA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.TIERRA.toString()+" Necesita de "+TipoPistas.TIERRA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.CONCRETO.toString()+" Necesita de "+TipoPistas.CONCRETO.getLongitud()+" Galones de gasolina");
        System.out.println("\n");
    }

    public static void verPistas(){
        System.out.println("\nPISTA DE TIERRA");
        pistas=new Pista(TipoPistas.TIERRA);
        System.out.println("Longitud: "+TipoPistas.TIERRA.getLongitud()+" Coeficiente: "+TipoPistas.TIERRA.getCoeficiente());
        System.out.println(TipoPistas.TIERRA.getColor()+pistas.getCaracter());


        System.out.println("\n\u001B[37m PISTA DE ARENA");
        pistas=new Pista(TipoPistas.ARENA);
        System.out.println("Longitud: "+TipoPistas.ARENA.getLongitud()+" Coeficiente: "+TipoPistas.ARENA.getCoeficiente());
        System.out.println(TipoPistas.ARENA.getColor()+ pistas.getCaracter());

        
        System.out.println("\n\u001B[37m  PISTA DE CONCRETO");
        pistas=new Pista(TipoPistas.CONCRETO);
        System.out.println("Longitud: "+TipoPistas.CONCRETO.getLongitud()+" Coeficiente: "+TipoPistas.CONCRETO.getCoeficiente());
        System.out.println(TipoPistas.CONCRETO.getColor()+pistas.getCaracter());
        System.out.println("");


    }
}
