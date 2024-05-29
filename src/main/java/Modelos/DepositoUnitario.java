package Modelos;

import java.util.ArrayList;

/**
 * Clase encargada de almacenar los productos
 * @param <T> que especifica que tipo de deposito es (Dulce, Bebida o Moneda)
 */
public class DepositoUnitario<T> {
    /**
     * Array que almacenara los productos
     */
    private T producto; // Creamos un array que almacenara los Productos / Monedas

    /**
     * Metodo Constructor de Deposito
     */
    public DepositoUnitario(){
        producto = null;
    }

    /**
     * Metodo que retorna el Producto pedido
     * @return un elemento almacenado en el array
     */
    public T getProducto(){ // Se devuelve un producto de tipo genérico
        if(producto != null){ // Determinamos si el largo del array es mayor a 0, lo que da a entender que tiene objetos
            T temp = producto;
            producto = null;
            return temp; // Removemos un elemento del Array
        }
        return null; // En caso de que no haya elementos
    }
    /** Metodo encargado de agregar los productos al deposito
     */
    public void addProducto(T elemento){
        if(producto == null){
            producto = elemento;
        }
    }

    public boolean checkSize(){
        if(producto == null){
            return true;
        } else{
            return false;
        }
    }


}