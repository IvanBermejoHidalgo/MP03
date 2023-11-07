import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sumermercado {
    static class Producto {

        // Definir variables
        String codigodebarras;
        String nombre;
        double precio;

        // Constructor de producto
        public Producto(String codigodebarras, String nombre, double precio) {
            this.codigodebarras = codigodebarras;
            this.nombre = nombre;
            this.precio = precio;
        }

        // Getters de las variables
        public String getCodigodebarras() {
            return codigodebarras;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }
    }

    // Subclase Alimentacion que extiende Producto
    static class Alimentacion extends Producto {
        // Variables
        Date caducidad;

        // Constructor de Alimentacion
        public Alimentacion(String codigodebarras, String nombre, double precio, Date caducidad) {
            super(codigodebarras, nombre, precio);
            this.caducidad = caducidad;
        }

        // Getters de las variables
        public Date getCaducidad() {
            return caducidad;
        }

    }

    // Subclase Textil que extiende Producto
    static class Textil extends Producto {
        // Variables
        String composicion;

        // Constructor de Textil
        public Textil(String codigodebarras, String nombre, double precio, String composicion) {
            super(codigodebarras, nombre, precio);
            this.composicion = composicion;
        }
    }

    // Subclase Electronica que extiende Producto
    static class Electronica extends Producto {
        // Variables
        int diasdegarantia;

        // Constructor de Electronica
        public Electronica(String codigodebarras, String nombre, double precio, int diasdegarantia) {
            super(codigodebarras, nombre, precio);
            this.diasdegarantia = diasdegarantia;
        }

    }

    // Contar la cantidad de un producto en el carrito
    public static int ContarCantidad(Producto producto, ArrayList<Producto> carro) {
        int count = 0;
        for (Producto p : carro) {
            if (p.getCodigodebarras().equals(producto.getCodigodebarras()) && p.getPrecio() == producto.getPrecio()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Variables y datos
        ArrayList<Producto> carrito = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaactual = new Date();
        String nombresuper = "Supermercado XYZ";

        Scanner scanner = new Scanner(System.in);

        // Menu con las opciones
        while (true) {
            System.out.println("MENÚ");
            System.out.println("1. INTRODUCIR PRODUCTO");
            System.out.println("2. Pasar por caja");
            System.out.println("3. Mostrar carrito de la compra");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                // Introducir producto
                case 1:
                    System.out.println("INTRODUCIR PRODUCTO");
                    System.out.println("¿Qué tipo de producto quieres añadir?");
                    System.out.println("1. Alimentación");
                    System.out.println("2. Textil");
                    System.out.println("3. Electrónica");
                    System.out.println("0. Volver");
                    System.out.print("Elige una opción: ");
                    int tipodeproducto = scanner.nextInt();
                    scanner.nextLine();

                    if (tipodeproducto == 0) {
                        break;
                    }

                    System.out.print("Codigo de barras: ");
                    String codidebarras = scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombredelproducto = scanner.nextLine();
                    System.out.print("Precio unitario: ");
                    double preciounitario = scanner.nextDouble();

                    if (tipodeproducto == 1) {
                        System.out.print("Fecha de caducidad (dd/MM/yyyy):");
                        String fechadecaducidad = scanner.next();
                        try {
                            Date fechacaducidad = date.parse(fechadecaducidad);
                            Alimentacion alimentacion = new Alimentacion(codidebarras, nombredelproducto, preciounitario, fechacaducidad);
                            carrito.add(alimentacion);
                        } catch (Exception e) {
                            System.out.println("Formato de fecha incorrecto. No se ha añadido la Alimentación.");
                        }
                    } else if (tipodeproducto == 2) {
                        System.out.print("Composición textil: ");
                        String composicion = scanner.next();
                        Textil textil = new Textil(codidebarras, nombredelproducto, preciounitario, composicion);
                        carrito.add(textil);
                    } else if (tipodeproducto == 3) {
                        System.out.print("Días de garantía: ");
                        int diasGarantia = scanner.nextInt();
                        Electronica electronica = new Electronica(codidebarras, nombredelproducto, preciounitario, diasGarantia);
                        carrito.add(electronica);
                    }
                    System.out.println("Producto añadido al carrito de la compra.");
                    break;

                case 2:
                    // Opcion para pasar por caja
                    System.out.println("PASAR POR CAJA");
                    double totalCompra = 0.0;
                    System.out.println("Fecha de la compra: " + date.format(fechaactual));
                    System.out.println("Nombre del supermercado: " + nombresuper);
                    System.out.println("Detalle de la compra: ");

                    ArrayList<Producto> productosvistos = new ArrayList<>();
                    for (Producto producto : carrito) {
                        if (!productosvistos.contains(producto)) {
                            int cantidad2 = ContarCantidad(producto, carrito);
                            productosvistos.add(producto);
                            double preciototal = producto.getPrecio() * cantidad2;
                            System.out.println("Nombre: " + producto.getNombre() + "; Unidades: " + cantidad2 + "; Precio unitario: " + producto.getPrecio() + "; Precio total: " + preciototal);
                            totalCompra += preciototal;
                        }
                    }
                    System.out.println("Total a pagar: " + totalCompra);
                    carrito.clear();
                    break;

                case 3:
                    // Mostrar el carrito
                    System.out.println("CARRITO DE LA COMPRA");
                    for (Producto producto : carrito) {
                        System.out.println("Nombre: " + producto.getNombre());
                    }
                    break;

                case 0:
                    // Salir
                    System.out.println("¡ADIOS!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Vuelve a escoger.");
            }
        }
    }
}