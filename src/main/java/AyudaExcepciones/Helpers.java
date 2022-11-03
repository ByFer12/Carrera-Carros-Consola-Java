package AyudaExcepciones;

import excepciones.GasolinaVehiculoCaminoE;
import objetos.Pista;
import objetos.Vehiculo;

public class Helpers {
    
    public Helpers(){

    }

    public Vehiculo validarVehiculo(Vehiculo vehiculo, Pista pista) throws GasolinaVehiculoCaminoE {
        Vehiculo miVehiculo;
        
        if(vehiculo.getTanqueGasolina()<pista.getPistas().getLongitud()){
            throw new GasolinaVehiculoCaminoE("No hay gasolina suficiente para la pista elegida");
        }else{
            miVehiculo=vehiculo;
        }

        return miVehiculo;

    }
}
