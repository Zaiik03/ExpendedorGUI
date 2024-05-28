package Modelos;

/**
 * Clase de Producto Sprite
 */
public class Sprite extends Bebida {
    /** Constructor de Bebida el cual recibe un valor numero que es su serie
     * @param serie numero identificador
     */
    public Sprite(int serie){
        super(serie);
    }
    /** Método que retorna el sonido de consumir dicha Bebida
     * @return String con el sonido correspondiente
     */
    public String getConsumir(){
        return "sprite";
    }

}