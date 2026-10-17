
import java.util.Scanner;

public class Main {

    // Metodo principal
    public static void main(String[] args) {

        // Inicializar sistema
        Scanner scanner = new Scanner(System.in);

        SistemaMantenimiento sistema =
                new SistemaMantenimiento("AeroMaintenance Costa Rica");

        GeneradorReporte generadorReporte = new GeneradorReporte();

        int opcion = 0;

        // Menu principal
        do {
            System.out.println("\n========== AEROMAINTENANCE ==========");
            System.out.println("1. Registrar aeronave");
            System.out.println("2. Mostrar aeronaves");
            System.out.println("3. Registrar tecnico");
            System.out.println("4. Mostrar tecnicos");
            System.out.println("5. Crear orden de mantenimiento");
            System.out.println("6. Mostrar ordenes");
            System.out.println("7. Registrar inspeccion");
            System.out.println("8. Mostrar inspecciones");
            System.out.println("9. Registrar hangar");
            System.out.println("10. Mostrar hangares");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero(scanner);

            switch (opcion) {

                // Registrar aeronave
                case 1:
                    System.out.println("\n=== REGISTRAR AERONAVE ===");

                    System.out.print("Matricula: ");
                    String matricula = scanner.nextLine();

                    System.out.print("Fabricante: ");
                    String fabricante = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Año de fabricacion: ");
                    int anio = leerEntero(scanner);

                    System.out.print("Serie del motor 1: ");
                    String serie1 = scanner.nextLine();

                    System.out.print("Serie del motor 2: ");
                    String serie2 = scanner.nextLine();

                    Aeronave aeronave = new Aeronave(
                            matricula, fabricante, modelo,
                            anio, serie1, serie2
                    );

                    sistema.registrarAeronave(aeronave);
                    break;

                // Consultar aeronave
                case 2:
                    System.out.println("\n=== CONSULTAR AERONAVE ===");

                    System.out.print("Ingrese la matricula de la aeronave: ");
                    String matriculaReporte = scanner.nextLine();

                    sistema.generarReporteAeronave(
                            matriculaReporte, generadorReporte
                    );
                    break;

                // Registrar tecnico
                case 3:
                    System.out.println("\n=== REGISTRAR TECNICO ===");

                    System.out.print("ID del tecnico: ");
                    int id = leerEntero(scanner);

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();

                    System.out.print("Numero de licencia: ");
                    String licencia = scanner.nextLine();

                    Tecnico tecnico = new Tecnico(
                            id, nombre, especialidad, licencia
                    );

                    sistema.registrarTecnico(tecnico);
                    break;

                // Mostrar tecnicos
                case 4:
                    sistema.mostrarTecnicos();
                    break;

                // Crear orden de mantenimiento
                case 5:
                    System.out.println("\n=== CREAR ORDEN DE MANTENIMIENTO ===");

                    System.out.print("ID de la orden: ");
                    int idOrden = leerEntero(scanner);

                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Matricula de la aeronave: ");
                    String matriculaBuscar = scanner.nextLine();

                    Aeronave aeronaveEncontrada =
                            sistema.buscarAeronave(matriculaBuscar);

                    if (aeronaveEncontrada == null) {
                        System.out.println("Aeronave no encontrada.");
                        break;
                    }

                    System.out.print("ID del tecnico: ");
                    int idTecnicoBuscar = leerEntero(scanner);

                    Tecnico tecnicoEncontrado =
                            sistema.buscarTecnico(idTecnicoBuscar);

                    if (tecnicoEncontrado == null) {
                        System.out.println("Tecnico no encontrado.");
                        break;
                    }

                    OrdenMantenimiento nuevaOrden =
                            new OrdenMantenimiento(
                                    idOrden,
                                    descripcion,
                                    aeronaveEncontrada,
                                    tecnicoEncontrado
                            );

                    sistema.registrarOrden(nuevaOrden);
                    break;

                // Mostrar ordenes
                case 6:
                    sistema.mostrarOrdenes();
                    break;

                // Registrar inspeccion
                case 7:
                    System.out.println("\n=== REGISTRAR INSPECCION ===");

                    System.out.print("ID de la inspeccion: ");
                    int idInspeccion = leerEntero(scanner);

                    System.out.print("Descripcion: ");
                    String descripcionInspeccion = scanner.nextLine();

                    System.out.print("ID de la orden de mantenimiento: ");
                    int idOrdenBuscar = leerEntero(scanner);

                    OrdenMantenimiento ordenEncontrada =
                            sistema.buscarOrden(idOrdenBuscar);

                    if (ordenEncontrada == null) {
                        System.out.println("Orden de mantenimiento no encontrada.");
                        break;
                    }

                    Inspeccion nuevaInspeccion = new Inspeccion(
                            idInspeccion,
                            descripcionInspeccion,
                            ordenEncontrada
                    );

                    System.out.print("Resultado de la inspeccion: ");
                    String resultado = scanner.nextLine();

                    nuevaInspeccion.setResultado(resultado);

                    sistema.registrarInspeccion(nuevaInspeccion);
                    break;

                // Mostrar inspecciones
                case 8:
                    sistema.mostrarInspecciones();
                    break;

                // Registrar hangar
                case 9:
                    System.out.println("\n=== REGISTRAR HANGAR ===");

                    System.out.print("ID del hangar: ");
                    int idHangar = leerEntero(scanner);

                    if (idHangar <= 0) {
                        System.out.println("El ID debe ser mayor a cero.");
                        break;
                    }

                    if (sistema.buscarHangar(idHangar) != null) {
                        System.out.println("El ID del hangar ya existe.");
                        break;
                    }

                    System.out.print("Nombre del hangar: ");
                    String nombreHangar = scanner.nextLine();

                    System.out.print("Ubicacion: ");
                    String ubicacion = scanner.nextLine();

                    System.out.print("Capacidad de aeronaves: ");
                    int capacidad = leerEntero(scanner);

                    if (capacidad <= 0) {
                        System.out.println("La capacidad debe ser mayor a cero.");
                        break;
                    }

                    Hangar nuevoHangar = new Hangar(
                            idHangar, nombreHangar,
                            ubicacion, capacidad
                    );

                    sistema.registrarHangar(nuevoHangar);

                    Hangar hangarRegistrado =
                            sistema.buscarHangar(idHangar);

                    if (hangarRegistrado != nuevoHangar) {
                        System.out.println("No se pudo registrar el hangar.");
                        break;
                    }

                    // Asignar aeronave al hangar
                    System.out.print("Desea agregar una aeronave? (Si/No): ");
                    String respuesta = scanner.nextLine();

                    if (respuesta.equalsIgnoreCase("Si")) {

                        System.out.print("Matricula de la aeronave: ");
                        String matriculaHangar = scanner.nextLine();

                        Aeronave aeronaveHangar =
                                sistema.buscarAeronave(matriculaHangar);

                        if (aeronaveHangar == null) {
                            System.out.println("Aeronave no encontrada.");
                            break;
                        }

                        if (sistema.aeronaveEnOtroHangar(aeronaveHangar)) {
                            System.out.println(
                                    "La aeronave ya esta asignada a un hangar."
                            );
                            break;
                        }

                        hangarRegistrado.agregarAeronave(aeronaveHangar);
                    }
                    break;

                // Mostrar hangares
                case 10:
                    sistema.mostrarHangares();
                    break;

                // Salir del sistema
                case 11:
                    System.out.println("Saliendo de AeroMaintenance...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 11);

        scanner.close();
    }

    // Validar entrada de numeros enteros
    public static int leerEntero(Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.println("Error: debe ingresar un numero entero.");
            scanner.nextLine();
            System.out.print("Intente nuevamente: ");
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }
}




