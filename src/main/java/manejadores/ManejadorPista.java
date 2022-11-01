package manejadores;
import java.util.Scanner;

import enums.TipoPistas;
import objetos.Pista;

public class ManejadorPista {
    static Scanner ent = new Scanner(System.in);
    static Pista pistas;

    public static void menuPistas(){

        int opcion,desicion=0;
        do {
            System.out.println("");
            Menu.mostrarDatos();
            
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
        System.out.println("\t*********************************");
        System.out.println("\tGASOLINA NECESARIA POR CADA PISTA");
        System.out.println("\t*********************************");
        System.out.println(TipoPistas.ARENA.toString()+" Necesita de "+TipoPistas.ARENA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.TIERRA.toString()+" Necesita de "+TipoPistas.TIERRA.getLongitud()+" Galones de gasolina");
        System.out.println(TipoPistas.CONCRETO.toString()+" Necesita de "+TipoPistas.CONCRETO.getLongitud()+" Galones de gasolina");
        System.out.println("");
    }

    public static void verPistas(){
        System.out.println("");
        System.out.println("\t******************");
        System.out.println("\tPISTAS DISPONIBLES");
        System.out.println("\t******************");
        System.out.println("***************");
        System.out.println("PISTA DE TIERRA");
        System.out.println("***************");
        pistas=new Pista(TipoPistas.TIERRA);
        System.out.println("Longitud: "+TipoPistas.TIERRA.getLongitud()+" Coeficiente: "+TipoPistas.TIERRA.getCoeficiente());
        System.out.println(TipoPistas.TIERRA.getColor()+pistas.getCaracter());

        System.out.println("");
        System.out.println("**************************");
        System.out.println("\u001B[37m PISTA DE ARENA");
        System.out.println("**************************");
        pistas=new Pista(TipoPistas.ARENA);
        System.out.println("Longitud: "+TipoPistas.ARENA.getLongitud()+" Coeficiente: "+TipoPistas.ARENA.getCoeficiente());
        System.out.println(TipoPistas.ARENA.getColor()+ pistas.getCaracter());

        System.out.println("");
        System.out.println("*****************************");
        System.out.println("\u001B[37m  PISTA DE CONCRETO");
        System.out.println("*****************************");
        pistas=new Pista(TipoPistas.CONCRETO);
        System.out.println("Longitud: "+TipoPistas.CONCRETO.getLongitud()+" Coeficiente: "+TipoPistas.CONCRETO.getCoeficiente());
        System.out.println(TipoPistas.CONCRETO.getColor()+pistas.getCaracter());
        System.out.println("");


    }
}
