/**
 * Clase Electronico que hereda de Producto e implementa IVendible
 * Representa productos electrónicos con atributos específicos.
 */
public class Electronico extends Producto implements IVendible {
    private String marca;
    private int garantiaMeses;

    /**
     * Constructor completo
     */
    public Electronico(String nombre, double precio, int stock, String codigo,
                       String marca, int garantiaMeses) {
        super(nombre, precio, stock, codigo);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    // Getters y Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getGarantiaMeses() { return garantiaMeses; }
    public void setGarantiaMeses(int garantiaMeses) { this.garantiaMeses = garantiaMeses; }

    /**
     * Implementación del método abstracto mostrarDetalles()
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("📱 ELECTRÓNICO:");
        System.out.println("   Código: " + codigo);
        System.out.println("   Nombre: " + nombre);
        System.out.println("   Marca: " + marca);
        System.out.println("   Precio: $" + precio);
        System.out.println("   Stock: " + stock);
        System.out.println("   Garantía: " + garantiaMeses + " meses");
    }

    /**
     * Implementación del método abstracto calcularPrecioConDescuento()
     */
    @Override
    public double calcularPrecioConDescuento() {
        // Electrónicos tienen 10% de descuento
        return precio * 0.90;
    }

    /**
     * Implementación del método vender() de la interfaz IVendible
     */
    @Override
    public void vender(int cantidad) {
        reducirStock(cantidad);
        System.out.println("🛒 Vendido: " + cantidad + " unidad(es) de " + nombre);
    }

    /**
     * Implementación del método calcularPrecioTotal() de la interfaz IVendible
     */
    @Override
    public double calcularPrecioTotal(int cantidad) {
        return precio * cantidad;
    }

    /**
     * Implementación del método aplicarDescuentoEspecial() de la interfaz IVendible
     */
    @Override
    public void aplicarDescuentoEspecial(double porcentaje) {
        double descuento = precio * (porcentaje / 100);
        precio -= descuento;
        System.out.println("💸 Descuento especial aplicado. Nuevo precio: $" + precio);
    }

    @Override
    public String toString() {
        return super.toString() + " | Marca: " + marca + " | Garantía: " + garantiaMeses + " meses";
    }
}