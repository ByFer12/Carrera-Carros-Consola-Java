package enums;

public enum TipoMotor {
    MOTOR_BASICO(4),
    MOTOR_MEDIO(5),
    MOTOR_ALTO_RENDIMIENTO(7);

    private int potencia;
    private TipoMotor(int potencia){
        this.potencia=potencia;
    }

    public int getPotencia() {
        return this.potencia;
    }
}
