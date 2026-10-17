public class Aeronave {

    // Atributos
    private String matricula;
    private String fabricante;
    private String modelo;
    private int anioFabricacion;
    private String estado;
    private Motor motor1;
    private Motor motor2;

    // Metodos
    // Constructor
    public Aeronave(String matricula, String fabricante,
                    String modelo, int anioFabricacion,
                    String serieMotor1, String serieMotor2) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.estado = "Operativa";

        this.motor1 = new Motor(serieMotor1, "General Electric",
                "GEnx-1B",0);

        this.motor2 = new Motor(serieMotor2,"General Electric",
                "GEnx-1B",0);
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // toString
    @Override
    public String toString(){
        return "Matricula: " + matricula +
                "\nFabricante: " + fabricante +
                "\nModelo: " + modelo +
                "\nAño: " + anioFabricacion +
                "\nEstado: "  + estado;
    }

    // Mostrar motores
    public void mostrarMotores() {
        System.out.println("=== MOTORES DE LA AERONAVE ===");

        System.out.println("\nMotor 1:");
        System.out.println(motor1);

        System.out.println("\nMotor 2:");
        System.out.println(motor2);
    }
}
