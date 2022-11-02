package manejadores;

import enums.TipoLlanta;
import enums.TipoMotor;
import objetos.Vehiculo;

public class ManejadorRival {
   static Vehiculo [] vehiculoRival=new Vehiculo[6];
    

    public ManejadorRival(){
        vehiculoRival[0]=new Vehiculo("Destructor", TipoMotor.MOTOR_ALTO_RENDIMIENTO, TipoLlanta.CALIDAD_ALTAS, 100, ">");
        vehiculoRival[1]=new Vehiculo("Megatron", TipoMotor.MOTOR_ALTO_RENDIMIENTO, TipoLlanta.CALIDAD_BAJA, 100, "x");
        vehiculoRival[2]=new Vehiculo("Scorpion", TipoMotor.MOTOR_MEDIO, TipoLlanta.CALIDAD_MEDIA, 100, "=");
        vehiculoRival[3]=new Vehiculo("Bumblebee", TipoMotor.MOTOR_MEDIO, TipoLlanta.CALIDAD_BAJA, 100, "Z");
        vehiculoRival[4]=new Vehiculo("Optimus", TipoMotor.MOTOR_BASICO, TipoLlanta.CALIDAD_ALTAS, 100, "O");
        vehiculoRival[5]=new Vehiculo("Kaon", TipoMotor.MOTOR_BASICO, TipoLlanta.CALIDAD_BAJA, 100, "+");
        
        
    }

    public static Vehiculo elegirRival(int posicion){
        Vehiculo rival;
        rival=vehiculoRival[posicion];
        return rival;
        
    }
}
