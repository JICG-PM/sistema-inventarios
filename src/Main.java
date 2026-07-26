/**
 * Clase Main - Programa Principal
 * Demuestra POLIMORFISMO, CLASES ABSTRACTAS e INTERFACES.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🏪 SISTEMA DE GESTIÓN DE INVENTARIOS");
        System.out.println("=".repeat(50));

        // 1. Crear inventario
        Inventario inventario = new Inventario();

        // 2. Crear productos de diferentes tipos (POLIMORFISMO)
        System.out.println("\n📦 AGREGANDO PRODUCTOS:");
        System.out.println("-".repeat(30));

        // Producto Electrónico
        Electronico laptop = new Electronico(
                "Laptop Gaming", 1200.00, 10, "E001",
                "ASUS", 24
        );
        inventario.agregarProducto(laptop);

        // Producto Alimento
        Alimento manzanas = new Alimento(
                "Manzanas Orgánicas", 3.50, 50, "A001",
                "2025-12-31", true
        );
        inventario.agregarProducto(manzanas);

        // Producto Ropa
        Ropa camisa = new Ropa(
                "Camisa Polo", 25.00, 30, "R001",
                "M", "Algodón", "Azul"
        );
        inventario.agregarProducto(camisa);

        // Otro Electrónico
        Electronico telefono = new Electronico(
                "Smartphone", 800.00, 5, "E002",
                "Samsung", 12
        );
        inventario.agregarProducto(telefono);

        // 3. Mostrar todos los productos (polimorfismo en toString)
        inventario.mostrarTodos();

        // 4. Mostrar detalles específicos (polimorfismo en mostrarDetalles)
        inventario.mostrarDetallesTodos();

        // 5. Demostrar polimorfismo con interfaz IVendible
        System.out.println("\n🛒 DEMOSTRACIÓN DE VENTAS (POLIMORFISMO):");
        System.out.println("-".repeat(40));
        inventario.venderProducto("E001", 2);  // Vender laptop
        inventario.venderProducto("A001", 10); // Vender manzanas
        inventario.venderProducto("R001", 3);  // Vender camisa

        // 6. Demostrar descuentos especiales (polimorfismo con interfaz)
        System.out.println("\n💸 APLICANDO DESCUENTOS ESPECIALES:");
        System.out.println("-".repeat(40));
        laptop.aplicarDescuentoEspecial(15);  // Descuento en electrónico
        manzanas.aplicarDescuentoEspecial(10); // Descuento en alimento
        camisa.aplicarDescuentoEspecial(20);   // Descuento en ropa

        // 7. Mostrar inventario final
        inventario.mostrarTodos();

        // 8. Valor total del inventario
        System.out.println("\n💰 VALOR TOTAL DEL INVENTARIO: $" + inventario.calcularValorTotal());

        // 9. Buscar un producto por código
        System.out.println("\n🔍 BUSCANDO PRODUCTO POR CÓDIGO:");
        Producto encontrado = inventario.buscarPorCodigo("E002");
        if (encontrado != null) {
            System.out.println("   Encontrado: " + encontrado.getNombre());
            System.out.println("   Precio con descuento: $" + encontrado.calcularPrecioConDescuento());
        }

        System.out.println("\n✅ PROGRAMA FINALIZADO");
        System.out.println("📚 Conceptos demostrados: Polimorfismo, Clases Abstractas, Interfaces");
    }
}