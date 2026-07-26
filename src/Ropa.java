/**
 * Clase Ropa que hereda de Producto e implementa IVendible
 * Representa productos de vestimenta con atributos específicos.
 */
public class Ropa extends Producto implements IVendible {
    private String talla;
    private String material;
    private String color;

    /**
     * Constructor completo
     */
    public Ropa(String nombre, double precio, int stock, String codigo,
                String talla, String material, String color) {
        super(nombre, precio, stock, codigo);
        this.talla = talla;
        this.material = material;
        this.color = color;
    }

    // Getters y Setters
    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    /**
     * Implementación del método abstracto mostrarDetalles()
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("👕 ROPA:");
        System.out.println("   Código: " + codigo);
        System.out.println("   Nombre: " + nombre);
        System.out.println("   Precio: $" + precio);
        System.out.println("   Stock: " + stock);
        System.out.println("   Talla: " + talla);
        System.out.println("   Material: " + material);
        System.out.println("   Color: " + color);
    }

    /**
     * Implementación del método abstracto calcularPrecioConDescuento()
     */
    @Override
    public double calcularPrecioConDescuento() {
        // Ropa tiene 15% de descuento
        return precio * 0.85;
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
        return super.toString() + " | Talla: " + talla + " | Material: " + material + " | Color: " + color;
    }
}