package Modelos;

/**
 * Clase que extiende Exception para manejar cuando la moneda es inferior al precio del producto que se quiere compar
 */

public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
