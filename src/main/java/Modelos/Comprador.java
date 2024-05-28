package Modelos;

/**
 * Clase encargada de comprar
 */
public class Comprador {
    /**
     * String encargado de almacenar el valor que retorna el getConsumir
     */
    private String sonido;
    /**
     * valor numerico que almacenara el vuelo despues de la compra
     */
    private int vuelto;
    /**
     * Metodo constructor del Comprador
     * @param monedaCompra es la moneda que el usuario ingresa
     * @param cualProducto selecciona el producto qe quieres comprar
     * @param exp es el Expendedor del cual sacaremos los productos
     * @throws PagoIncorrectoException es la exception en el caso de que pague con una moneda nula
     * @throws PagoInsuficienteException es la exception en el caso de que el precio no sea el suficiente
     * @throws NoHayProductoException caso donde no hay stock
     */
    public Comprador(Moneda monedaCompra, int cualProducto, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto producto = exp.comprarProducto(monedaCompra, cualProducto);
        while(true){
            Moneda moneda = exp.getVuelto();
            if(moneda == null){
                break;
            } else{
                vuelto += moneda.getValor();
            }
        }

        if(producto == null){
            sonido = null;
        } else{
            sonido = producto.getConsumir();
        }

    }

    /**
     * Metodo que devuelve el vuelto luego de validar la compra
     * @return el vuelto de la persona
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Metodo que se encarga de representar el sonido del producto
     * @return un String con el sonido respectivo
     */
    public String queConsumiste(){
        return sonido;
    }
}