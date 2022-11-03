package AyudaExcepciones;

import excepciones.GasolinaVehiculoCaminoE;
import excepciones.MaximoRival;
import excepciones.MinimoRival;
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


    public int minRivales(int numero) throws MinimoRival,MaximoRival{
        int num;
        if (numero>0&&numero<2){
            throw new MinimoRival("No puedes elegir menos de 2 rivales");
        }else if(numero>6 ||numero==0){
            throw new MaximoRival("No puede elegir mas de 6 rivales");
        }else{
            num=numero;

        }
    return num;

    }
}
