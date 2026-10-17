import java.util.ArrayList;

public class Hangar {

    // Atributos
    private int idHangar;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private ArrayList<Aeronave> aeronaves;

    // Metodos
    // Constructor
    public Hangar(int idHangar, String nombre,
                  String ubicacion, int capacidad) {
        this.idHangar = idHangar;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = Math.max(0, capacidad);
        this.aeronaves = new ArrayList<>();
    }

    // Getters
    public int getIdHangar() {
        return idHangar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Agregar aeronave al hangar
    public void agregarAeronave(Aeronave aeronave) {
        if (aeronave == null) {
            System.out.println("Aeronave no valida.");
            return;
        }

        if (aeronaves.contains(aeronave)) {
            System.out.println("La aeronave ya esta en el hangar.");
            return;
        }

        if (aeronaves.size() < capacidad) {
            aeronaves.add(aeronave);
            System.out.println("Aeronave agregada al hangar.");
        } else {
            System.out.println("El hangar esta lleno.");
        }
    }

    // Mostrar aeronaves
    public void mostrarAeronaves() {
        System.out.println("\n=== AERONAVES DEL HANGAR ===");
        System.out.println("Hangar: " + nombre);

        if (aeronaves.isEmpty()) {
            System.out.println("No hay aeronaves registradas.");
            return;
        }

        for (Aeronave aeronave : aeronaves){
            System.out.println(aeronave);
        }
    }

    // toString
    @Override
    public String toString() {
        return "ID Hangar: " + idHangar +
                "\nNombre: " + nombre +
                "\nUbicacion: " + ubicacion +
                "\nCapacidad: " + capacidad +
                "\nAeronaves registradas: " + aeronaves.size();
    }

    // Verificar si una aeronave pertenece al hangar
    public boolean contieneAeronave(Aeronave aeronave) {
        return aeronaves.contains(aeronave);
    }
}
