package manejadores;

import java.util.Scanner;

import enums.TipoPistas;
import objetos.Jugador;
import objetos.Pista;

public class Menu {
     static Jugador jugador;

    static Scanner ent = new Scanner(System.in);
    public Menu(){
        terminosCondiciones();
    }

    public static void terminosCondiciones(){
        int eleccion;
        System.out.println("1---Si \n2----No");
        System.out.println("Para continuar debe elegir si para aceptar nuestros terminos y condiciones ");
        eleccion=ent.nextInt();
        if(eleccion==1){
            pedirDatos();
        }
    }

    public static void pedirDatos(){
        System.out.println("\n\nGracias por haber aceptado nuestros terminos y condiciones, ahora debera ingresar sus datos\n");
        String nombre, nickName;
        int edad;
        System.out.print("Ingrese su Nombre: ");
        nombre=ent.next();
        System.out.print("Ingrese su Nickname: ");
        nickName=ent.next();
        System.out.print("Ingrese su Edad: ");
        edad=ent.nextInt();
        jugador=new Jugador(nombre, nickName, edad);

        menuJuego();
    }
    public static void mostrarDatos(){
        String nickName =jugador.getNickName();
        int monedas=jugador.getMonedasOro();
        int gemas=jugador.getGemas();
        System.out.print("Nickname: \u001B[35m"+nickName);
        System.out.print(" \u001B[37m Monedas de oro: \u001B[33m"+monedas);
        System.out.println(" \u001B[37m Gemas: \u001B[36m"+gemas);
    }

    public static void menuJuego(){
        System.out.println("");
        mostrarDatos();
        int opcion,salir=0;
        do {
            
            do{
                System.out.println("\u001B[37m1)-------Competir");
                System.out.println("2)-------Juego de la Ruleta");
                System.out.println("3)-------Ir al Garaje");
                System.out.println("4)-------Ver Pistas disponibles");
                System.out.println("5)-------Ver estadisticas");
                System.out.println("6)-------Salir");
                opcion=ent.nextInt();
            }while(opcion<1 ||opcion>6);

            switch (opcion) {
                case 1:
                    System.out.println("Aqui va todo lo de competencia");
                    break;
                
                case 2:
                ManejadorRuleta.menuRuleta();
                    break;

                case 3:
                    System.out.println("Aqui va todo lo del garaje");
                    break;

                case 4:
                    System.out.println("Aqui va la opcion para ver las pistas");
                    Pista i=new Pista(TipoPistas.ARENA);
                    System.out.println(TipoPistas.ARENA.getColor()+ i.getCaracter()); 
                    break;

                case 5:
                    System.out.println("Aqui va la opcion para ver estadisticas");
                    break;

                case 6:
                    salir=1;
                break;
                default:
                    break;
            }
            System.out.println("\nGracias por preferirnos :)");
        } while (salir!=1);
    }
        
}
