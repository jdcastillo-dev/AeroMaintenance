public class Tecnico {

    // Atributos
    private int idTecnico;
    private String nombre;
    private String especialidad;
    private String numeroLicencia;
    private boolean activo;

    // Metodos
    // Constructor
    public Tecnico(int idTecnico, String nombre,
                   String especialidad, String numeroLicencia) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.activo = true;
    }

    // Getters
    public int getIdTecnico() {
        return idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public boolean isActivo() {
        return activo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // toString
    @Override
    public String toString() {
        return "ID Tecnico: " + idTecnico +
                "\nNombre: " + nombre +
                "\nEspecialidad: " + especialidad +
                "\nNumero de licencia: " + numeroLicencia +
                "\nActivo: " + (activo ? "Si" : "No");
    }
}
