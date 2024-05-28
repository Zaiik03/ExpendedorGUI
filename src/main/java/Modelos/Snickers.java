package Modelos;

/**
 * Clase de Producto Snickers
 */
public class Snickers extends Dulce {
    /**
     * Constructor Snickers
     * @param serie numero identificador
     */
    public Snickers(int serie){
        super(serie);
    }

    /**
     * Metodo que retorna un String
     * @return nombre del producto a consumir
     */
    public String getConsumir(){
        return "snicker";
    }

}