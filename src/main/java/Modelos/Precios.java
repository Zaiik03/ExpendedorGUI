package Modelos;

/**
 * Enum encargada de los precios de los productos
 */
public enum Precios {
    COCA(600), SPRITE(700), FANTA(800), SNICKERS(1000),SUPER8(500);
    /**
     * in que almacenara el valor de los productos
     */
    private final int valor_producto;

    /**
     * Metodo constructor de Precios
     * @param valor, indica que valor numerico tiene un producto
     */
    Precios(int valor){
        this.valor_producto = valor;
    }

    /**
     * Metodo encargado de retornar precios
     * @return valor numerico de aquel producto
     */
    public int getPrecio(){
        return valor_producto;
    }
}
