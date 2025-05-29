package Lista;

public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object nuevoElemento, int pos) {
        //Inserta el nuevoElemento en la posición pos
        //Detecta y reporta error posicion invalida
        boolean exito = true;

        if (pos < 1 || pos > longitud() + 1) {
            exito = false;
        } else {
            if (pos == 1) { //Crea un nuevo nodo y lo engancha a la cabecera
                cabecera = new Nodo(nuevoElemento, cabecera);
            } else { //Avanza hasta el elemento en la pos - 1
                Nodo aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //Crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        //Nunca hay error de lista llena
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud()) {
            exito = false;
        } else {
            if (pos == 1) {
                cabecera = cabecera.getEnlace();
            } else {
                int i = 1;
                Nodo aux = cabecera;

                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object rta;
        if (pos < 1 || pos > this.longitud()) {
            rta = null;
        } else {
            Nodo aux = cabecera;
            int i = 1;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            rta = aux.getElemento();
        }
        return rta;
    }
    
    public int localizar(Object elemento){
        Nodo aux = cabecera;
        int i, pos;
        i = 1;
        while (aux != null && !aux.getElemento().equals(elemento)) {            
            aux = aux.getEnlace();
            i++;
        }
        if (aux == null) {
            pos = -1;
        }
        pos = i;
        return pos;
    }
    
    public int longitud(){
        int largo = 0;
        Nodo aux = cabecera;
        while (aux != null) {            
            largo++;
            aux = aux.getEnlace();
        }
        return largo;
    }
    
    public boolean esVacia(){
        return cabecera == null;
    }
    
    public void vaciar(){
        cabecera = null;
    }
    
    public Lista clone(){
        Nodo aux = cabecera;
        Lista listaClon = new Lista();        
        listaClon.cabecera = cloneAux(aux);
        return listaClon;
    }
    
    private Nodo cloneAux(Nodo nodo){
        Nodo aux;
        if (nodo == null) {
            aux = null;
        } else {
            aux = new Nodo(nodo.getElemento(), cloneAux(nodo.getEnlace()));
        }
        return aux;
    }
    
    public String toString(){
        String texto ="";
        Nodo aux = cabecera;
        
        while (aux != null) {            
            texto = texto + aux.getElemento() + " ";
            aux = aux.getEnlace();
        }
        return texto;
    }

}
