public class HistorialCambios {
    private Pila pilaCambios;

    public HistorialCambios(){
        this.pilaCambios = new Pila();
    }

    public void registrarCambio(CambioNota cambio){
        pilaCambios.apilar(cambio);
        System.out.println("Registrado: " + cambio);
    }

    public CambioNota deshacerUltimoCambio(){
        if (pilaCambios.esVacia()){
            System.out.println("No hay nada para deshacer");
            return null;
        }
        CambioNota cambio = (CambioNota) pilaCambios.desapilar();
        System.out.println("Deshaciendo... " + cambio);
        return cambio;
    }

    public Pila getPila(){
        return pilaCambios;
    }
}
