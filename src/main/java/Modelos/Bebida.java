package Modelos;

/**
 * Clase abstracta Bebida
 */
abstract class Bebida extends Producto {
    /** Constructor el cual recibe una serie unica
     * @param serie numerico serie como identificador unico
     */
    public Bebida(int serie){
        super(serie);
    }
    /** Método abstracto que se vuelve concreto según la bebida
     */
    public abstract String getConsumir();
}
