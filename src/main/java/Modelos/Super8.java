package Modelos;

/**
 *Clase de Producto Super8
 */

public class Super8 extends Dulce {
    /**
     * Constructor Super8
     * @param serie numero identificador
     */
    public Super8(int serie){
        super(serie);
    }
    /**
     * Metodo que retorna un String
     * @return String con el sonido correspondiente
     */
    public String getConsumir(){
        return "super8";
    }
}
