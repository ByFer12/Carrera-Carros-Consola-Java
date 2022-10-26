package objetos;

import enums.TipoPistas;

public class Pista {

    private TipoPistas pistas;
    private char caracter;
    private int gasolinaNecesaria;

    public Pista(TipoPistas pistas){
        this.pistas = pistas;
        this.caracter = '-';
    }

    public TipoPistas getPistas(){
        return this.pistas;
    }

    public String getCaracter(){
        String muestra="";
        char[] union;
        if(this.pistas==TipoPistas.ARENA){
             union=new char[TipoPistas.ARENA.getLongitud()];
             System.out.println("Pista de Arena");
            for (int i = 0; i < TipoPistas.ARENA.getLongitud(); i++) {
                union[i]+=caracter;   
            }
            muestra=String.valueOf(union);
        }else if(this.pistas==TipoPistas.TIERRA){
            System.out.println("Pista de Tierra");
            union=new char[TipoPistas.TIERRA.getLongitud()];
            for (int i = 0; i < TipoPistas.TIERRA.getLongitud(); i++) {
                union[i]+=caracter;   
            }
            muestra=String.valueOf(union);
        }else if(this.pistas==TipoPistas.CONCRETO){
            union=new char[TipoPistas.CONCRETO.getLongitud()];
            System.out.println("Pista de Concreto");
            for (int i = 0; i < TipoPistas.CONCRETO.getLongitud(); i++) {
                union[i]+=caracter;   
            }
            muestra=String.valueOf(union);
        }

        return muestra;
    }



}
