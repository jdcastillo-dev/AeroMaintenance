    public class Motor {

        // Atributos
        private String numeroSerie;
        private String fabricante;
        private String modelo;
        private double horasVuelo;
        private String estado;

        // Metodos
        // Constructor
        public Motor(String numeroSerie, String fabricante,
                     String modelo, double horasVuelo) {
            this.numeroSerie = numeroSerie;
            this.fabricante = fabricante;
            this.modelo = modelo;
            setHorasVuelo(horasVuelo);
            this.estado = "Operativo";
        }

        // Getters
        public String getNumeroSerie() {
            return numeroSerie;
        }

        public String getFabricante() {
            return fabricante;
        }

        public String getModelo() {
            return modelo;
        }

        public double getHorasVuelo() {
            return horasVuelo;
        }

        public String getEstado() {
            return estado;
        }

        // Setters
        public void setHorasVuelo(double horasVuelo) {
            if (horasVuelo >= 0) {
                this.horasVuelo = horasVuelo;
            }
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        // toString
        @Override
        public String toString() {
            return "Numero de serie: " + numeroSerie +
                    "\nFabricante: " + fabricante +
                    "\nModelo: " + modelo +
                    "\nHoras de vuelo: " + horasVuelo +
                    "\nEstado: " + estado;
        }
    }