
import java.util.ArrayList;

public class SistemaMantenimiento {

    // Atributos
    private String nombreEmpresa;
    private ArrayList<Aeronave> aeronaves;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<OrdenMantenimiento> ordenes;
    private ArrayList<Inspeccion> inspecciones;
    private ArrayList<Hangar> hangares;

    // Metodos
    // Constructor
    public SistemaMantenimiento(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.aeronaves = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
        this.ordenes = new ArrayList<>();
        this.inspecciones = new ArrayList<>();
        this.hangares = new ArrayList<>();
    }

    // Getters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    // Registrar aeronave
    public void registrarAeronave(Aeronave aeronave) {

        if (aeronave == null) {
            System.out.println("Aeronave no valida.");
            return;
        }

        // Validar matricula vacia
        if (aeronave.getMatricula() == null ||
                aeronave.getMatricula().trim().isEmpty()) {
            System.out.println("La matricula no puede estar vacia.");
            return;
        }

        // Verificar matricula duplicada
        if (buscarAeronave(aeronave.getMatricula()) != null) {
            System.out.println("Ya existe una aeronave con esa matricula.");
            return;
        }

        aeronaves.add(aeronave);
        System.out.println("Aeronave registrada correctamente.");
    }

    // Registrar tecnico
    public void registrarTecnico(Tecnico tecnico) {

        if (tecnico == null) {
            System.out.println("Tecnico no valido.");
            return;
        }

        // Validar ID
        if (tecnico.getIdTecnico() <= 0) {
            System.out.println("El ID debe ser mayor a cero.");
            return;
        }

        // Verificar ID duplicado
        if (buscarTecnico(tecnico.getIdTecnico()) != null) {
            System.out.println("Ya existe un tecnico con ese ID.");
            return;
        }

        tecnicos.add(tecnico);
        System.out.println("Tecnico registrado correctamente.");
    }

    // Registrar orden de mantenimiento
    public void registrarOrden(OrdenMantenimiento orden) {

        if (orden == null) {
            System.out.println("Orden no valida.");
            return;
        }

        // Validar ID
        if (orden.getIdOrden() <= 0) {
            System.out.println("El ID debe ser mayor a cero.");
            return;
        }

        // Validar aeronave registrada
        if (orden.getAeronave() == null ||
                buscarAeronave(
                        orden.getAeronave().getMatricula()
                ) != orden.getAeronave()) {

            System.out.println("La aeronave no esta registrada.");
            return;
        }

        // Validar tecnico registrado
        if (orden.getTecnico() == null ||
                buscarTecnico(
                        orden.getTecnico().getIdTecnico()
                ) != orden.getTecnico()) {

            System.out.println("El tecnico no esta registrado.");
            return;
        }

        // Verificar orden duplicada
        if (buscarOrden(orden.getIdOrden()) != null) {
            System.out.println("Ya existe una orden con ese ID.");
            return;
        }

        ordenes.add(orden);
        System.out.println("Orden registrada correctamente.");
    }

    // Mostrar aeronaves
    public void mostrarAeronaves() {
        System.out.println("\n=== AERONAVES REGISTRADAS ===");

        if (aeronaves.isEmpty()) {
            System.out.println("No hay aeronaves registradas.");
            return;
        }

        for (Aeronave aeronave : aeronaves) {
            System.out.println("\n" + aeronave);
        }
    }

    // Mostrar tecnicos
    public void mostrarTecnicos() {
        System.out.println("\n=== TECNICOS REGISTRADOS ===");

        if (tecnicos.isEmpty()) {
            System.out.println("No hay tecnicos registrados.");
            return;
        }

        for (Tecnico tecnico : tecnicos) {
            System.out.println("\n" + tecnico);
        }
    }

    // Mostrar ordenes
    public void mostrarOrdenes() {
        System.out.println("\n=== ORDENES DE MANTENIMIENTO ===");

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes registradas.");
            return;
        }

        for (OrdenMantenimiento orden : ordenes) {
            System.out.println("\n" + orden);
        }
    }

    // Buscar aeronave por matricula
    public Aeronave buscarAeronave(String matricula) {

        if (matricula == null) {
            return null;
        }

        for (Aeronave aeronave : aeronaves) {
            if (aeronave.getMatricula().equalsIgnoreCase(matricula)) {
                return aeronave;
            }
        }

        return null;
    }

    // Buscar tecnico por ID
    public Tecnico buscarTecnico(int idTecnico) {

        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getIdTecnico() == idTecnico) {
                return tecnico;
            }
        }

        return null;
    }

    // Buscar orden por ID
    public OrdenMantenimiento buscarOrden(int idOrden) {

        for (OrdenMantenimiento orden : ordenes) {
            if (orden.getIdOrden() == idOrden) {
                return orden;
            }
        }

        return null;
    }

    // Registrar inspeccion
    public void registrarInspeccion(Inspeccion inspeccion) {

        if (inspeccion == null) {
            System.out.println("Inspeccion no valida.");
            return;
        }

        // Validar ID
        if (inspeccion.getIdInspeccion() <= 0) {
            System.out.println("El ID debe ser mayor a cero.");
            return;
        }

        // Validar orden registrada
        OrdenMantenimiento orden = inspeccion.getOrdenMantenimiento();

        if (orden == null ||
                buscarOrden(orden.getIdOrden()) != orden) {

            System.out.println(
                    "La orden de mantenimiento no esta registrada."
            );
            return;
        }

        // Verificar inspeccion duplicada
        for (Inspeccion registrada : inspecciones) {
            if (registrada.getIdInspeccion() ==
                    inspeccion.getIdInspeccion()) {

                System.out.println("El ID de inspeccion ya existe.");
                return;
            }
        }

        inspecciones.add(inspeccion);
        System.out.println("Inspeccion registrada correctamente.");
    }

    // Mostrar inspecciones
    public void mostrarInspecciones() {
        System.out.println("\n=== INSPECCIONES REGISTRADAS ===");

        if (inspecciones.isEmpty()) {
            System.out.println("No hay inspecciones registradas.");
            return;
        }

        for (Inspeccion inspeccion : inspecciones) {
            System.out.println("\n" + inspeccion);
        }
    }

    // Registrar hangar
    public void registrarHangar(Hangar hangar) {

        if (hangar == null) {
            System.out.println("Hangar no valido.");
            return;
        }

        // Validar ID
        if (hangar.getIdHangar() <= 0) {
            System.out.println("El ID del hangar debe ser mayor a cero.");
            return;
        }

        // Verificar hangar duplicado
        if (buscarHangar(hangar.getIdHangar()) != null) {
            System.out.println("El ID del hangar ya existe.");
            return;
        }

        hangares.add(hangar);
        System.out.println("Hangar registrado correctamente.");
    }

    // Buscar hangar por ID
    public Hangar buscarHangar(int idHangar) {

        for (Hangar hangar : hangares) {
            if (hangar.getIdHangar() == idHangar) {
                return hangar;
            }
        }

        return null;
    }

    // Mostrar hangares
    public void mostrarHangares() {
        System.out.println("\n=== HANGARES REGISTRADOS ===");

        if (hangares.isEmpty()) {
            System.out.println("No hay hangares registrados.");
            return;
        }

        for (Hangar hangar : hangares) {
            System.out.println("\n" + hangar);
            hangar.mostrarAeronaves();
        }
    }

    // Generar reporte de aeronave
    public void generarReporteAeronave(
            String matricula, GeneradorReporte generador) {

        if (generador == null) {
            System.out.println("Generador de reportes no disponible.");
            return;
        }

        Aeronave aeronave = buscarAeronave(matricula);

        if (aeronave == null) {
            System.out.println("Aeronave no encontrada.");
            return;
        }

        generador.generarReporteAeronave(aeronave);
    }

    // Verificar si una aeronave esta asignada a un hangar
    public boolean aeronaveEnOtroHangar(Aeronave aeronave) {

        for (Hangar hangar : hangares) {
            if (hangar.contieneAeronave(aeronave)) {
                return true;
            }
        }

        return false;
    }
}

