package ColaEstatica;

public class Test {

    public static void main(String[] args) {
        Cola cola = new Cola();
        
        cola.poner("A");
        cola.poner("B");
        cola.poner("C");
        cola.poner("D");
        cola.poner("E");
        cola.sacar();
        cola.sacar();
        
        System.out.println(cola.toString());
    }

}