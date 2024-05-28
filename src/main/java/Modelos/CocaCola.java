package Modelos;

/**
 * Clase de Producto CocaCola
 */
public class CocaCola extends Bebida {
    /** Constructor de Bebida el cual recibe un valor numero que es su serie
     * @param serie numerico identificador
     */
    public CocaCola(int serie){
        super(serie);
    }
    /** Metodo que returna el sonido de consumir dicha Bebida
     * @return String del nombre del producto
     */
    public String getConsumir(){
        return "cocacola";
    }

}