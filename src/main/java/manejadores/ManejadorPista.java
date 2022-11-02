package manejadores;
import java.util.Scanner;

import enums.TipoPistas;
import objetos.Pista;

public class ManejadorPista {
    static Scanner ent = new Scanner(System.in);
    static Pista []pistas=new Pista[3];
    public ManejadorPista(){
        pistas[0]=new Pista(TipoPistas.TIERRA);
        pistas[1]=new Pista(TipoPistas.ARENA);
        pistas[2]=new Pista(TipoPistas.CONCRETO);

    }


    public static Pista unaPista(int position){
        Pista newPista;
        newPista=pistas[position];
        return newPista;

    }

    public  void menuPistas(){

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
        for (int i = 0; i < pistas.length; i++) {
            System.out.println((i+1)+")\t \033[1;37m PISTA TIPO "+pistas[i].getPistas().toString());
            System.out.println("Longitud: "+pistas[i].getPistas().getLongitud()+" Coeficiente: "+pistas[i].getPistas().getCoeficiente());
            System.out.println(pistas[i].getPistas().getColor()+pistas[i].getCaracter());
        }


    }
}
