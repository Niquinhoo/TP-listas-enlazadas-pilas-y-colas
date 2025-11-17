public class ListaEnlazada {
    protected Nodo inicio;
    protected Nodo fin;
    protected int tamano;

    public ListaEnlazada(){
        inicio = null;
        fin = null;
        tamano = 0;
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public void insertarInicio(Object dato){
        Nodo nuevo = new Nodo(dato);
        if (esVacia()){
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
        tamano++;
    }

    public void insertarFinal(Object dato){
        Nodo nuevo = new Nodo(dato);
        if (esVacia()){
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamano++;
    }

    public Object eliminarInicio(){
        if (esVacia()){
            return null;
        }

        Object dato = inicio.dato;
        inicio = inicio.siguiente;
        tamano--;

        if (inicio == null){
            fin = null;
        }

        return dato;
    }

    public Object verInicio(){
        if (esVacia()){
            return null;
        }
        return inicio.dato;
    }

    public int getTamano(){
        return tamano;
    }
}
