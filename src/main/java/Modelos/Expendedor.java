package Modelos;

/**
 * Clase encargada del funcionamiento del expendedor
 */
public class Expendedor {
    /**
     * Deposito para CocaCola
     */
    public Deposito<Bebida> coca;
    /**
     * Deposito para Sprite
     */
    public Deposito<Bebida> sprite;
    /**
     * Deposito para Fanta
     */
    public Deposito<Bebida> fanta;
    /**
     * Deposito para Snikers
     */
    public Deposito<Dulce> snickers;
    /**
     * Deposito para Super8
     */
    public Deposito<Dulce> super8;
    /**
     * Deposito para Monedas
     */
    private Deposito<Moneda> monVu;
    /**
     * Enum que contiene los precios
     */
    private Precios precio;
    /**
     * valor númerico estatico del número del producto
     */
    public static final int COCA = 1;
    /**
     * valor númerico estatico del número del producto
     */
    public static final int SPRITE = 2;
    /**
     * valor númerico estatico del número del producto
     */
    public static final int FANTA = 3;
    /**
     * valor númerico estatico del número del producto
     */
    public static final int SNICKERS = 4;
    /**
     * valor númerico estatico del número del producto
     */
    public static final int SUPER8 = 5;


    /**
     * Método constructor de expendedor
     * @param numProductos indica la cantidad de stock de cada producto
     */
    public Expendedor(int numProductos){
        // Creación de los depósitos
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snickers = new Deposito<Dulce>();
        super8 = new Deposito<Dulce>();
        monVu = new Deposito<Moneda>();

        for(int i = 0;i < numProductos;i++){
            coca.addProducto(new CocaCola(100 + i));
            sprite.addProducto(new Sprite(200 + i));
            fanta.addProducto(new Fanta(300 + i));
            snickers.addProducto(new Snickers(400+i));
            super8.addProducto(new Super8(500 + i));
        }
    }

    /**
     * Método para comprar Productos
     * @param moneda es una moneda ingresada por el usuario
     * @param cual indica el producto que escogerá
     * @return tipo producto, devuelve el producto que se quiere comprar
     * @throws PagoIncorrectoException, indica situación donde la moneda es null
     * @throws PagoInsuficienteException, indica situación donde moneda es inferior al precio del producto
     * @throws NoHayProductoException, indica situación donde el Deposito no tiene stock del producto
     */
    public Producto comprarProducto(Moneda moneda, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        // Caso moneda null

        if(moneda == null) {
            throw new PagoIncorrectoException("Moneda nula");
        }

        switch(cual){
            case COCA:
                precio = Precios.COCA;

                if(moneda.getValor() < precio.getPrecio()){ // PagoInsuficienteException
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new PagoInsuficienteException("Moneda inferior al precio");
                }
                else if(coca.checkSize()){
                    // NoHayProductoException
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new NoHayProductoException("No quedan CocaColas en el depósito");
                } else {
                    for(int i = 0;i < (moneda.getValor() - precio.getPrecio())/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    return coca.getProducto();
                }
            case SPRITE:
                precio = Precios.SPRITE;

                if(moneda.getValor() < precio.getPrecio()){
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new PagoInsuficienteException("Moneda inferior al precio");
                }
                else if(sprite.checkSize()){
                    // NoHayProductoException
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new NoHayProductoException("No quedan Sprites en el depósito");
                } else {
                    for(int i = 0;i < (moneda.getValor() - precio.getPrecio())/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    return sprite.getProducto();
                }

            case FANTA:
                precio = Precios.FANTA;

                if(moneda.getValor() < precio.getPrecio()){
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new PagoInsuficienteException("Moneda inferior al precio");
                }
                else if(fanta.checkSize()){
                    // NoHayProductoException
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new NoHayProductoException("No quedan Fantas en el depósito");
                } else {
                    for(int i = 0;i < (moneda.getValor() - precio.getPrecio())/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    return fanta.getProducto();
                }
            case SNICKERS:
                precio = Precios.SNICKERS;

                if(moneda.getValor() < precio.getPrecio()){
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new PagoInsuficienteException("Moneda inferior al precio");
                }
                else if(snickers.checkSize()){
                    // NoHayProductoException
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new NoHayProductoException("No quedan Snickers en el depósito");
                } else {
                    for(int i = 0;i < (moneda.getValor() - precio.getPrecio())/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    return snickers.getProducto();
                }
            case SUPER8:
                precio = Precios.SUPER8;

                if(moneda.getValor() < precio.getPrecio()){
                    for(int i = 0;i < moneda.getValor()/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    throw new PagoInsuficienteException("Moneda inferior al precio");
                }
                else if(super8.checkSize()) {
                    // NoHayProductoException
                    for (int i = 0; i < moneda.getValor() / 100; i++) {
                        monVu.addProducto(new Moneda100());
                    }
                    throw new NoHayProductoException("No quedan Super8 en el depósito");
                } else {
                    for(int i = 0;i < (moneda.getValor() - precio.getPrecio())/100;i++){
                        monVu.addProducto(new Moneda100());
                    }
                    return super8.getProducto();
                }
            default: // Comprar producto no existente
                for(int i = 0;i < moneda.getValor()/100;i++) {
                    monVu.addProducto(new Moneda100());
                }
                throw new NoHayProductoException("El producto solicitado no existe");
        }
    }

    /**
     * Método que devuelve monedas de 100 desde deposito de vuelto
     * @return Moneda
     */
    public Moneda getVuelto(){
        return monVu.getProducto();
    }
}

