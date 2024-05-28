package Modelos;

/**
 * Clase que extiende Exception para manejar errores de compra, como por ejemplo moneda null
 */
public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
