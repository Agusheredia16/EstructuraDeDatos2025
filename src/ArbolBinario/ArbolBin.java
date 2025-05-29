package ArbolBinario;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    /*
    Inserta elemNuevo como hijo del primer nodo encontrado en preorden igual a
    elemPadre, como HI o HD segun lo indique el parametro
     */
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;

        if (raiz == null) {
            //Si el arbol esta vacio, pone el nuevo elemento en la raiz
            raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //Si el arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(raiz, elemPadre);
            //Si padre existe y lugar no esta ocupado lo pone, si no da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else if (lugar == 'I' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //Metodo PRIVADO que busca un elemento y devuelve el nodo que
        //lo contiene. Si no se encuentra "buscado" devuelve null

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElemento().equals(buscado)) {
                //Si el buscado es n lo devuelve
                resultado = n;
            } else {
                //No es el buscado: busca en HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encuentra en HI, lo busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Object padre(Object buscado) {
        NodoArbol padre = raiz;
        Object elemPadre = null;
        if (!esVacio()) {
            elemPadre = padreAux(padre, buscado);
        }
        return elemPadre;
    }

    private Object padreAux(NodoArbol nodo, Object buscado) {
        Object rta;
        if (nodo == null) {
            rta = null;
        } else if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElemento().equals(buscado)) {
            rta = nodo.getElemento();
        } else if (nodo.getDerecho() != null && nodo.getDerecho().getElemento().equals(buscado)) {
            rta = nodo.getElemento();
        } else {
            rta = padreAux(nodo.getIzquierdo(), buscado);
            if (rta == null) {
                rta = padreAux(nodo.getDerecho(), buscado);
            }
        }
        return rta;
    }

    public int altura() {
        int altura = -1;
        if (!esVacio()) {
            NodoArbol nodo = raiz;
            altura = alturaMax(nodo);
        }
        return altura;
    }
    
    private int alturaMax(NodoArbol nodo){
        int altura;
        if (nodo == null) {
            altura = -1;
        } else {
            altura = Math.max(alturaMax(nodo.getIzquierdo()) + 1, alturaMax(nodo.getDerecho()) + 1);
        }
        return altura;
    }

}
