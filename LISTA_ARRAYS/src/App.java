public class App {
    public static void main(String[] args) {
        System.out.println("Inicializando la lista 5 MAX");
        ListaDoble lista = new ListaDoble(5);
        if (lista.estaVacia()) {
            System.out.println("Estado: La lista que pediste esta vacia");
        }

        System.out.println("Agregando elementos a la lista");
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        lista.mostrarAdelante();

        System.out.println("Insertando en las posiciones especificas");
        System.out.println("Insertando el elemento 5 al inicio");
        lista.insertarEnPosicion(5, 0);

        System.out.println("Insertando el elemento 25 en la posicion 3 (entre 20 y 30)");
        lista.insertarEnPosicion(25, 3);

        lista.mostrarAdelante();

        System.out.println("Prueba de capacidad MAX");
        if(lista.estaLlena()){
            System.out.println("La lista se lleno correctamente con 5 elementos");
        }        

        System.out.println("Intentando agregar el 99");
        lista.agregar(99);

        System.out.println("Eliminacion y reciclaje");
        System.out.println("Eliminando el elemento de posicion 2, num 20");
        lista.eliminar(2);

        lista.mostrarAdelante();

        System.out.println("Agregando 40 al final de la lista");
        lista.agregar(40);

        lista.mostrarAdelante();
        lista.mostrarAtras();

        System.out.println("Estado Final");
        System.out.println("Esta llena?" + lista.estaLlena());
        System.out.println("Esta vacia?" + lista.estaVacia());
    }
}
