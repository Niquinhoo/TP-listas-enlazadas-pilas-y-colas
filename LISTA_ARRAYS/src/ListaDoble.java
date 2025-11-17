public class ListaDoble implements ListaInt{
    private int[] datos;
    private int[] siguiente;
    private int[] anterior;
    private int inicio;
    private int fin;
    private int libre;
    private int capacidad;

    //Ejercicio 1 - Inicializacion 
    
    public ListaDoble(int capacidad){
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.siguiente = new int[capacidad];
        this.anterior = new int[capacidad];
        this.inicio = -1;
        this.fin = -1;
        inicializarLibres();
    }

    public boolean estaLlena(){
        return libre == -1;
    }

    public boolean estaVacia(){
        return inicio == -1;
    }

    public void agregar(int valor){
        int nuevoIndice = obtenerNuevoNodo(valor);

        if (nuevoIndice == -1){
            System.out.print("Error, la lista esta llena");
            return;
        }

        if (estaVacia()){
            inicio = nuevoIndice;
        } else {
            siguiente[fin] = nuevoIndice;
            anterior[nuevoIndice] = fin;
        }
        fin = nuevoIndice;
    }

    public void eliminar(int posicion){
        int indiceAEliminar = traducirPosicionAIndice(posicion);

        if (indiceAEliminar == -1) {
            System.out.println("Error, la posicion es invalida o la lista esta vacia");
            return;
        }

        int indAnt = anterior[indiceAEliminar];
        int indSig = siguiente[indiceAEliminar];

        if (indAnt != -1){
            siguiente[indAnt] = indSig;
        } else {
            inicio = indSig;
        }

        if (indSig != -1){
            anterior[indSig] = indAnt;
        } else {
            fin = indAnt;
        }

        System.out.println("Eliminando el valor: " + datos[indiceAEliminar]);
        liberarNodo(indiceAEliminar);
    }

    public void insertarEnPosicion(int valor, int posicion){
        if (estaLlena()){
            System.out.println("Error, la lista esta llena");
            return;
        }

        if(posicion == 0){
            int nuevoIndice = obtenerNuevoNodo(valor);
            siguiente[nuevoIndice] = inicio;
            if (!estaVacia()){
                anterior[inicio] = nuevoIndice;
            } else {
                fin = nuevoIndice;
            }
            inicio = nuevoIndice;
            return;
        }

        int indiceAnterior = traducirPosicionAIndice(posicion - 1);

        if (indiceAnterior == -1){
            System.out.println("Error, posicion invalida");
            return;
        }

        if (indiceAnterior == fin){
            agregar(valor);
            return;
        }

        int nuevoIndice = obtenerNuevoNodo(valor);
        int indiceSiguiente = siguiente[indiceAnterior];

        siguiente[nuevoIndice] = indiceSiguiente;
        anterior[nuevoIndice] = indiceAnterior;

        siguiente[indiceAnterior] = nuevoIndice;
        anterior[indiceSiguiente] = nuevoIndice;
    }
//metodos helper para enconder la complejidad de los arreglos al resot de la clase
    private void inicializarLibres(){
        this.libre = 0;
        for (int i = 0; i < capacidad - 1; i++){
            siguiente[i] = i+1;
            anterior[i] = -1;
        }
        siguiente[capacidad - 1] = -1;
        anterior[capacidad - 1] = -1;
    }
//obtinee el indice fisico de un nuevo nodo y actuyaliza la lista de libres
    private int obtenerNuevoNodo(int valor){
        if (libre == -1){
            return -1;
        }

        int nuevoIndice = libre;
        libre = siguiente[libre];

        datos[nuevoIndice] = valor;
        siguiente[nuevoIndice] = -1;
        anterior[nuevoIndice] = -1;

        return nuevoIndice;
    }
//devuelve un nodo a la lista de libres y limpia susre ferencias
    private void liberarNodo(int indice){
        siguiente[indice] = libre;
        anterior[indice] = -1;
        libre = indice;//el nodo liberado pasa a ser la cabeza de los nodos libres
    }

    private int traducirPosicionAIndice(int posicion){
        
        if(posicion < 0 || inicio == -1){
            return -1;
        }
        int indiceActual = inicio;
        int contador = 0;

        while (indiceActual != -1 && contador < posicion){
            indiceActual = siguiente[indiceActual];
            contador++;
        }
        return indiceActual;
    }

    //ejercicio 4, recorrer la lista hacia adelante
    public void mostrarAdelante(){
        System.out.println("Inicio lista ->");
        int actual = inicio;
        while(actual != -1){
            System.out.println("[" + datos[actual] + "] -> ");
            actual = siguiente[actual];
        }
        System.out.println("Fin");
    }

    public void mostrarAtras(){
        System.out.println("Fin lista ->");
        int actual = fin;
        while(actual != -1){
            System.out.println("[" + datos[actual] + "] -> ");
            actual = anterior[actual];
        }
        System.out.println("Inicio");
    }
    
}
