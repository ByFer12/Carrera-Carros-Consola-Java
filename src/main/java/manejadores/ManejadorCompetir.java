package manejadores;

import java.util.Scanner;

import AyudaExcepciones.Helpers;
import excepciones.GasolinaVehiculoCaminoE;
import excepciones.MaximoRival;
import excepciones.MinimoRival;

import objetos.Pista;
import objetos.Vehiculo;

public class ManejadorCompetir {
    private static Pista pistaElegida;
    private static Helpers help = new Helpers();
    private static Vehiculo[] vehiculosEnemigos;
    private static Vehiculo vehiculoJugar;
    public static String resetColor = "\u001B[0m";
    static Scanner ent = new Scanner(System.in);

    public ManejadorCompetir() {
        elegirPista();

    }

    public static void elegirPista() {
        int pistaElegir;
        ManejadorPista.verPistas();
        System.out.print("\n ELija el numero de la pista que desea utilizar para la carrera: ");
        pistaElegir = ent.nextInt();
        pistaElegida = ManejadorPista.unaPista(pistaElegir - 1);

        elegirVehiculo();
    }

    public static void elegirVehiculo() {
        boolean pasar = false;
        int opcion;
        Menu.jugador.mostrarVehiculos();
        System.out.print("Elige el numero del vehiculo que deseas usar para la carrera: ");
        opcion = ent.nextInt();
        try {

            vehiculoJugar = help.validarVehiculo(Menu.jugador.unVehiculo(opcion - 1), pistaElegida);
            System.out.println("Elegido correctamente...\n");
            System.out.println("Nombre del vehiculo: " + vehiculoJugar.getNombre());

        } catch (GasolinaVehiculoCaminoE e) {
            System.out.println("El jugador no posee ningun vehiculo disponible debido a que: " + e.getMessage());
            pasar = true;
        } catch (NullPointerException e) {
            System.out.println("No hay suficientes vehiculos");
            pasar = true;
        }
        if (pasar == false) {

            elegirRivales();
        }

    }

    // elegir un rival
    public static void elegirRivales() {
        int nRivales; // variable para guardar cantidad de rivales
        System.out.print("\n¿Con cuantos rivales desea competir?: ");
        nRivales = ent.nextInt();
        try {
            int elec = help.minRivales(nRivales);// intenta validar que la cantidad no sea menor a 2 ni mayor a 6 en
                                                 // otra clase con otra funcion:
            vehiculosEnemigos = new Vehiculo[elec];// creael arreglo para los vehiculo enemigos con la caitidad anterior

            for (int i = 0; i < vehiculosEnemigos.length; i++) {//
                int aleatorio = (int) (Math.random() * 6);
                vehiculosEnemigos[i] = ManejadorRival.elegirRival(aleatorio);
            }
            System.out.println("Rivales elegidos");
            for (int i = 0; i < vehiculosEnemigos.length; i++) {
                System.out.println("Etiquetas " + vehiculosEnemigos[i].getEtiqueta());
            }
        } catch (MinimoRival e) {

            System.out.println(e.getMessage());

        } catch (MaximoRival e) {

            System.out.println(e.getMessage());
        }
        competencia();

    }

    public static void competencia() {
        System.out.println("EL juego ha comenzado, los turnos seran aleatorios por cada ronda");
        char pista[] = new char[pistaElegida.getPistas().getLongitud()];
        boolean salir = false;
        int avanceAcumulado = 0;
        int avanceEnemigo1 = 0,avanceEnemigo2 = 0,avanceEnemigo3 = 0,avanceEnemigo4 = 0,avanceEnemigo5 = 0,avanceEnemigo6 = 0;
        do {
            for (int i = 0; i < pista.length; i++) {

                pista[i] = pistaElegida.getCaracter().charAt(i);
            }

            int prob=0; 
            while(prob==0 || prob==3){
                prob=(int) (Math.random() * 3);

            }

            switch (prob) {
                case 1:
                    int avanceActual = vehiculoJugar.avanceVehiculo(vehiculoJugar.getMotor().getPotencia(),
                            vehiculoJugar.getLlanta().getCoeficiente());
                    avanceAcumulado += avanceActual;
                    System.out.println("Avance actual: " + avanceActual);
                    System.out.println("Avance acumulado: " + avanceAcumulado);
                    if (avanceAcumulado < pistaElegida.getPistas().getLongitud()) {
                        pista[avanceAcumulado] = vehiculoJugar.getEtiqueta();
                        vehiculoJugar.vaciarTanqueGasolina(avanceActual);
                        System.out.println("Gasolina tuyo: "+vehiculoJugar.getTanqueGasolina());

                        System.out.println(resetColor + "Tu turno");
                        for (int i = 0; i < pista.length; i++) {

                            System.out.print(pista[i] + pistaElegida.getPistas().getColor());

                        }

                    } else {
                        System.out.println("haz ganado!!!");
                        salir = true;
                    }
                    System.out.println("");
                    Continue();

                    break;

                case 2:
                    System.out.println("Turno Enemigo");
                    int probab = (int) (Math.random() * vehiculosEnemigos.length);
                    System.out.println(probab);
                    if(probab==0){

                            int avanceActualEnemigo = vehiculosEnemigos[0].avanceVehiculo(
                                    vehiculosEnemigos[0].getMotor().getPotencia(),
                                    vehiculosEnemigos[0].getLlanta().getCoeficiente());
                            avanceEnemigo1 += avanceActualEnemigo;
                            if (avanceEnemigo1 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo1] = vehiculosEnemigos[0].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                    }else if(probab==1){

                            int avanceActualEnemigo = vehiculosEnemigos[1].avanceVehiculo(
                                    vehiculosEnemigos[1].getMotor().getPotencia(),
                                    vehiculosEnemigos[1].getLlanta().getCoeficiente());
                            avanceEnemigo2 += avanceActualEnemigo;
                            if (avanceEnemigo2 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo2] = vehiculosEnemigos[1].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                        }else if(probab==2){

                            int avanceActualEnemigo = vehiculosEnemigos[2].avanceVehiculo(
                                    vehiculosEnemigos[2].getMotor().getPotencia(),
                                    vehiculosEnemigos[2].getLlanta().getCoeficiente());
                            avanceEnemigo3 += avanceActualEnemigo;
                            if (avanceEnemigo3 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo3] = vehiculosEnemigos[2].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                        }else if(probab==3){

                            int avanceActualEnemigo = vehiculosEnemigos[3].avanceVehiculo(
                                    vehiculosEnemigos[3].getMotor().getPotencia(),
                                    vehiculosEnemigos[3].getLlanta().getCoeficiente());
                            avanceEnemigo4 += avanceActualEnemigo;
                            if (avanceEnemigo4 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo4] = vehiculosEnemigos[3].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                        }else if(probab==4){

                            int avanceActualEnemigo = vehiculosEnemigos[4].avanceVehiculo(
                                    vehiculosEnemigos[4].getMotor().getPotencia(),
                                    vehiculosEnemigos[4].getLlanta().getCoeficiente());
                            avanceEnemigo5 += avanceActualEnemigo;
                            if (avanceEnemigo5 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo5] = vehiculosEnemigos[4].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                        }else if(probab==5){

                            int avanceActualEnemigo = vehiculosEnemigos[5].avanceVehiculo(
                                    vehiculosEnemigos[5].getMotor().getPotencia(),
                                    vehiculosEnemigos[5].getLlanta().getCoeficiente());
                            avanceEnemigo6 += avanceActualEnemigo;
                            if (avanceEnemigo6 < pistaElegida.getPistas().getLongitud()) {
                                pista[avanceEnemigo6] = vehiculosEnemigos[5].getEtiqueta();
                                for (int i = 0; i < pista.length; i++) {
        
                                    System.out.print(pista[i] + pistaElegida.getPistas().getColor());
        
                                }
        
                            } else {
                                System.out.println("ha ganado el enemigo!!!");
                                salir = true;
                            }
                            System.out.println("");
        
                            Continue();
                        }
                    
                    break;

            }
            
        } while (salir == false);
        
        System.out.println(vehiculoJugar.getTanqueGasolina());
    }

    static public void Continue() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println(resetColor + "Presione enter para continuar");
        try {
            seguir = teclado.nextLine();
        } catch (Exception e) {
        }
    }

}