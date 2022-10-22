package objetos;

import enums.ColorVehiculo;
import enums.TipoLlanta;
import enums.TipoMotor;

public class Vehiculo {
    private String nombre;
    private  TipoMotor motor;
    private TipoLlanta llanta;
    private int tanqueGasolina;
    private ColorVehiculo color;
    private String etiqueta;
    private int gasolinaConsumida;
    
    public Vehiculo(){
        
    }
    
    public Vehiculo(String nombre, TipoMotor motor, TipoLlanta llanta, int tanqueGasolina) {
        this.nombre = nombre;
        this.motor = motor;
        this.llanta = llanta;
        this.tanqueGasolina = tanqueGasolina;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMotor getMotor() {
        return motor;
    }

    public void setMotor(TipoMotor motor) {
        this.motor = motor;
    }

    public TipoLlanta getLlanta() {
        return llanta;
    }

    public void setLlanta(TipoLlanta llanta) {
        this.llanta = llanta;
    }

    public int getTanqueGasolina() {
        return tanqueGasolina;
    }

    public void setTanqueGasolina(int tanqueGasolina) {
        this.tanqueGasolina = tanqueGasolina;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    public ColorVehiculo getColor(){
        return this.color;
    }

    public void setGasolinaCosnumida(int gasolina){
        this.gasolinaConsumida=gasolina;
    }
    
    
   public double avanceVehiculo(int motor ,int llanta){
       
       double avance=motor+(int)(Math.random()*10)+llanta;
       return avance;
   }
        
    
    
    
   
    
}
