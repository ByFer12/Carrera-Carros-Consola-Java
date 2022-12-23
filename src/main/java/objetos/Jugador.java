package objetos;

public class Jugador {
    private String nombre;
    private  String nickName;
    private int edad;
    private static Vehiculo[] vehiculos;

    private final int MAX_VEHICULOS=6;
    private int gemas; 
    private int monedasOro;
    
    private  int gemasGastado=0;
    private int gemasObtenidos=0;
    private int monedasOroGastado=0;
    private int monedasOroObtenidos=0;
    private int contador;    
    
    public Jugador(String nombre, String nickName, int edad){
        this.nombre=nombre;
        this.nickName=nickName;
        this.edad=edad;
        this.gemas=30;
        this.monedasOro=50;
        Jugador.vehiculos=new Vehiculo[MAX_VEHICULOS];
        
        
    }

    public Vehiculo unVehiculo(int posicion){
        Vehiculo vehicu;
        vehicu=vehiculos[posicion];
        return vehicu;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        
        if(this.contador<MAX_VEHICULOS){

            Jugador.vehiculos[contador++]=vehiculo;
        }else{
            System.out.println("Ya no puedes obtener mas vehiculos");
        }

    }
    public int getContador(){
        return this.contador;
    }

    public void mostrarVehiculos(){
        System.out.println("\t***************************");
        System.out.println("\t  VEHICULOS DISCPONIBLES");
        System.out.println("\t***************************");

        for (int i = 0; i < this.contador; i++) {
            if(vehiculos[i].getEtiqueta()!=' ' && vehiculos[i].getMotor()!=null && vehiculos[i].getTanqueGasolina()!=0){
                System.out.println((i+1)+") -------- Vehiculo : "+vehiculos[i].getEtiqueta()+"\n");
                System.out.println("Nombre: "+vehiculos[i].getNombre());
                System.out.println("Potencia: "+vehiculos[i].getMotor());
                System.out.println("Gasolina: "+vehiculos[i].getTanqueGasolina()+"\n");
                System.out.println("Vehiculo: "+vehiculos[i].getEtiqueta()+"\n");
                
                System.out.println("\033[1;37m");
            }
        }
    }

    public int getMonedasOro() {
        return monedasOro;
    }
   
    public  int getGemas() {
        return gemas;
    }
    
    public String getNombre(){
        return this.nombre;
    }


    public String getNickName(){
        return nickName;
    }

    public int getEdad(){
        return this.edad;
    }

    public int getGemasGastado(){
        return this.gemasGastado;
    }
    public int getGemasObtenidos(){
        return this.gemasObtenidos;
    }

    public int getMonedasOroGastado(){
        return this.monedasOroGastado;
    }
    public int getMonedasOroObtenidos(){
        return this.monedasOroObtenidos;
    }

    public  void restarGemas(int restarGemas){
        gemas-=restarGemas;
        gemasGastado+=restarGemas;
    }

    public void sumarGemas(int sumarGemas){
        this.gemas+=sumarGemas;
        this.gemasObtenidos+=sumarGemas;
    }

    public void restarMonedasOro(int restarMonedasOro){
        this.monedasOro-=restarMonedasOro;
        this.monedasOroGastado+=restarMonedasOro;
    }

    public void sumarMonedasOro(int sumarMonedasOro){
        this.monedasOro+=sumarMonedasOro;
        this.monedasOroObtenidos+=sumarMonedasOro;
    }
    
}
