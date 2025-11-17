public class Pila {
    private ListaEnlazada lista;

    public Pila(){
        this.lista = new ListaEnlazada();
    }

    public void apilar(Object dato){
        lista.insertarInicio(dato);
    }

    public Object desapilar(){
        return lista.eliminarInicio();
    }

    public Object tope(){
        return lista.verInicio();
    }

    public boolean esVacia(){
        return lista.esVacia();
    }
}
