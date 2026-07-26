/**
 * Clase abstracta Producto
 * Define los atributos y métodos comunes para todos los productos.
 * Una clase abstracta no puede instanciarse directamente, solo sirve como plantilla.
 */
public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;
    protected String codigo;

    /**
     * Constructor de Producto
     */
    public Producto(String nombre, double precio, int stock, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /**
     * Método concreto (implementado aquí)
     */
    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("✅ Stock actualizado: " + stock);
        } else {
            System.out.println("❌ Stock insuficiente. Disponible: " + stock);
        }
    }

    /**
     * Método abstracto → Las subclases deben implementarlo obligatoriamente
     */
    public abstract void mostrarDetalles();

    /**
     * Método abstracto → Las subclases deben implementarlo obligatoriamente
     */
    public abstract double calcularPrecioConDescuento();

    @Override
    public String toString() {
        return "Código: " + codigo + " | " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
}
