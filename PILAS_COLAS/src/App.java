public class App {
    public static void main(String[] args) {
        System.out.println("Sistema de historial PILA");
        HistorialCambios historial = new HistorialCambios();

        historial.registrarCambio(new CambioNota("Juan", "Mtematica", 6, 7));
        historial.registrarCambio(new CambioNota("Ana", "Historia", 5, 10));
        historial.registrarCambio(new CambioNota("Pedro", "Fisica", 2, 6));

        System.out.println("\nRecursividad, contando elementos en pila");
        int cantidad = contarElementosPilaRecursivo(historial.getPila());
        System.out.println("Elementos de la pila: " + cantidad);

        System.out.println("\nDeshaciendo Cambios");
        historial.deshacerUltimoCambio();
        historial.deshacerUltimoCambio();

        System.out.println("\nSistemas de inscripciones COLA");
        GestorInscripciones gestor = new GestorInscripciones();

        gestor.nuevaSolicitud(new SolicitudInscripcion("Maria", "Etica"));
        gestor.nuevaSolicitud(new SolicitudInscripcion("Jose", "Arte"));
        gestor.nuevaSolicitud(new SolicitudInscripcion("Laureano", "Religion"));

        System.out.println("\nProcesando normal");
        gestor.procesarSiguiente();

        System.out.println("\nRecursividad - Vaciando Cola");
        vaciarColaRecursivo(gestor.getCola());

        System.out.println("\nFinal");
        gestor.procesarSiguiente();
    }

    public static int contarElementosPilaRecursivo(Pila pila){
        if (pila.esVacia()){
            return 0;
        } else {
            Object auxiliar = pila.desapilar();
            int conteoRestante = contarElementosPilaRecursivo(pila);
            pila.apilar(auxiliar);
            return 1 + conteoRestante;
        }
    }

    public static void vaciarColaRecursivo(Cola cola){
        if (cola.esVacia()){
            System.out.println("La cola se ha vaciado completamente");
            return;
        }

        Object elemento = cola.desencolar();
        System.out.println("Vaciando recursivamente" + elemento);

        vaciarColaRecursivo(cola);

    }
}
