package objetos;

public class Jugador {
    private String nombre;
    private String nickName;
    private int edad;
    private Vehiculo vehiculo;
    private int nVehiculos;
    private int gemas; 
    private int monedasOro;
    
    private int gemasGastado;
    private int monedasOroGastado;
    
    
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
    public void setMonedasOro(int monedasOro) {
        this.monedasOro = monedasOro;
    }
    public int getGemas() {
        return gemas;
    }

    public void setGemas(int gemas) {
        this.gemas = gemas;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNickName(String nickName){
        this.nickName=nickName;
    }

    public String getNickName(){
        return this.nickName;
    }

    public void setEdad(int edad){
        this.edad=edad;
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
    
}
