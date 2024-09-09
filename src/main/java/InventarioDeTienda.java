import java.util.Scanner;

public class InventarioDeTienda {
    private static Object[][] productos;

    public static void main(String[] args) {
        productos = crearMatrizLista();
        ejecutarMenu();
    }

    public static Object[][] crearMatrizLista() {
        productos = new Object[10][3];
        agregarEnLista(0, 41, "Producto1", 4);
        agregarEnLista(1, 13, "Producto2", 4);
        agregarEnLista(2, 23, "Producto3", 4);
        agregarEnLista(3, 53, "Producto4", 4);
        agregarEnLista(4, 11, "Producto5", 4);
        agregarEnLista(5, 45, "Producto6", 4);
        agregarEnLista(6, 52, "Producto7", 4);
        agregarEnLista(7, 56, "Producto8", 4);
        agregarEnLista(8, 24, "Producto9", 6);
        agregarEnLista(9, 64, "Producto10", 8);
        return productos;
    }

    public static void agregarProductos(int idProducto, int cantidad) {
        try {
            int index = buscarProducto(idProducto);
            productos[index][2] = (int) productos[index][2] + cantidad;
        } catch (Exception e) {
            System.out.println("Error al agregar productos: " + e.getMessage());
        }
    }

    public static void restarProductos(int idProducto, int cantidad) {
        try {
            int index = buscarProducto(idProducto);
            productos[index][2] = (int) productos[index][2] - cantidad;
        } catch (Exception e) {
            System.out.println("Error al restar productos: " + e.getMessage());
        }
    }

    public static void consultarDispibilidad(int idProducto) {
        try {
            int index = buscarProducto(idProducto);
            System.out.println("ID: " + productos[index][0] + ", Nombre: " + productos[index][1] + ", Cantidad: " + productos[index][2]);
        } catch (Exception e) {
            System.out.println("Error al consultar disponibilidad: " + e.getMessage());
        }
    }

    public static int buscarProducto(int ID) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null && productos[i][0].equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public static void agregarEnLista(int index, int ID, String nombre, int cantidad) {
        if (index >= 0 && index < productos.length) {
            productos[index][0] = ID;
            productos[index][1] = nombre;
            productos[index][2] = cantidad;
        }
    }

    public static void listarProductos() {
        for (Object[] producto : productos) {
            if (producto[0] != null) {
                System.out.println("ID: " + producto[0] + ", Nombre: " + producto[1] + ", Cantidad: " + producto[2]);
            }
        }
    }

    public static void ejecutarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenu del inventario de la tienda:");
        System.out.println("1. Agregar productos");
        System.out.println("2. Restar productos");
        System.out.println("3. Consultar disponibilidad");
        System.out.println("4. Listar productos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion;
        while (true) {
            try {
                Scanner scanner = crearScanner();
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= 5) {
                        break;
                    } else {
                        System.out.print("Opción inválida. Intente nuevamente: ");
                    }
                } else {
                    System.out.print("Entrada no válida. Ingrese un número: ");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Error al leer la opción: " + e.getMessage());
            }
        }
        return opcion;
    }

    public static int leerInt(String mensaje) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print(mensaje);
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error al leer el número: " + e.getMessage());
            return -1;
        }
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                int id = leerInt("Ingrese el ID del producto: ");
                int cantidad = leerInt("Ingrese la cantidad de productos: ");
                agregarProductos(id, cantidad);
                break;
            case 2:
                int id2 = leerInt("Ingrese el ID del producto: ");
                int cantidad2 = leerInt("Ingrese la cantidad de productos: ");
                restarProductos(id2, cantidad2);
                break;
            case 3:
                int id3 = leerInt("Ingrese el ID del producto: ");
                consultarDispibilidad(id3);
                break;
            case 4:
                listarProductos();
                break;
            case 5:
                salir();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void salir() {
        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        System.exit(0);
    }

    public static void setProductos(Object[][] productos) {
        InventarioDeTienda.productos = productos;
    }

    public static Object[][] getProductos() {
        return productos;
    }
}