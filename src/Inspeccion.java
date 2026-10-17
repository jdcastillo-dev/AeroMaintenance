import java.time.LocalDate;

public class Inspeccion {

    // Atributos
    private int idInspeccion;
    private String descripcion;
    private LocalDate fecha;
    private String resultado;
    private OrdenMantenimiento ordenMantenimiento;

    // Metodos
    // Constructor
    public Inspeccion(int idInspeccion, String descripcion,
                      OrdenMantenimiento ordenMantenimiento) {
        this.idInspeccion = idInspeccion;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.resultado = "Pendiente";
        this.ordenMantenimiento = ordenMantenimiento;
    }

    // Getters
    public int getIdInspeccion() {
        return idInspeccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public OrdenMantenimiento getOrdenMantenimiento() {
        return ordenMantenimiento;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    // toString
    @Override
    public String toString() {
        return "ID Inspeccion: " + idInspeccion +
                "\nDescripcion: " + descripcion +
                "\nFecha: " + fecha +
                "\nResultado: " + resultado +
                "\nOrden: " + ordenMantenimiento.getIdOrden();
    }
}
