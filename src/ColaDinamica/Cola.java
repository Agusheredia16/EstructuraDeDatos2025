package ColaDinamica;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.frente = null;
        this.fin = null;
    }
    
    public boolean poner(Object elemento){
        Nodo aux = new Nodo(elemento, null);
        if (!esVacia()) {
            fin.setEnlace(aux);
            fin = aux;
        } else {
            frente = aux;
            fin = aux;
        }
        return true;
    }
    
    public boolean sacar(){
        boolean exito = false;
        if (frente != null) {
            frente = frente.getEnlace();
            if (this.frente == null) {
                fin = null;
            }
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object elemento = null;
        if (!esVacia()) {
            elemento = frente.getElemento();
        }
        return elemento;
    }
    
    public boolean esVacia(){
        boolean rta = false;
        if (frente == null && fin == null) {
            rta = true;
        }
        return rta;
    }
    
    public void vaciar(){
        frente = null;
        fin = null;
    }
    
    public Cola clone(){
        Cola clon = new Cola();
        Nodo nodo;
        if (!esVacia()) {
            nodo = cloneAux(frente);
            clon.frente = nodo;
            clon.fin = obtenerFin(nodo);
        }
        return clon;
    }
    
    private Nodo cloneAux(Nodo nodo){
        Nodo nuevo;
        if (nodo == null) {
            nuevo = null;
        } else {
            nuevo = new Nodo(nodo.getElemento(), cloneAux(nodo.getEnlace()));
        }
        return nuevo;
    }
    
    /* VIEJO
    private Nodo cloneAux(Nodo nodo){
        Nodo nodoAux = new Nodo("", null);
        if (nodo.getEnlace() == null) {
            nodoAux = new Nodo(nodo.getElemento(), null);
        } else {
            nodoAux.setElemento(nodo.getElemento());
            nodoAux.setEnlace(cloneAux(nodo.getEnlace()));
        }
        return nodoAux;
    }
    */
    
    private Nodo obtenerFin(Nodo nodo){
        while (nodo.getEnlace() != null) {            
            nodo = nodo.getEnlace();
        }
        return nodo;
    }
    
    public String toString(){
        String texto = "";
        for (Nodo aux = frente; aux != null; aux = aux.getEnlace()) {
            texto = texto + (String) aux.getElemento() + "\n";
        }
        return texto;
    }
    
}
