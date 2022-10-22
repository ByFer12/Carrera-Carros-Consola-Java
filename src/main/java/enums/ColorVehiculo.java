package enums;

public enum ColorVehiculo {
    AZUL("\u001B[34m"),
    ROJO("\u001B[31m"),
    VERDE("\u001B[32m");
    
    private String color;
    ColorVehiculo(String color){
        this.color=color;
}
    
    public String getColor(){
        return this.color;
    }
}
