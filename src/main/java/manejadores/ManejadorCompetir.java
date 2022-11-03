package manejadores;

import java.util.Scanner;

import AyudaExcepciones.Helpers;
import excepciones.GasolinaVehiculoCaminoE;
import excepciones.MaximoRival;
import excepciones.MinimoRival;
import objetos.Jugador;
import objetos.Pista;
import objetos.Vehiculo;

public class ManejadorCompetir {
    private static Pista pistaElegida;
    private static Helpers help=new Helpers();
    private static Vehiculo []vehiculosEnemigos;
    private static Vehiculo vehiculoJugar;
    private static Vehiculo enemigo;
    static Scanner ent = new Scanner(System.in);
    public ManejadorCompetir(){

        elegirPista();
        
    }

    public static void elegirPista(){
        int pistaElegir;
        ManejadorPista.verPistas();
        System.out.print("\n ELija el numero de la pista que desea utilizar para la carrera: ");
        pistaElegir=ent.nextInt();
        pistaElegida=ManejadorPista.unaPista(pistaElegir-1);

        elegirVehiculo();
    }
    
    public static void elegirVehiculo() {
        boolean pasar=false;
        int opcion;
        Menu.jugador.mostrarVehiculos();
        System.out.print("Elige el numero del vehiculo que deseas usar para la carrera: ");
        opcion=ent.nextInt();
        try {
         
          vehiculoJugar=  help.validarVehiculo(Jugador.unVehiculo(opcion-1),pistaElegida);
          System.out.println("Elegido correctamente...\n");
          System.out.println("Nombre del vehiculo: "+vehiculoJugar.getNombre());

        } catch (GasolinaVehiculoCaminoE e) {
           System.out.println("El jugador no posee ningun vehiculo disponible debido a que: "+e.getMessage());
            pasar=true;
        }catch(NullPointerException e){
            System.out.println("No hay suficientes vehiculos");
            pasar=true;
        }
        if(pasar==false){

            elegirRivales();
        }
        
    }


    public static void elegirRivales(){
        int nRivales;
        System.out.print("\n¿Con cuantos rivales desea competir?: ");
        nRivales=ent.nextInt();      
        try {
            int elec=help.minRivales(nRivales);
            vehiculosEnemigos=new Vehiculo[elec];

            for (int i = 0; i <vehiculosEnemigos.length; i++) {
                int aleatorio=(int)(Math.random()*6);
            
                System.out.println("Agregando al vehiculo: "+(i+1));    
                vehiculosEnemigos[i]=ManejadorRival.elegirRival(aleatorio);

            }
            System.out.println("Rivales elegidos");
            for (int i = 0; i < vehiculosEnemigos.length; i++) {
                System.out.println("Etiquetas "+vehiculosEnemigos[i].getEtiqueta());
            }
        } catch (MinimoRival e) {

            System.out.println(e.getMessage());

        }catch(MaximoRival e){

            System.out.println(e.getMessage());
        }
        competencia();

    }


    public static void competencia(){
        String nada;
        System.out.println("EL juego ha comenzado, escriba cualquier letra");
        System.out.println("y presione enter para continuar: ");
        nada=ent.next();
        System.out.println(pistaElegida.getPistas());
        System.out.println(pistaElegida.getPistas().getColor()+ pistaElegida.getCaracter()+"\033[1;37m");

    }


}