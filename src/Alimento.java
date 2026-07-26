/**
 * Clase Alimento que hereda de Producto e implementa IVendible
 * Representa productos alimenticios con atributos específicos.
 */
public class Alimento extends Producto implements IVendible {
    private String fechaVencimiento;
    private boolean esOrganico;

    /**
     * Constructor completo
     */
    public Alimento(String nombre, double precio, int stock, String codigo,
                    String fechaVencimiento, boolean esOrganico) {
        super(nombre, precio, stock, codigo);
        this.fechaVencimiento = fechaVencimiento;
        this.esOrganico = esOrganico;
    }

    // Getters y Setters
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isEsOrganico() { return esOrganico; }
    public void setEsOrganico(boolean esOrganico) { this.esOrganico = esOrganico; }

    /**
     * Implementación del método abstracto mostrarDetalles()
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("🍎 ALIMENTO:");
        System.out.println("   Código: " + codigo);
        System.out.println("   Nombre: " + nombre);
        System.out.println("   Precio: $" + precio);
        System.out.println("   Stock: " + stock);
        System.out.println("   Fecha Vencimiento: " + fechaVencimiento);
        System.out.println("   Orgánico: " + (esOrganico ? "✅ Sí" : "❌ No"));
    }

    /**
     * Implementación del método abstracto calcularPrecioConDescuento()
     */
    @Override
    public double calcularPrecioConDescuento() {
        // Alimentos tienen 5% de descuento
        return precio * 0.95;
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
        return super.toString() + " | Vence: " + fechaVencimiento + " | Orgánico: " + (esOrganico ? "Sí" : "No");
    }
}