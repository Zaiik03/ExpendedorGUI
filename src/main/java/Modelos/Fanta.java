package Modelos;

/**
 * Clase de Producto Fanta
 */
public class Fanta extends Bebida {
    /** Constructor de Bebida el cual recibe un valor numero que es su serie
     * @param serie numero identificador
     */
    public Fanta(int serie){
        super(serie);
    }
    /** Método que retorna el sonido de consumir dicha Bebida
     * @return String con el sonido correspondiente
     */
    public String getConsumir(){
        return "fanta";
    }
}