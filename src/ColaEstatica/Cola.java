package ColaEstatica;

public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[Cola.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elemento) {
        boolean exito = false;
        if ((fin + 1) % TAMANIO != frente) {
            arreglo[fin] = elemento;
            fin = (fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.esVacia()) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % Cola.TAMANIO; // Devuelve frente + 1
        }                                                    // devuelve 0 cuando frente + 1 = 10
        return exito;
    }
    
    public Object obtenerFrente(){
        Object elemento = null;
        if (!esVacia()) {
            elemento = arreglo[frente];
        }
        return elemento;
    }
    
    public boolean esVacia(){
        return frente == fin;
    }
    
    public void vaciar(){
        for (int i = 0; i < TAMANIO; i++) {
            arreglo[i] = null;
        }
        frente = 0;
        fin = 0;
    }
    
    public Cola clone(){
        Cola clon = new Cola();
        for (int i = 0; i < TAMANIO; i++) {
            clon.arreglo[i] = this.arreglo[i];
        }
        clon.frente = this.frente;
        clon.fin = this.fin;
        
        return clon;
    }
    
    public String toString(){
        String texto = "";
        
        for (int i = 0; i < TAMANIO; i++) {
            texto = texto + (String)arreglo[i] + "\n";
        }
        return texto;
    }

}
