package ColaDinamica;

public class Nodo {
    private Object elemento;
    private Nodo enlace;

    public Nodo(Object elemento, Nodo enlace){
        this.elemento = elemento;
        this.enlace = enlace;
    }
    
    public Object getElemento(){
        return elemento;
    }
    
    public Nodo getEnlace(){
        return enlace;
    }
    
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
}