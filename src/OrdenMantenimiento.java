import java.time.LocalDate;

public class OrdenMantenimiento {

    // Atributos
    private int idOrden;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;
    private Aeronave aeronave;
    private Tecnico tecnico;

    // Metodos
    // Constructor
    public OrdenMantenimiento(int idOrden, String descripcion,
                              Aeronave aeronave, Tecnico tecnico) {
        this.idOrden = idOrden;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();
        this.estado = "Pendiente";
        this.aeronave = aeronave;
        this.tecnico = tecnico;
    }

    // Getters
    public int getIdOrden() {
        return idOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    // toString
    @Override
    public String toString() {
        return "ID Orden: " + idOrden +
                "\nDescripcion: " + descripcion +
                "\nFecha: " + fechaCreacion +
                "\nEstado: " + estado +
                "\nAeronave: " + aeronave.getModelo() +
                "\nTenico: " + tecnico.getNombre();
    }
}
