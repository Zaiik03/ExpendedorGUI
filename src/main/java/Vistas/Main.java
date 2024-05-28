package Vistas;
import Modelos.*;

public class Main {
    public static void main(String[] args) {
        /* Expendedor exp = new Expendedor(10);
        for(int i = 0;i < 20;i++){
            Moneda m = new Moneda100();
            try{
                Comprador c =  new Comprador(m, Expendedor.SNICKERS, exp);
                System.out.println(c.queConsumiste()+", " + c.cuantoVuelto());
            } catch (PagoIncorrectoException a){
                System.out.println("Error de tipo pago: " + a.getMessage());
            } catch (PagoInsuficienteException a){
                System.out.println("Error de pago: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
            } catch (NoHayProductoException a){
                System.out.println("Error de inventario: " + a.getMessage() + ". Aqui tiene su dinero: " + m.getValor());
            }
        } */

        Ventana v = new Ventana();



    }
}
