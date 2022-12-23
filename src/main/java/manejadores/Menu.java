package manejadores;

import java.util.Scanner;

import enums.TipoLlanta;
import enums.TipoMotor;
import enums.TipoPistas;
import objetos.Jugador;
import objetos.Pista;
import objetos.Vehiculo;

public class Menu {
    static Jugador jugador;
    static ManejadorPista man;
    private ManejadorRival rival;
 

    static Scanner ent = new Scanner(System.in);

    public Menu() {
        man = new ManejadorPista();
        rival = new ManejadorRival();

        terminosCondiciones();
    }

    public static void terminosCondiciones() {
        int eleccion;
        System.out.println("1---Si \n2----No");
        System.out.println("Para continuar debe elegir si para aceptar nuestros terminos y condiciones ");
        eleccion = ent.nextInt();
        if (eleccion == 1) {
            pedirDatos();
        }
    }

    public static void pedirDatos() {
        System.out.println(
                "\n\nGracias por haber aceptado nuestros terminos y condiciones, ahora debera ingresar sus datos\n");
        String nombre, nickName;
        int edad;
        System.out.print("Ingrese su Nombre: ");
        nombre = ent.next();
        System.out.print("Ingrese su Nickname: ");
        nickName = ent.next();
        System.out.print("Ingrese su Edad: ");
        edad = ent.nextInt();
        jugador = new Jugador(nombre, nickName, edad);
        elegirVehiculo();
    }

    public static void elegirVehiculo() {
        int condition = 1;
        Vehiculo v1 = new Vehiculo("Truck", TipoMotor.MOTOR_BASICO, TipoLlanta.CALIDAD_MEDIA, 80, 'A');
        Vehiculo v2 = new Vehiculo("Bolido", TipoMotor.MOTOR_ALTO_RENDIMIENTO, TipoLlanta.CALIDAD_MEDIA, 90, 'B');
        Vehiculo v3 = new Vehiculo("Macuin", TipoMotor.MOTOR_MEDIO, TipoLlanta.CALIDAD_MEDIA, 100, 'C');
        //
        // jugador.agregarVehiculo(v1);
        do {
            System.out.println("\tVEHICULOS:");
            System.out.println("1 ------ Vehiculo: " + v1.getEtiqueta() + "\n \tPotencia: " + v1.getMotor()
                    + " Gasolina: " + v1.getTanqueGasolina() + " Nombre: " + v1.getNombre());
            System.out.println("2 ------ Vehiculo: " + v2.getEtiqueta() + "\n \tPotencia: " + v2.getMotor()
                    + " Gasolina: " + v2.getTanqueGasolina() + " Nombre: " + v2.getNombre());
            System.out.println("3 ------ Vehiculo: " + v3.getEtiqueta() + "\n \tPotencia: " + v3.getMotor()
                    + " Gasolina: " + v3.getTanqueGasolina() + " Nombre: " + v3.getNombre());
            System.out.println("Elija uno de los 3 vehiculos disponibles.");
            condition = ent.nextInt();
            switch (condition) {
                case 1:
                    jugador.agregarVehiculo(v1);
                    condition = 0;
                    break;

                case 2:
                    jugador.agregarVehiculo(v2);
                    condition = 0;
                    break;

                case 3:
                    jugador.agregarVehiculo(v3);
                    condition = 0;
                    break;
                default:
                    System.out.println("El numero que usted eligio no es valido...");
            }

        } while (condition != 0);
        menuJuego();
    }

    public static void mostrarDatos() {
        String nickName = jugador.getNickName();
        int monedas = jugador.getMonedasOro();
        int gemas = jugador.getGemas();
        System.out.println(ManejadorCompetir.resetColor+"***********************************************************");
        System.out.print("\tNickname: \u001B[35m" + nickName);
        System.out.print(" \u001B[37m Monedas de oro: \u001B[33m" + monedas);
        System.out.println(" \u001B[37m Gemas: \u001B[36m" + gemas);
        System.out.println("\033[1;37m***********************************************************");
    }

    public static void menuJuego() {
        System.out.println("");
        System.out.println("Antes de competir se le recomienda llenar su tanque de gasolina si tiene menos de 100 galones");
        int opcion, salir = 0;
        do {
            mostrarDatos();

            do {
                System.out.println("\u001B[37m1)-------Competir");
                System.out.println("2)-------Juego de la Ruleta");
                System.out.println("3)-------Ir al Garaje");
                System.out.println("4)-------Ver Pistas disponibles");
                System.out.println("5)-------Ver estadisticas");
                System.out.println("6)-------Salir");
                opcion = ent.nextInt();
            } while (opcion < 1 || opcion > 6);

            switch (opcion) {
                case 1:
                    ManejadorCompetir m = new ManejadorCompetir();
                    
                    break;

                case 2:
                    ManejadorRuleta.menuRuleta();
                    break;

                case 3:
                    manejadorGaraje garaje=new manejadorGaraje();
                    break;

                case 4:
                    man.menuPistas();
                    break;

                case 5:
                    System.out.println("Aqui va la opcion para ver estadisticas");
                    break;

                case 6:
                    salir = 1;
                    break;
                default:
                    break;
            }
            System.out.println("\n");
        } while (salir != 1);
        System.out.println("\nGracias por preferirnos :)\n");
    }

}
