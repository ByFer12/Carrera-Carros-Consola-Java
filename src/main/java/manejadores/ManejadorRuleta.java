package manejadores;

import java.util.Scanner;

public class ManejadorRuleta {

    static Scanner ent = new Scanner(System.in);
    private static final int GASTO_GEMAS = 5;

    public static void menuRuleta() {
        int opcion;
        System.out.println("El juego vale 5 gemas, \n¿estas de acuerdo?");
        System.out.println("1------Si\n2------No");
        opcion = ent.nextInt();
        switch (opcion) {
            case 1:
                ruleta();
                break;
            case 2:
                Menu.menuJuego();
        }

    }

    public static void ruleta() {
        Menu.jugador.restarGemas(GASTO_GEMAS);
        System.out.println("\nGastaste 5 Gemas");
        Menu.mostrarDatos();
        int condicion = 0;
        int rondas = 0;
        System.out.println("\u001B[37mha comenzado el juego");
        do {
            System.out.println("\nRonda: " + (rondas + 1));
            int aleatorio = (int) (Math.random() * 101);
            if (aleatorio > 0 && aleatorio <= 5) {
                Menu.jugador.sumarGemas(1000);
                Menu.jugador.sumarMonedasOro(2000);
                System.out.println("\u001B[37mFelicidades!! Haz ganado 1000 Gemas y 2000 Monedas de Oro!!\n");
            } else if (aleatorio > 5 && aleatorio <= 20) {
                Menu.jugador.sumarMonedasOro(70);
                System.out.println("\u001B[37mFelicidades!! Haz ganado 70 monedas de oro\n ");

            } else if (aleatorio > 20 && aleatorio <= 35) {
                Menu.jugador.sumarGemas(40);
                System.out.println("\u001B[37mFelicidades!! Haz ganado 40 Gemas!\n");

            } else if (aleatorio > 35 && aleatorio <= 65) {
                Menu.jugador.sumarGemas(5);
                System.out.println("\u001B[37mFelicidades! Haz ganado 5 Gemas!");

            } else if (aleatorio > 65 && aleatorio <= 100) {
                Menu.jugador.sumarMonedasOro(10);
                System.out.println("\u001B[37mFelicidades! Haz ganado 10 Monedas de Oro");

            }
            Menu.mostrarDatos();
            int seguir;
            System.out.println("\n\u001B[37mQuieres segiur jugando?");
            System.out.println("1-------Si\n2-------No");
            seguir = ent.nextInt();
            if (seguir == 1) {
                Menu.jugador.restarGemas(GASTO_GEMAS);
            } else {
                condicion = 1;
            }
            if (Menu.jugador.getGemas() <= 0) {
                System.out.println("Se ha terminado Sus gemas");
                condicion = 1;

            }

            rondas++;
        } while (condicion != 1);
    }

}
