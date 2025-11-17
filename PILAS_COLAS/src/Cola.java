public class Cola {
    private ListaEnlazada lista;

    public Cola(){
        this.lista = new ListaEnlazada();
    }

    public void encolar(Object dato){
        lista.insertarFinal(dato);
    }

    public Object desencolar(){
        return lista.eliminarInicio();
    }

    public Object verFrente(){
        return lista.verInicio();
    }

    public boolean esVacia(){
        return lista.esVacia();
    }
}
