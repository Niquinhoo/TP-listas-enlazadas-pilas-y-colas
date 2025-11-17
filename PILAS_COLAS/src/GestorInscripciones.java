public class GestorInscripciones {
    private Cola colaSolicitudes;

    public GestorInscripciones(){
        this.colaSolicitudes = new Cola();
    }

    public void nuevaSolicitud(SolicitudInscripcion solicitud){
        colaSolicitudes.encolar(solicitud);
        System.out.println("Solicitud " + solicitud + " recibida");
    }

    public void procesarSiguiente(){
        if (colaSolicitudes.esVacia()){
            System.out.println("No hay solicitudes pendientes");
            return;
        }
        SolicitudInscripcion sol = (SolicitudInscripcion) colaSolicitudes.desencolar();
        System.out.println("Procesando la solicitud... " + sol);
    }

    public Cola getCola(){
        return colaSolicitudes;
    }
}
