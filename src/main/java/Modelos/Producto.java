package Modelos;

/**
 * Clase abstracta que define las características generales de cada producto
 */
public abstract class Producto {
    /**
     * Propiedad protegida que almacena el número de serie del producto
     */
    protected int serie;

    /**
     * Metodo  constructor que asigna el valor de serie al produto
     * @param serie número de identificación para cada producto
     */
    public Producto(int serie){
        this.serie = serie;
    }

    /**
     * Metodo que retorna la serie de un producto
     * @return serie que es un valor numerico del producto
     */
    public int getSerie(){
        return this.serie;
    }

    /**
     * Metodo que retorna un String
     * @return nombre del producto que se consumio
     */
    abstract public String getConsumir();
}
