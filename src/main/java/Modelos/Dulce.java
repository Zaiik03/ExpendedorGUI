package Modelos;

/**
 * Clase abstracta Dulce
 */
abstract public class Dulce extends Producto {
    /** Constructor de la Clase Dulce
     * @param serie que es el identificador
     */
    public Dulce(int serie){
        super(serie);
    }

    /** Clase Abstracta que representa consumir un producto
     * @return String que retorna un String
     */
    abstract public String getConsumir();
}