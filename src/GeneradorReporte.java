public class GeneradorReporte {

    // Generar reporte de una aeronave
    public void generarReporteAeronave(Aeronave aeronave) {

        if (aeronave == null) {
            System.out.println("No se puede generar el reporte.");
            return;
        }

        System.out.println("\n=== REPORTE DE AERONAVE ===");
        System.out.println("Matricula: " + aeronave.getMatricula());
        System.out.println("Fabricante: " + aeronave.getFabricante());
        System.out.println("Modelo: " + aeronave.getModelo());
        System.out.println("Año: " + aeronave.getAnioFabricacion());
        System.out.println("Estado: " + aeronave.getEstado());
    }

    // Generar reporte de una orden de mantenimiento
    public void generarReporteOrden(OrdenMantenimiento orden) {

        if (orden == null) {
            System.out.println("No se puede generar el reporte.");
            return;
        }

        System.out.println("\n=== REPORTE DE MANTENIMIENTO ===");
        System.out.println("Orden: " + orden.getIdOrden());
        System.out.println("Descripcion: " + orden.getDescripcion());
        System.out.println("Fecha: " + orden.getFechaCreacion());
        System.out.println("Estado: " + orden.getEstado());

        System.out.println("Aeronave: "
                + orden.getAeronave().getMatricula());

        System.out.println("Tecnico: "
                + orden.getTecnico().getNombre());
    }
}


