package manejadores;

import objetos.Jugador;
import objetos.Pista;
import objetos.Vehiculo;

public class ManejadorCompetir {
    private Vehiculo [] vehiculoJugador=new Vehiculo[6];
    private Vehiculo [] vehiculoRival= new Vehiculo[6];
    private Pista pistas;
    private Jugador jugador;

    public ManejadorCompetir(){
        

        
    }

    public static void elegirPista() {
        int desicion=0;
        
        do {
            System.out.println("1---------Elegir Pista");
            System.out.println("2---------Elegir");
        } while (desicion!=1);
        
    }

}