package manejadores;

import java.util.Scanner;

import AyudaExcepciones.Helpers;
import enums.TipoMotor;
import excepciones.MismoMotor;
import objetos.Vehiculo;


public class manejadorGaraje {
    static Helpers h = new Helpers();
    private static Vehiculo vehiculo;

    static Scanner ent=new Scanner(System.in);
    public manejadorGaraje(){
        menuGaraje();
    }


    public static void menuGaraje(){
        Menu.mostrarDatos();
        int opcion=0, salir=0;
        do {
            System.out.println("1-------Mejorar potencia");
            System.out.println("2-------Llenar tanque de gasolina");
            System.out.println("3-------Mejorar llantas");
            System.out.println("4-------Mejorar cambiar de color");
            System.out.println("5-------Ver propiedades del carro actual");
            System.out.println("6-------Comprar otro vehiculo");
            System.out.println("7-------Cambiar carro");
            System.out.println("8-------Volver");
            opcion=ent.nextInt();

            switch (opcion) {
                case 1:
                    mejorarPotencia();  
                    break;
                case 2:
                    
                    break;

                case 3:
                    
                    break;
                
                case 4:
                    
                    break;

                case 5:
                    
                    break;

                case 6:
                    
                    break;
                case 7:
                    
                    break;

                case 8:
                    salir=1;
                    break;
                default:
                    break;
            }
        } while (salir!=1);
    }



    public static void mejorarPotencia(){
        int elegirVehiculo,opcion=0;
        Menu.jugador.mostrarVehiculos();
        System.out.print("Elije el vehiculo a modificar: ");
        elegirVehiculo=ent.nextInt();
        vehiculo =Menu.jugador.unVehiculo(elegirVehiculo-1);
        System.out.println(vehiculo.getNombre());
        System.out.println("");
        do {

            System.out.println("\tMEJORAR POTENCIA");
            System.out.println("1--------Cambiar a motor basico");
            System.out.println("2--------Cambiar a motor medio ");
            System.out.println("3--------Cambiar a motor de alto rendimiento");
            System.out.println("4--------Regresar");
            opcion=ent.nextInt();
            switch (opcion) {
                case 1:

                    try {
                        boolean listo=h.setMotor1(vehiculo);
                        if(listo){

                            
                            vehiculo.setMotor(TipoMotor.MOTOR_BASICO);
                            System.out.println("Motor modificado correctamente...");

                        }
                    } catch (MismoMotor e) {
                        System.out.println("No se ha podido cambiar debido a que");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                
                
                    try {
                        boolean listo=h.setMotor2(vehiculo);
                        if(listo){

                        
                            vehiculo.setMotor(TipoMotor.MOTOR_MEDIO);
                            Menu.jugador.mostrarVehiculos();
                            System.out.println("Motor modificado correctamente...");

                        }
                    } catch (MismoMotor e) {
                       System.out.println("No se ha podido cambiar debido a que");
                       System.out.println( e.getMessage());
                    }
                    break;
                case 3:
            
                    try {
                        boolean listo=h.setMotor3(vehiculo);
                        if(listo){                       
                        vehiculo.setMotor(TipoMotor.MOTOR_ALTO_RENDIMIENTO);
                            
                        System.out.println("Motor modificado correctamente...");
                        }
                    } catch (MismoMotor e) {
                       System.out.println("No se ha podido cambiar debido a que");
                       System.out.println( e.getMessage());
                    }
                    break;
                case 4:
                    opcion=0;
                        
                        break;
                default:
                System.out.println("El numero que ha elegido no es valido");
                    break;
            }            
        } while (opcion!=0);
    }
}
