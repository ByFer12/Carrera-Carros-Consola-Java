package enums;

public enum TipoLlanta {
    CALIDAD_BAJA(2), 
    CALIDAD_MEDIA(3),
    CALIDAD_ALTAS(5);

    private int coeficiente;

    private TipoLlanta(int coeficiente){
        this.coeficiente=coeficiente;
    }
    public int getCoeficiente(){
        return this.coeficiente;
    }

}
