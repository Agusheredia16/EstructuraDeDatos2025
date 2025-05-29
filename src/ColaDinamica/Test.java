package ColaDinamica;

public class Test {

    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.poner("A");
        cola.poner("B");
        cola.poner("C");
        cola.poner("D");
        
        Cola clon = cola.clone();
        
        clon.poner("E");
        clon.sacar();

        System.out.println(clon.toString());
    }

}
