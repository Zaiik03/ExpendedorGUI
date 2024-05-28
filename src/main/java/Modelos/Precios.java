package Modelos;

/**
 * Enum encargada de los precios de los productos
 */
public enum Precios {
    COCA(600, "CocaCola"), SPRITE(700, "Sprite"), FANTA(800, "Fanta"), SNICKERS(1000, "Snickers"),SUPER8(500, "Super8");
    /**
     * in que almacenara el valor de los productos
     */
    private final int valor_producto;
    private final String nombre;

    /**
     * Metodo constructor de Precios
     * @param valor, indica que valor numerico tiene un producto
     */
    Precios(int valor, String name){
        this.valor_producto = valor;
        this.nombre = name;
    }

    /**
     * Metodo encargado de retornar precios
     * @return valor numerico de aquel producto
     */
    public int getPrecio(){
        return valor_producto;
    }

    public String getNombreProducto(){
        return nombre;
    }
}
