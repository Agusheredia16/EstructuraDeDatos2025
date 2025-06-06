package ArbolGenerico;

public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean rta = false;
        if (esVacio() && elemPadre == null) {
            raiz = new NodoGen(elemNuevo, null, null);
            rta = true;
        } else if (!esVacio() && elemPadre != null) {
            rta = insertarAux(raiz, elemNuevo, elemPadre);
        }
        return rta;
    }

    private boolean insertarAux(NodoGen nodo, Object elemNuevo, Object elemPadre) {
        boolean rta = false;
        if (nodo == null) {
            rta = false;
        } else {
            if (nodo.getElemento().equals(elemPadre)) {
                if (nodo.getHijoIzquierdo() == null) {
                    nodo.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                    rta = true;
                } else {
                    nodo.getHijoIzquierdo().setHermanoDerecho(
                            new NodoGen(elemNuevo, null, nodo.getHijoIzquierdo().getHermanoDerecho()));
                    rta = true;
                }
            }

            if (rta == false && nodo.getHijoIzquierdo() != null) {
                rta = insertarAux(nodo.getHijoIzquierdo(), elemNuevo, elemPadre);
            }
            if (rta == false && nodo.getHermanoDerecho() != null) {
                rta = insertarAux(nodo.getHermanoDerecho(), elemNuevo, elemPadre);
            }
        }
        return rta;
    }

    public boolean pertenece(Object elemento) {
        boolean rta = false;
        if (!esVacio()) {
            NodoGen aux = raiz;
            rta = perteneceAux(aux, elemento);
        }
        return rta;
    }

    private boolean perteneceAux(NodoGen nodo, Object buscado) {
        boolean rta = false;

        if (nodo == null) {
            rta = false;
        } else {
            if (nodo.getElemento().equals(buscado)) {
                rta = true;
            } else {
                if (nodo.getHijoIzquierdo() != null) {
                    rta = perteneceAux(nodo.getHijoIzquierdo(), buscado);
                }
                if (!rta && nodo.getHermanoDerecho() != null) {
                    rta = perteneceAux(nodo.getHermanoDerecho(), buscado);
                }
            }
        }
        return rta;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Object padre(Object elementoHijo) {
        Object padre = null;

        if (!esVacio()) {
            if (raiz.getElemento().equals(elementoHijo)) {
            } else {
                NodoGen aux = raiz;
                padre = padreAux(aux, elementoHijo);
            }
        }
        return padre;
    }

    private Object padreAux(NodoGen nodo, Object buscado) {
        Object padre;
        if(nodo == null){
            padre = null;
        } else {
            if (esPadre(nodo.getHijoIzquierdo(), buscado)) {
                padre = nodo.getElemento();
            } else {
                padre = padreAux(nodo.getHijoIzquierdo(), buscado);
            }
            if (padre == null) {
                padre = padreAux(nodo.getHermanoDerecho(), buscado);
            }
        }
        return padre;
    }

    private boolean esPadre(NodoGen nodo, Object buscado){
        boolean rta = false;
        if (nodo != null) {
            if (nodo.getElemento().equals(buscado)) {
                rta = true;
            } else {
                rta = esPadre(nodo.getHermanoDerecho(), buscado);
            }
        }
        return rta;
    }

    public int altura(){
        int altura = - 1;
        if (!esVacio()) {
            NodoGen aux = raiz;
            altura = alturaAux(aux);
        }
        return altura;
    }

    private int alturaAux(NodoGen nodo){
        int altura;
        if (nodo == null) {
            altura = - 1;
        } else {
            altura = alturaHijos(nodo.getHijoIzquierdo()) + 1;
        }
        return altura;
    }
    
    private int alturaHijos(NodoGen nodo){
        int alt = - 1;
        if (nodo == null) {
            alt = - 1
        } else {
            while (nodo != null) {
                int aux = alturaAux(nodo);
                if (aux > alt) {
                    alt = aux;
                }
                nodo = nodo.getHermanoDerecho();
            }
        }
        return alt;
    }


}               