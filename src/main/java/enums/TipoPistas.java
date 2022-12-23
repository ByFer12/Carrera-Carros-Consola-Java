package enums;

public enum TipoPistas {
    ARENA(2, 90, "\u001B[33m"),
    TIERRA(4, 80, "\033[1;32m"),
    CONCRETO(6, 100, "\033[1;37m");

    private int coeficiente;
    private int longitud;
    private String color;

    private TipoPistas(int coeficiente, int longitud, String color) {
        this.coeficiente = coeficiente;
        this.longitud = longitud;
        this.color = color;
    }

    public int getCoeficiente() {
        return this.coeficiente;
    }

    public int getLongitud() {
        return this.longitud;
    }

    public String getColor() {
        return this.color;
    }
}
