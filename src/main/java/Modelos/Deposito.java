package Modelos;

import java.util.ArrayList;

/**
 * Clase encargada de almacenar los productos
 * @param <T> que especifica que tipo de deposito es (Dulce, Bebida o Moneda)
 */
public class Deposito<T> {
    /**
     * Array que almacenara los productos
     */
    private ArrayList<T> arr; // Creamos un array que almacenara los Productos / Monedas

    /**
     * Metodo Constructor de Deposito
     */
    public Deposito(){
        arr = new ArrayList<>(); // Inicializamos el Array
    }

    /**
     * Metodo que retorna el Producto pedido
     * @return un elemento almacenado en el array
     */
    public T getProducto(){ // Se devuelve un producto de tipo genérico
        if(arr.size() > 0){ // Determinamos si el largo del array es mayor a 0, lo que da a entender que tiene objetos
            return arr.remove(0); // Removemos un elemento del Array
        }
        return null; // En caso de que no haya elementos
    }
    /** Metodo encargado de agregar los productos al deposito
     */
    public void addProducto(T elemento){
        arr.add(elemento); // Agregamos el producto
    }

    /**
     * Metodo validador que verifica si esta vacio el arreglo
     * @return un boolean que lo representa
     */
    public boolean checkSize(){
        if(arr.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Metodo get que retorna la cantidad de productos
     */
    public int getSize(){
        return arr.size();
    }
}
