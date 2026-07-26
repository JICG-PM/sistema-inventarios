import java.util.ArrayList;
import java.util.List;

/**
 * Clase Inventario
 * Gestiona una lista de productos usando POLIMORFISMO.
 * Puede almacenar cualquier tipo de Producto (Electronico, Alimento, Ropa).
 */
public class Inventario {
    private List<Producto> productos;  // Lista polimórfica

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto (cualquier subclase de Producto)
     * POLIMORFISMO: acepta cualquier objeto que sea Producto
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }

    /**
     * Busca un producto por código
     */
    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Muestra todos los productos (POLIMORFISMO en acción)
     * Llama a toString() de cada subclase
     */
    public void mostrarTodos() {
        if (productos.isEmpty()) {
            System.out.println("📭 Inventario vacío");
            return;
        }
        System.out.println("\n📋 INVENTARIO COMPLETO:");
        System.out.println("=".repeat(50));
        for (Producto p : productos) {
            System.out.println(p.toString());  // Polimorfismo
        }
        System.out.println("Total: " + productos.size() + " productos\n");
    }

    /**
     * Muestra detalles específicos de cada producto
     * POLIMORFISMO: cada subclase implementa mostrarDetalles() a su manera
     */
    public void mostrarDetallesTodos() {
        if (productos.isEmpty()) {
            System.out.println("📭 Inventario vacío");
            return;
        }
        System.out.println("\n📋 DETALLES DE PRODUCTOS:");
        System.out.println("=".repeat(50));
        for (Producto p : productos) {
            p.mostrarDetalles();  // Polimorfismo en acción
            System.out.println("   Precio con descuento: $" + p.calcularPrecioConDescuento());
            System.out.println("-".repeat(30));
        }
    }

    /**
     * Calcula el valor total del inventario
     */
    public double calcularValorTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio() * p.getStock();
        }
        return total;
    }

    /**
     * Vende un producto por código (polimorfismo con interfaz)
     */
    public void venderProducto(String codigo, int cantidad) {
        Producto p = buscarPorCodigo(codigo);
        if (p == null) {
            System.out.println("❌ Producto no encontrado");
            return;
        }
        if (p instanceof IVendible) {
            ((IVendible) p).vender(cantidad);
        } else {
            System.out.println("❌ Este producto no es vendible");
        }
    }
}