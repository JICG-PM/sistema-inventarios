/**
 * Interfaz IVendible
 * Define métodos que deben implementar los productos que pueden ser vendidos.
 * Una interfaz solo declara métodos, no los implementa.
 * Las clases que la implementan deben definir el comportamiento concreto.
 */
public interface IVendible {
    /**
     * Método para vender una cantidad del producto
     */
    void vender(int cantidad);

    /**
     * Método para calcular el precio total de una venta
     */
    double calcularPrecioTotal(int cantidad);

    /**
     * Método para aplicar un descuento especial (si aplica)
     */
    void aplicarDescuentoEspecial(double porcentaje);
}
