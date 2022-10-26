package objetos;

public class Jugador {
    private String nombre;
    private  String nickName;
    private int edad;
    private Vehiculo vehiculo;
    private int nVehiculos;
    private int gemas; 
    private int monedasOro;
    
    private  int gemasGastado=0;
    private int gemasObtenidos=0;
    private int monedasOroGastado=0;
    private int monedasOroObtenidos=0;
    
    
    public Jugador(String nombre, String nickName, int edad){
        this.nombre=nombre;
        this.nickName=nickName;
        this.edad=edad;
        this.gemas=30;
        this.monedasOro=50;
        
        
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

    public void setVehiculo(Vehiculo vehiculo){
        this.nVehiculos++;
        this.vehiculo=vehiculo;
    }

    public Vehiculo getVehiculo(){
        return this.vehiculo;
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
